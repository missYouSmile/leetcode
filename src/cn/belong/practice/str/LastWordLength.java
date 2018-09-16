package cn.belong.practice.str;

import org.junit.jupiter.api.Test;

/**
 * leetcode NO. 58
 *
 * @author helios
 * @date 2018-09-16 19:57
 * @description
 */
public class LastWordLength {

    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
     * <p>
     * If the last word does not exist, return 0.
     * <p>
     * Note: A word is defined as a character sequence consists of non-space characters only.
     */
    public int lengthOfLastWord(String s) {

        if (s == null || s.length() == 0)
            return 0;

        s = s.trim();

        int len = 0;

        for (int length = s.length() - 1; length >= 0; length--) {
            if (s.charAt(length) == ' ')
                break;
            len++;
        }

        return len;
    }

    @Test
    public void test() {

        String s = "Hello World";

        System.out.println(lengthOfLastWord(s));

    }

}
