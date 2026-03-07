
public class Solution {
    public static int rev(int n) {
        if (n < 0)
            n = Math.abs(n);
        int ans = 0;
        while (n > 0) {
            ans = ans * 10 + (n % 10);
            n /= 10;
        }
                    
        return ans;
    }
    public static boolean isPalindrome(int n) {
        if (n < 0)
            n = Math.abs(n);
        return n == Solution.rev(n);
    }

    public static void main(String[] args) {
        System.out.println(Solution.isPalindrome(123321));
        System.out.println(Solution.isPalindrome(-123321));
        System.out.println(Solution.isPalindrome(1233210));

    }
}
