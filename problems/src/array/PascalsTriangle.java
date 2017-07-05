package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Created by twb0223 on 25/03/2017.
 *
 * Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangle
{
    public static void main(String[] args) throws Exception
    {
        System.out.println(new PascalsTriangle().getRow2(3));
    }

    public List<Integer> getRow(int rowIndex)
    {
        int k  = rowIndex;
        if(k == 0)
            return Arrays.asList(1);
        else if(k == 1)
            return Arrays.asList(1, 1);
        else if (k == 2)
            return Arrays.asList(1, 2, 1);
        List<Integer> result = new ArrayList<>();
        result.add(2);
        k = k - 2;
        int p, c;
        while(k-- > 0)
        {
            p = 1;
            int i = 0;
            for(int l = result.size(); i < l; i ++)
            {
                c = result.get(i);
                result.set(i, p + c);
                p = c;
            }
            result.add(p + 1);
        }
        result.add(0, 1);
        result.add(1);
        return result;
    }

    public List<Integer> getRow2(int rowIndex)
    {
        // rowIndex是0开始的，我们将它加1，得到k
        int k = rowIndex + 1;
        ArrayList<Integer> line = new ArrayList<Integer>();
        line.add(1);
        long tmp = 1;
        for(int i = 1; i < k; i++){
            // 使用公式 上一个数乘以(k-i)再除以i
            tmp = tmp * (k - i) / i;
            line.add((int)tmp);
        }
        return line;
    }

}
