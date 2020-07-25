package ArraySpecial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author Esmee Zhang
 * @date 7/24/20 6:20 下午
 * @projectName Leetcode
 */
public class FindAllDuplicatesInAnArray {
    /*
    * time O(N)
    * space none
    *
    * method travse the arry once mark x nums[abs(x) - 1]
    * to -x next time traverse back, when the number is
    * negative, then it is duplicated and add to the array
    * */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        for(int num : nums){
            if(nums[Math.abs(num) - 1] < 0){
                res.add(Math.abs(num));
            }
            nums[Math.abs(num) - 1] *= -1;
        }

        return res;
    }

    /*
    * use HashMap
    * */

    public List<Integer> findDuplicates2(int[] nums){
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)){
                res.add(num);
            }else{
                set.add(num);
            }
        }
        return res;
    }


}
