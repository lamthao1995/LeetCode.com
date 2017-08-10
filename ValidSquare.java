public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
      double p1p2 = distance(p1, p2);
      double p1p3 = distance(p1, p3);
      double p1p4 = distance(p1, p4);
      if(p1p2 == 0 || p1p3 == 0 || p1p4 ==0) return false;
      if(p1p2 == p1p3){
          double p2p4 = distance(p2,p4);
          double p3p4 = distance(p3,p4);
          if(p2p4 == p3p4 && p1p3 == p3p4){
              double cheo = cheo_dis(p3,p2);
              double canh = cheo_dis(p1,p2);
             if(cheo == 2 * canh) return true;
          }
      }
      if(p1p2 == p1p4){
          double p2p3 = distance(p2,p3);
          double p3p4 = distance(p3,p4);
          if(p2p3 == p3p4 && p2p3 == p1p4){
               double cheo = cheo_dis(p2,p4);
                double canh = cheo_dis(p1,p2);
             if(cheo == 2 * canh) return true;
          }
      }
      if(p1p3 == p1p4){
         
          double p2p4 = distance(p2,p4);
          double p2p3 = distance(p3,p2);
          if(p2p3 == p2p4 && p2p3 == p1p4){
             double cheo = cheo_dis(p3,p4);
              double canh = cheo_dis(p1,p3);
             if(cheo == 2 * canh) return true;
          }
      }
      return false;
    }
    public double distance(int[] x, int y[]){
        return (double)Math.sqrt((x[1] - y[1]) *(x[1] - y[1])  + (x[0] - y[0])*(x[0] - y[0]));
    }
     public double cheo_dis(int[] x, int y[]){
        return (double)(x[1] - y[1]) *(x[1] - y[1])  + (x[0] - y[0])*(x[0] - y[0]);
    }
}