package cn.belong.practice.str;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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

    public int myAtoi2(String str) {

        if (str == null || str.trim().isEmpty())
            return 0;

        str = str.trim();

        int sign = 1;
        int index = 0;

        if (str.charAt(index) == '-') {
            sign = -1;
        }

        if (str.charAt(index) == '-' || str.charAt(index) == '+')
            index++;

        List<Integer> rl = new ArrayList<>();

        while (index < str.length()) {
            if (list.contains(str.charAt(index))) {
                rl.add(str.charAt(index) - '0');
                index++;
            } else {
                break;
            }
        }

        Iterator<Integer> iterator = rl.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 0) {
                iterator.remove();
            } else {
                break;
            }
        }

        long carry = 10;
        long ret = 0;

        for (int i = 0; i < rl.size(); i++) {
            long temp = rl.get(i);
            ret = ret * carry + temp;
            if (sign == 1 && ret > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && -ret < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int) ret * sign;
    }

    @Test
    public void test() {
        System.out.println(myAtoi2("4193 with words"));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}
