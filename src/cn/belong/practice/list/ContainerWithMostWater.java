package cn.belong.practice.list;

/**
 * leetcode NO. 11
 *
 * @author helios
 * @date 2018-09-09 11:57
 * @description
 */
public class ContainerWithMostWater {

    /**
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate
     * (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and
     * (i, 0). Find two lines, which together with x-axis forms a container, such that the container
     * contains the most water.
     * <p>
     * Note: You may not slant the container and n is at least 2.
     */
    public int maxArea01(int[] height) {

        int maxContainer = 0;

        for (int i = 0; i < height.length - 1; i++) {
            int hi = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int hj = height[j];
                maxContainer = Math.max(Math.min(hi, hj) * (j - i), maxContainer);
            }
        }
        return maxContainer;
    }

    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int maxContainer = 0;
        while (low < high) {
            int curContainer;
            int width = high - low;
            if (height[low] < height[high]) {
                curContainer = height[low] * width;
                low++;
            } else {
                curContainer = height[high] * width;
                high--;
            }
            maxContainer = Math.max(curContainer, maxContainer);
        }
        return maxContainer;
    }

}
