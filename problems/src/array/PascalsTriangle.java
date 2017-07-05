package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Created by twb0223 on 25/03/2017.
 * <p>
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p>
 * For example, given k = 3,
 * Return [1,3,3,1].
 * <p>
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangle {
    public static void main(String[] args) throws Exception {
        System.out.println(new PascalsTriangle().getRow(3));
    }
    private List<Integer> getRow(int rowIndex) {
        // rowIndex是0开始的，我们将它加1，得到k
        int k = rowIndex + 1;
        ArrayList<Integer> line = new ArrayList<>();
        line.add(1);
        long tmp = 1;
        for (int i = 1; i < k; i++) {
            // 使用公式 上一个数乘以(k-i)再除以i
            tmp = tmp * (k - i) / i;
            line.add((int) tmp);
        }
        return line;
    }

}
