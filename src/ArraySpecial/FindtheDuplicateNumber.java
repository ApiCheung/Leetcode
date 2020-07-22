package ArraySpecial;

/**
 * @author Esmee Zhang
 * @date 7/22/20 12:34 下午
 * @projectName Leetcode
 */
public class FindtheDuplicateNumber {
    /*
    * use the special property of the list reconstruct the list
    * time O(N) space(1)
    * */

    public int findDuplicate(int[] nums) {

        if (nums == null || nums.length < 2)
            return -1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]])
                    return nums[i];
                else {
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
        }
        return -1;

    }
}
