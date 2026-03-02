public class Solution {

    public long fibonacci(long n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fibonacci(0));
        System.out.println(solution.fibonacci(1));
        System.out.println(solution.fibonacci(2));
        System.out.println(solution.fibonacci(5));
        System.out.println(solution.fibonacci(6));

    }

} 

