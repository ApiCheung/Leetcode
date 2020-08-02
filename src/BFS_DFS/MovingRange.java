package BFS_DFS;

/**
 * @author Esmee Zhang
 * @date 8/2/20 3:50 下午
 * @projectName Leetcode
 */
public class MovingRange {
    int k,m,n;
    boolean[][] visited;
    public int movingCount(int m, int n, int k ){
        visited = new boolean[m][n];
        this.m = m;
        this.n = n;
        this.k = k;
        return dfs(0,0);
    }
    public int dfs(int i, int j){
        if(i>=m || j>=n || count(i,j) > k || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1+dfs(i+1,j) + dfs(i, j+1);
    }
    public int count(int i, int j){
        int sum = 0;
        while(i !=0){
            sum += i%10;
            i /=10;

        }
        while(j != 0 ){
            sum += j%10;
            j /=10;
        }
        return sum;
    }
}
