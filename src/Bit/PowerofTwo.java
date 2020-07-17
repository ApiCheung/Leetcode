package Bit;

/**
 * @author Esmee Zhang
 * @date 7/17/20 4:47 下午
 * @projectName Leetcode
 */
public class PowerofTwo {
    /*use bit operand

     4: 2^2 give an x to value weather it is the power of 2
     the charater is the first bit is 1 and only have 1 1 bit
     x != 0 or < 0
     then take x & (x-1) == 0

     eg: x & 1 == 1 or == 0 x is odd or even
         x = x & (x-1) remove the lowest bit 1 can take how many 1 in a number
         x & -x => get the lowest 1 its position

    */
    public boolean isPowerOfTwo(int n) {
        if (n == 0 || n < 0) return false;
        return (n & (n - 1)) == 0;
    }
}
