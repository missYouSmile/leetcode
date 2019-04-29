package cn.belong.practice.str;

/**
 * leetcode NO 9. Palindrome Number
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        String value = String.valueOf(x);
        int low = 0;
        int high = value.length() - 1;
        while (low < high) {
            if (value.charAt(low) != value.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

}
