package cn.belong.practice.str;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode NO. 8
 *
 * @author helios
 * @date 2018-09-15 12:54
 * @description
 */
public class StringToInteger {

    List<Character> list = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    List<Character> l = Arrays.asList('-', '+');

    public int myAtoi(String str) {

        if (str == null || str.trim().length() == 0)
            return 0;

        str = str.trim();

        char first = str.charAt(0);

        if (!l.contains(first) && !list.contains(first)) {
            return 0;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            if (list.contains(str.charAt(i)))
                builder.append(str.charAt(i));
            else
                break;
        }

        if (builder.toString().isEmpty() && l.contains(first))
            return 0;

        BigDecimal bigDecimal = new BigDecimal(first + builder.toString());

        int ret;

        if (bigDecimal.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE)) > 0) {
            ret = Integer.MAX_VALUE;
        } else if (bigDecimal.compareTo(BigDecimal.valueOf(Integer.MIN_VALUE)) < 0)
            ret = Integer.MIN_VALUE;
        else
            ret = bigDecimal.intValue();

        return ret;
    }

    @Test
    public void test() {
        System.out.println(myAtoi("-91283472332"));
    }
}
