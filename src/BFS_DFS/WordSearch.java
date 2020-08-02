package BFS_DFS;

/**
 * @author Esmee Zhang
 * @date 8/2/20 2:39 下午
 * @projectName Leetcode
 */
public class WordSearch {
    /*
    * backtracking and DFS
    * time O(MN)
    * space O(K)
    * */
    public boolean exist(char[][] board, String word){
        char[] words = word.toCharArray();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;

    }
    public boolean dfs(char[][] board, char[] word, int i, int j, int k){
        if(i>= board.length || j >= board[0].length || i < 0 || j <0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;

        char temp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i+1, j, k+1) || dfs(board, word, i-1, j, k+1)
                || dfs(board, word, i , j+1, k+1) || dfs(board, word, i, j-1, k+1);
        board[i][j] = temp;
        return res;
    }
}
