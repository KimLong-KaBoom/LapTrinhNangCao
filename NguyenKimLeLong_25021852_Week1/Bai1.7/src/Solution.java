public class Solution {
    public static int reverseNumber(int n) {
        int reversed = 0;
        boolean isNegative = n < 0;
        if (isNegative) {
            n = -n;
        }
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        
        return isNegative ? -reversed : reversed;
    }
    
    public static void main(String[] args) {
        int num = 12345;
        System.out.println(reverseNumber(num));
        
        int num2 = -6789;
        System.out.println(reverseNumber(num2));
    }
}