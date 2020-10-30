//128
//o(n) need to use the hash table
//record the boundary of the sequence
class Solution{
	public int longestConsecutive(int[] num){
		//when n come in check whether n-1 n+1 in the hash table
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int n : num){
		if(!map.containsKey(n)){
			//left and right is the length of 2 sequence
			int left = (map.containsKey(n - 1)) ? map.get(n-1) : 0;
			int right = (map.containsKey(n + 1)) ? map.get(n+1) : 0;
			int sum = left + right + 1;
			map.put(n, sum);

			//update the max
			res = Math.max(res, sum);

			//extend the length to the boundary of sequence will do nothing if n has no neighbots
			map.put(n - left, sum);
			map.put(n + right, sum);
		}else{
			continue;
		}
	}

	return res;
}

/*
[100, 4, 200, 1, 3, 2]
100 res = 0   left = 0 right = 0 sum = 1 [100, 1] res = 1  
4  res = 1 left = 0; right = 0 sum = 1 [4, 1]
200 res = 1 left = 0; right = 0 sum = 1  [200, 1]
1  res = 1 left = 0; right = 0 sum = 1 [1,1]
3  res = 1 left = 0, right = get(4) - > 1 sum = 0 + 1 + 1 = 2 [3, 2] res = 2 [4, 2]
2 res = 2 left = get(1) - >1 right = get(3) - > 2 sum = 1 + 2 + 1 = 4 [2, 4] res = 4 [2-1, 4] [2+2, 4]
*/