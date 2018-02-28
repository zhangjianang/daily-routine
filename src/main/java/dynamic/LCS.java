package dynamic;

/**
 * Created by adimn on 2018/1/15.
 */
public class LCS {
        public int findLCS(String A, int n, String B, int m) {
            // write code here
            int[][] dp = new int[n][m];
            char[] a = A.toCharArray();
            char[] b = B.toCharArray();
            for(int i=0;i<n;i++){
                if(a[i]==b[0]){
                    dp[i][0] = 1;
                    for(int j=i+1;j<n;j++){
                        dp[j][0] = 1;
                    }
                    break;
                }

            }
            for(int i=0;i<m;i++){
                if(a[0]==b[i]){
                    dp[0][i] = 1;
                    for(int j=i+1;j<m;j++){
                        dp[0][j] = 1;
                    }
                    break;
                }

            }
            for(int i=1;i<n;i++){
                for(int j=1;j<m;j++){
                    if(a[i]==b[j]){
                        dp[i][j] = max(dp[i-1][j-1]+1,dp[i-1][j],dp[i][j-1]);
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }

                }
            }

            return dp[n-1][m-1];
        }
        public int max(int a,int b,int c){
            int max = a;
            if(b>max)
                max=b;
            if(c>max)
                max = c;
            return max;
        }

    public static void main(String[] args) {
        LCS lc =  new LCS();
        String f1 = "wearethechampion";
        String f2 = "wekeeponthechampiontilltheendweare";
        System.out.println(lc.findLCS(f1,f1.length(),f2,f2.length()));

        System.out.println(lc.findLCS("1A2C3D4B56",10,"B1D23CA45B6A",12));
    }
}
