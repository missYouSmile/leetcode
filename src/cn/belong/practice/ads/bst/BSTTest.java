package cn.belong.practice.ads.bst;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

/**
 * @author shiwen.chen
 * @date 2018-09-14 21:09
 */
public class BSTTest {

    @Test
    public void preOrderTest() {

        BST<Integer> bst = new BST<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            bst.add(random.nextInt(100000));
        }

        List<Integer> list = bst.preOrder();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1))
                throw new RuntimeException("this is not a BST");
        }
        System.out.println(list);
        Integer min = bst.removeMin();
        System.out.println("min = " + min);
        System.out.println(bst.preOrder());
        bst.add(1);
        System.out.println(bst.preOrder());
        Integer max = bst.removeMax();
        System.out.println(max);
        System.out.println(bst.preOrder());

    }

}
