package TwoPointer;

/**
 * @author Esmee Zhang
 * @date 8/1/20 1:05 下午
 * @projectName Leetcode
 */
public class FindMinimuminRotatedSortedArray {

        /*
        * binary  search
        * the mid number need to compare with num[j] not num[i]
        *
        */

    public int findMin(int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0, j = nums.length - 1;

        while(i != j){
            int mid = (j + i)/2;
            if(nums[mid] < nums[j]){
                j = mid;
            }else if(nums[mid] > nums[j]){
                i = mid + 1;
            }else{
                j --;
            }
        }
        return nums[i];
    }
}
