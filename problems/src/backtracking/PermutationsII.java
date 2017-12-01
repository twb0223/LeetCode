package backtracking;

import javafx.scene.paint.Stop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by twb0223 on 12/04/2017.
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class PermutationsII {
    public static void main(String[] args) {
        int[] A = {1, 2, 4};
        new PermutationsII().arrange(A, 0, A.length);

    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        nextPermutation(0, nums, result);
        return result;
    }

    private void nextPermutation(int i, int[] nums, List<List<Integer>> result) {
        if (i == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums)
                list.add(n);
            result.add(list);
        } else {
            for (int j = i, l = nums.length; j < l; j++) {
                if (j > i && nums[j] == nums[i]) continue;
                swap(nums, i, j);
                nextPermutation(i + 1, Arrays.copyOf(nums, nums.length), result);
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * @param nums
     * @param start
     * @param len
     */

    private static void arrange(int[] nums, int start, int len) {
        if (start == len - 1) {
            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
            }
            System.out.println();
            return;
        }
        for (int i = start; i < len; i++) {
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
            arrange(nums, start + 1, len);
            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
        }
    }
}
