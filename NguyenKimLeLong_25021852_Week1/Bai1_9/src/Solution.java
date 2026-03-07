
public class Solution {
    public int sumOfDigits(int n) {
        if (n < 0)
            n = Math.abs(n);
        int ans = 0;
        while (n > 0) {
            ans += (n % 10);
            n /= 10;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumOfDigits(123456789));
        System.out.println(solution.sumOfDigits(-123456789));
        System.out.println(solution.sumOfDigits(0));

    }
    
}
