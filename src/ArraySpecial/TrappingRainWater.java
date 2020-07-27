package ArraySpecial;

/**
 * @author Esmee Zhang
 * @date 7/26/20 10:02 下午
 * @projectName Leetcode
 */
public class TrappingRainWater {
    /*
    * two pointer
    * */
    public int trap(int[] height) {
        int rightmax = 0;
        int leftmax = 0;
        int water = 0;
        int left = 0, right = height.length - 1;
        while(left < right){
            rightmax = Math.max(rightmax, height[right]);
            leftmax = Math.max(leftmax, height[left]);

            if(leftmax < rightmax){
                water += (leftmax - height[left]) * 1;
                left ++;
            }else{
                water += (rightmax - height[right] * 1);
                right --;
            }

        }
        return water;

    }
}
