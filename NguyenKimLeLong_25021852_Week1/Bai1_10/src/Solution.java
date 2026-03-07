
public class Solution {
    public int firstLargest(int[] arr) {
        int ans = 0;
        for (int j : arr) {
            ans = Math.max(ans, j);
        }
        return ans;
        
    }
    public int secondLargest(int[] arr) {
        int ans = -1;
        int x;
        x = firstLargest(arr);
        for (int j : arr)
            if (j != x)
                ans = Math.max(ans, j);

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
            solution.secondLargest(new int[]{1, 2, 3, 4, 5})
        );
        System.out.println(
            solution.secondLargest(new int[]{1, 1, 1, 1, 1})
        );
        System.out.println(
            solution.secondLargest(new int[]{0})
        );
        System.out.println(
            solution.secondLargest(new int[]{5, 4, 3, 2, 1})
        );
    }
}
