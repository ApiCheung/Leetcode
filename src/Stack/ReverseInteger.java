package Stack;

import java.util.Stack;

/**
 * @author Esmee Zhang
 * @date 7/27/20 4:41 下午
 * @projectName Leetcode
 */
public class ReverseInteger {
    public int reverse(int x) {
        /*
        * this question need o consider the overflow
        * To explain, lets assume that \text{rev}rev is positive.

If temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop causes overflow, then it must be that \text{rev} \geq \frac{INTMAX}{10}rev≥
10
INTMAX
​

If \text{rev} > \frac{INTMAX}{10}rev>
10
INTMAX
​
 , then temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop is guaranteed to overflow.
If \text{rev} == \frac{INTMAX}{10}rev==
10
INTMAX
​
 , then temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop will overflow if and only if \text{pop} > 7pop>7
Similar logic can be applied when \text{rev}rev is negative.


        *
        * time O(log(x)
        * */

        int rev = 0;
        while(x != 0){
            int pop = x %10;
            x /=10;
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7)) return 0;
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
