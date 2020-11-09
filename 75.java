class Solution {
    public void sortColors(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return;
        
        int start = 0;
        int end = nums.length -1;
        int index = 0;
        
        while(index <= end && start < end){
            if(nums[index] == 0){
                nums[index] = nums[start];
                nums[start] = 0;
                start ++;
                index ++;
            }else if(nums[index] == 2){
                nums[index] = nums[end];
                nums[end] = 2;
                end --;
            }else{
                index ++;
            }
        }
        
    }
}
/*using bucket sort*/
/*
public void sortColors(int[] A){
    int[] num = {0, 0, 0};
    for(int i=0: i<A.length; i++){
        num[A[i]]++;
    }
    
    for(int i=0; i<num[0]; i++){
        A[i] = 0;
    }
    for(int i=num[0]; i<num[0]+num[1]; i++){
        A[i] = 1;
    }
    for(int i=num[0]+num[1]; i<A.length; i++){
        A[i] = 2;
    }
}
*/