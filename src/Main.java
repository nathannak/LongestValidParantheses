public class Main {

    public static void main(String[] args) {
        System.out.println( longestValidParentheses("()(())") );
    }

    public static int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int result = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0){

                //we hit a ( ... ) or () case so increase dp[i-1] by 2 and put it in dp[i]
                dp[i] = dp[i - 1] + 2;

                //to get max length of valid parentheses; go back to before latest (...) or () happened and add it to dp[i]
                //which interprets to check if i - dp[i]>=0 and if so add dp[i - dp[i]] to dp[i]
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                result = Math.max(result, dp[i]);
                leftCount--;
            }
        }
        return result;
    }

}
