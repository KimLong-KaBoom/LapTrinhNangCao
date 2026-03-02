
public class Solution {
    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static void main(String[] args) {
        Solution ans = new Solution();
        
        System.out.println(ans.gcd(5, 15));
        System.out.println(ans.gcd(16, 18));
    }
}
