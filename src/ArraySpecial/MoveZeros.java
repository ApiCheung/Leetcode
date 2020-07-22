package ArraySpecial;

import java.util.ArrayList;

/**
 * @author Esmee Zhang
 * @date 7/21/20 7:32 下午
 * @projectName Leetcode
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> nonZero = new ArrayList<>();
        ArrayList<Integer> zero = new ArrayList<>();


        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nonZero.add(nums[i]);
            }else{
                zero.add(nums[i]);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(nonZero);
        result.addAll(zero);
        System.out.println(result);






    }

    /*
     * solution with insert
     * */

    public void moveZeros2(int[] nums){
        if(nums == null || nums.length == 0) return;

        int insertPos = 0;
        for(int num: nums){
            if(num != 0) nums[insertPos++] = num;
        }
        while(insertPos < nums.length){
            nums[insertPos++] = 0;
        }
    }
}

