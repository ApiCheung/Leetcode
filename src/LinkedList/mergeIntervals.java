package LinkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Esmee Zhang
 * @date 7/21/20 8:04 下午
 * @projectName Leetcode
 */
public class mergeIntervals {
    /*
    * find the start and end and sorted them.
    *
    * 1 4 6 8
    * 2 7 9 10
    *  take 1 2 find 2 less than 4 so 12 add to result 47 7 bigger than 6
    * so we take 4 but take 9 9 is bigger than 9 so take 10
    * time O(nlogn) space could be 1 or n
    * */
    public int[][] merge(int[][] intervals){
        if(intervals == null || intervals.length == 0){
            return new int[0][];
        }

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        List<int[]> result = new LinkedList<>();
        for(int i = 0; i< intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int j = 0;
        for(int i = 0; i < intervals.length - 1; i++){
            if(start[i + 1] > end[i]){
                result.add(new int[] {start[j], end[i]});
                j = i + 1;
            }

        }
        //need to add last one
        result.add(new int[]{start[j], end[intervals.length - 1]});
        return result.toArray(new int[result.size()][]);
    }


}
