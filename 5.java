//5
//intuitively dp problem

//100 most n2 or will exceed time limit
class Solution{
	public String longestPalindrome(String s){
		//单个字符也是palindrome 
		// boolean[][]来记录当前是否为panlin
		//i j 从index为i到j这个 substring 是否为 panline
		//init boolean[i][i] = true 单个一定是true
		// 【i】【i+1】是否为相同的 
		//转移方程： 长度为1 长度为2。【i】【j】 = flase if 【i】！= 【j】 则 【i+1】【j-1】 是不是回文

		//check length = 1
		if(s == null || s.length() == 0) return s;
		int n = s.length();
		char[] c = s.toCharArray();
		//need to remeber the length of the string
		int start = 0;
		int length = 1;

		boolean[][] dp = new boolean[n][n];
		for(int i=0; i<n; i++){
			dp[i][i] = true;
		}

		//check length =2

		for(int i=0; i<n-1; i++){
			if(c[i] == c[i+1]){
			 dp[i][i+1] = true;
			start = i;
			length = 2;
		}
		}

		//check length 1-3 2-4 3-5 1-4 2-5

		for(int i=3; i<=n; i++){
			//j是起点 j到i
			for(int j=0; j+i-1 < n; j++){
				if(c[j] == c[j+i-1] && dp[j+1][j+i-2] == true){
					dp[j][j+i-1] = true;
					//为什么不需要判断？ 从小到大来检查的 
					start = j;
					length = i;
				}
			}

		}
		return s.substring(start, start+length);


	}
}