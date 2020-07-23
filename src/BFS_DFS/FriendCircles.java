package BFS_DFS;

import javax.swing.*;
import javax.xml.xpath.XPathNodes;
import java.util.Arrays;

/**
 * @author Esmee Zhang
 * @date 7/23/20 10:08 上午
 * @projectName Leetcode
 */
public class FriendCircles {
    /*
    * need to find M[i][i] is 1 or not
    *
    * 1. use DFS
    * this is an undirected graph need to find how many connected
    * element
    * Time O(N^2)
    * Space O(N)
    * */
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }




    /*
     * method 2 union find determine the number of connected components in a
     * graph
     *
     *
     * */

    int find(int parent[], int i){
        if(parent[i] == -1) return i;

        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);
        if(xset != yset) parent[xset] = yset;
    }

    public int findCircleNum1(int[][] M){
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M.length; j++){
                if(M[i][j] == 1 && i != j){
                    union(parent, i, j);
                }

            }
        }
        int count = 0;
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == -1) count++;
        }
        return count;

    }
}

