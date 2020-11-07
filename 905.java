//905

//this kind of easy problem make me fly.....
//easy 2 pointer
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while(i < j){
            if(A[i] % 2 == 0 && A[j] % 2 == 0) i++;
            if(A[i] %2 !=0 && A[j] % 2 !=0 ) j--;
            
            if(A[i] % 2 != 0 && A[j] % 2 == 0){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            }
            if(A[i] % 2 == 0 && A[j] %2 !=0 ){
                i++;
                j--;
            }
        }
        
        return A;
        
    }
    
    
}