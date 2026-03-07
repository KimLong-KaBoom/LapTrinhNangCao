
public class Solution {
    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; ++i)
            if (n % i == 0)
                return false;
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(Solution.isPrime((17)));
        System.out.println(Solution.isPrime((18)));

    }
}
