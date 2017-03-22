package Zawoo;

public class SmallestPositive
{
	public static int SmallestPositive1To20()
	{
	    // temp return storage
	    int ret = 1;
	    
	    // calculate smallest positive
	    for (int i = 1; i <= 10; i++)
	    {
	        // 1st iteration: ret = 1   (ret = 1,  i = 1)
	        // 2nd iteration: ret = 2   (ret = 1,  i = 2)
	        // 3rd iteration: ret = 6   (ret = 2,  i = 3)
	        // 4th iteration: ret = 12  (ret = 6,  i = 4)
	        // 5th iteration: ret = 60  (ret = 12, i = 5)
	        // 6th iteration: ret = 60  (ret = 60, i = 6)
	        // 7th iteration: ret = 480 (ret = 60, i = 7)
	        
	        // recurse for the lowest common multiple
	        ret = LCM(ret, i);
	    }
	    
	    return ret;
	}
	
	public static int GCD(int divisor, int dividend)
	{
	    int temp = 0;
	    
	    while (divisor != 0)
	    {
	        // Euclid's Algorithm
	        // any number divided by another that produces a remainder,
	        // the remainder can be used as the divisor into the quotient,
	        // which is now the dividend.
	        
	        // for example:
	        // given two integers, 60 (dividend) and 7 (divisor)
	        
	        // example for modulus
	        // 3 % 2 = 1
	        // 2 % 3 = 3  <-- important

	        // dvd     dvs   qt r(m)
	        //  60  /   7  = 8q 4r
	        //  7   /   4  = 1q 3r
	        //  4   /   3  = 1q 1r
	        //  3   /   1  = 3q
	        //  1   /   3  
	        
	        // GCD (12, 5) = 1
	        
	        // store current
	        temp = divisor;
	        
	        // get remainder (modulus); assign as new divisor
	        divisor = dividend % divisor;
	        
	        // set current divisor as new dividend
	        dividend = temp;
	    }
	    
	    return dividend;
	}
	//                         60          7
	public static int LCM(int int_1, int int_2)
	{
	    // return lowest common multiple of two integers
	    return (int_1 * (int_2 / GCD(int_1, int_2)));
	}
}
	    
	    