public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] rs = new int[length];
        for(int[] update : updates){
            int start = update[0];
            int end = update[1];
            int val = update[2];
            rs[start] += val;
            if(end < length - 1)
                rs[end + 1] -= val;
        }
        partialSum(rs);
        return rs;
    }
    public void partialSum(int[] rs){
        for(int i = 1; i < rs.length; i++)
            rs[i] = rs[i - 1] + rs[i];
    }
}
// vector<int> getModifiedArray(int length, vector<vector<int> > updates)
// {
//     vector<int> result(length, 0);

//     for (auto& tuple : updates) {
//         int start = tuple[0], end = tuple[1], val = tuple[2];

//         result[start] += val;
//         if (end < length - 1)
//             result[end + 1] -= val;
//     }

//     // partial_sum applies the following operation (by default) for the parameters {x[0], x[n], y[0]}:
//     // y[0] = x[0]
//     // y[1] = y[0] + x[1]
//     // y[2] = y[1] + x[2]
//     // ...  ...  ...
//     // y[n] = y[n-1] + x[n]

//     partial_sum(result.begin(), result.end(), result.begin());

//     return result;
// }