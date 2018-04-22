/**
 * 题目名称：局部最小值
 * 题目描述：定义局部最小的概念。arr长度为1时，arr[0]是局部最小。
 * arr的长度为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；
 * 如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；如果0<i<N-1，
 * 既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等，
 * 写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 */
public class Solution {
    /**
     * 思路：
     * 1.数组为空或者长度为0则返回-1
     * 2.数组长度为1则返回arr[0]
     * 3.数组长度大于1的情况下，如果第一个元素小于第二个元素，那么第一个元素是最小的
     *   如果最后一个数小于倒数第二个数，那么最后一个数是最小的
     * 4.如果i位于数组中间，它既小于左边的数又小于右边的数，那么i是最小的
     *   如果i大于左边的数但是小于右边的数，递归二分左边
     *   如果i大于右边的数但是小于左边边的数，递归二分右边
     * 最优解时间复杂度为：O(logn)
     */
    public int getLessIndex(int[] arr) {
        // 1.数组为空或者长度为0则返回-1
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 2.数组长度为1则返回arr[0]
        if (arr.length == 1) {
            return 0;
        }
        // 3.数组长度大于1的情况下，如果第一个元素小于第二个元素，那么第一个元素是最小的
        if (arr[0] < arr[1]) {
            return 0;
        }
        // 如果最后一个数小于倒数第二个数，那么最后一个数是最小的
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        // 4.如果i位于数组中间，它既小于左边的数又小于右边的数，那么i是最小的
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) { // 中间的最小
                return mid;
            }
            if (arr[mid] > arr[mid - 1]) { // 向左有减少的趋势
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) { // 向右有减少的趋势
                left = mid + 1;
            }
        }
        return -1;
    }
}