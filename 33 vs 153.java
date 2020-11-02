//33
public int search(int[] nums, int target){
	if(nums == null || nums.length == 0) return -1;

	int start = 0;
	int end = nums.length - 1;
	while(start + 1 < end){
		int mid = (end - start) / 2 + start;
		if(nums[mid] == target) return mid;
		//判断前半段是否为递增
		if(nums[start] < nums[mid]){
			if(nums[start] <= target && target <= nums[mid]){
				end = mid;
			}else{
				start = mid;
			}
		}else{
			if(nums[mid] <= target && target <= nums[end]){
				start = mid;
			}else{
				end = mid;
			}
		}
	}

	if(nums[start] == target) return start;
	if(nums[end] == target) return end;
	return -1;
}

//153

public int finMin(int[] nums){
	//same useing the binary search
	if(nums.length == 0) return 0;
	int start = 0;
	int end = nums.length - 1;
	
	while( start != end){
		int mid = (end + start) / 2;
		if(nums[mid] < nums[end]){
			end = mid;
		}else if(nums[mid] > nums[end]){
			start = mid + 1;
		}else{
			end --;
		}
	}
	return nums[start];
}

/**[34512]
	start = 0 end = 4
	mid = 2 nums[2] = 5 nums[end] = 2 start = 3
	mid = 3+4/2 = 3 nums[3] = 1 nums[end] = 2 1<3 end = 3 
	start = end nums[start] = 1
