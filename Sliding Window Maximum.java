public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len == 0){
            int[] d = new int[0];
            return d;
        }
        SegmentTree tree = new SegmentTree();
        tree.construct(nums, len);
        int num = len - k + 1;
        int[] rs = new int[num];
        //System.out.print("range from 1 to 1 : " + tree.rmq(1, 1, len) +" and total number: " + len);
        for(int i = 0; i < num; i++){
            rs[i] = tree.rmq(i, i + k - 1, len);
        }
        return rs;
    }
    class SegmentTree{
        int st[];
        private int maxVal(int x, int y){
            return x > y ? x : y;
        }
        private int getMid(int x, int y){
            return x + (y - x) / 2;
        }
        private int rmqUtil(int ss, int se, int qs, int qe, int index){
            if(qs <= ss && qe >= se){
                return st[index];
            }
            if(se < qs || ss > qe)
                return Integer.MIN_VALUE;
            int mid = getMid(ss, se);
            return maxVal(rmqUtil(ss, mid, qs, qe, 2 * index + 1),
                      rmqUtil(mid + 1, se, qs, qe, 2 * index + 2));
        }
        public int rmq(int qs, int qe, int n){
            if(qs < 0 || qe > n - 1 || qs > qe)
                throw new IllegalArgumentException("Invalid input");
            return rmqUtil(0, n - 1, qs, qe, 0);
        }
        private int construct(int[] arr, int ss, int se, int si){
            if(ss == se){
                st[si] = arr[ss];
                return arr[ss];
            }
            int mid = getMid(ss, se);
            st[si] = maxVal(construct(arr, ss, mid, 2 * si + 1),
                            construct(arr, mid + 1, se, 2 * si + 2));
            return st[si];
        }
        public void construct(int arr[], int n){
            int num = (int)Math.ceil(Math.log(n) / Math.log(2));
            int max_size = 2 * (int)Math.pow(2, num) - 1;
            st = new int[max_size];
            construct(arr, 0, n - 1, 0);
        }
    }
}