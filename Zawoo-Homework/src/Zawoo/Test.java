package Zawoo;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

public class Test {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu();

		//Baseball.ShowDistances();
		//System.out.println(SmallestPositive.SmallestPositive1To20());
	}
	
	public static void Menu()
	{
		String ret = "";
		boolean quit = false;
		
		do
	    {
			// display menu of methods
		    System.out.println("Welcome to Lab 5");
		    System.out.println("1. PI approximation");
			System.out.println("2. Weight Calculation");
			System.out.println("3. Gymnastics Judging");
			System.out.println("4. Quarterback Rating");
			System.out.println("5. Finding Average and Counting");
			System.out.println("6. Hurricane Categories");
			System.out.println("7. Sound Speed");
			System.out.println("9. Random String");
			System.out.println("8. Exit");
		    System.out.println();
		    System.out.println("Please select option [1-8]:");
			
		    // check for valid numeric entry
	    	ret = input.nextLine();
	        
	        try
		    {
				int menu = Integer.parseInt(ret);
				
		        // validate range of entry
		        if (menu == 1)
		        {
		        	System.out.println("Please enter number of terms to sum:");
		        	
		        	int num = input.nextInt();
		        	
		        	// read carriage return from input (ignore value)
		        	input.nextLine();
		        	
		        	// print out PiApproximation result
		        	System.out.println(PiApproximation(num));
		        }
		        else if (menu == 2) // calculateWeight()
		        {
		        	System.out.println("Please enter mass in kilograms:");
		        	
		        	double mass = input.nextDouble();
		        	
		        	// read carriage return from input (ignore value)
		        	input.nextLine();
		        	
		        	System.out.println(calculateWeight(mass));
		        }
		        else if (menu == 3) gymnasticsJudging();
		        else if (menu == 4) QuarterbackRating();
		        else if (menu == 5) AverageAndCounting();
		        //else if (menu == 6) hurricaneCategories();
		        else if (menu == 7) System.out.println(SoundSpeed(DisplayMenu()));
		        else if (menu == 9) System.out.println(Arrays.toString(RandomString()));
		        else if (menu == 10) LongestCommon();
		        else if (menu == 8) quit = true;
		        else continue;
		    }
		    catch (Exception ex)
		    {
		    	System.out.println(ex.getMessage());
		    	ex.printStackTrace();
		        System.out.println("That's not a valid menu selection. Please try again.");
		    }
	    } while (!quit);
	
	}
	
	public static void LongestCommon()
	{
	    String s1 = "";
	    String s2 = "";
	    String longestCommon = "";
	    String tempCommon = "";
	    int charIndex = 0;
	    
	    // prompt user for first string
	    System.out.println("Please enter a string:");
		    
	    // store entered text
	    s1 = input.nextLine();
	    
	    // prompt user for second string
	    System.out.println("Please enter a second string:");
		    
	    // store entered text
	    s2 = input.nextLine();
	    
	    // compare strings for common substring
	    for (int i = 0; i < s1.length(); i++)
	    {
	    	// set initial character
	    	if (tempCommon.length() == 0)
	    		tempCommon = s1.substring(i, i + 1);
	    	else
	    		tempCommon += s1.substring(i, i + 1);
	    	
	    	// index for found character; -1 if not found
	        charIndex = s2.indexOf(tempCommon);
	        
	        // search s2 for current character
	        if (charIndex == -1)
	        {
	        	// reset temp
	            tempCommon = "";
	        }
	        else
	        {
	        	// compare current match with longest and update if needed
	            if (tempCommon.length() > longestCommon.length())
	                longestCommon = tempCommon;
	        }	            
	    }

	    // return longest common substring
	    JOptionPane.showMessageDialog(null, "The longest common substring is: " + longestCommon);
	}
	
	public static String[] RandomString()
	{
	    // alphabet array for random string generation
	    char [] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	    String[] retValue = new String[8];
	    
	    // loop to create random strings
	    for (int i = 0; i < 8; i++)
	    {
	        // get a random value between 6 and 12 for string length
	        Random randomLength = new Random();
	        
	        // string to hold randomly generated value
	        String randomValue = "";
	        
	        // loop to grab random characters
	        for (int j = 0; j < (randomLength.nextInt((12 - 6) + 1) + 6); j++)
	        {
	            // create random index value
	            Random randomIndex = new Random();
	            
	            // get random index from array
	            randomValue += alphabet[randomIndex.nextInt(52)];
	        }
	        
	        // store randomly generated value in return array
	        retValue[i] = randomValue;
	    }
	    
	    // return randomly generated strings
	    return retValue;
	}
	
	public static void AverageAndCounting()
	{
		int counter = 0;
	    int num = 0;
	    int countOfNeg = 0;
	    float avg = 0f;
	    int sumPos = 0;
	    int sumNeg = 0;
	    int countOf4s = 0;
	    
	    System.out.println("Please enter a positive number:");
	    
	    // check for valid numeric entry
	    num = input.nextInt();
	    
	    // read carriage return from input (ignore value)
	    input.nextLine();
	        
	    while (counter++ < num)
	    {
	    	System.out.println("Please enter a number (" + counter + " of " + num + "):");
		    
		    // capture input (positive or negative)
	    	int in = input.nextInt();
	    	
	    	// read past carriage return
	    	input.nextLine();
	    	
	    	// sum the positive values
	    	if (in > 0) sumPos += in;
	    	
	    	// average the negative values
	        if (in < 0)
	        {
	            // increment count of negative values
	        	countOfNeg++;
	        	
	        	// sum the negative values
	            sumNeg += (float)in;
	            
	            // calculate average for negative values
	            avg = (float)sumNeg / (float)countOfNeg;
	        }
	        
	        // count all values greater than 4
	        if (in > 4) countOf4s++;
        }
        
        // display results
        System.out.println("Sum of all positive numbers:" + sumPos);
        System.out.println("Count of numbers larger than 4:" + countOf4s);
        System.out.println("Average of negative numbers:" + avg);
	}
	
	public static double PiApproximation(int num)
	{
// Problem 1: (PI approximation)
		//initializing denominator with 1
		int denominator = 1;
		int sign = 1;

		double sum = 0.0;

		//for loop from 0 to num
		for(int counter = 0; counter < num; counter ++ )
		{
			//calculating sum
			sum = sum + (sign) * 4 / (double) denominator;
		
			sign = sign * -1;

			//denominator will be increased by 2 next time
			denominator = denominator + 2;
		}

		//returning the sum
		return sum;
	}

//problem 3 : (Gymnastics Judging)
		public static double gymnasticsJudging()
		{
		    double score = 0;
		    double low = 10.0;
		    double high = 0.0;
		    
		    System.out.println("Enter scores for gymnast:");
		    
		    for (int counter = 0; counter < 6; counter++)
		    {
		        // get score from input
		        double last = input.nextDouble();
		        
		        // aggregate scores
		        score += last;

		        // check for lowest
		        if (last < low) low = last;
		        
		        // check for highest
		        if (last > high) high = last;
		    }
		    
		    // remove highest and lowest scores
		    score -= high;
		    score -= low;
		    
		    return score / 4.0;
		}
		


		public static void QuarterbackRating()
		{
			System.out.println("Please enter the QB's completed passes:");
		   
			// get score from input
			float completedPasses = input.nextFloat();
			input.nextLine();
			
			System.out.println("Please enter the QB's pass attempts:");
			   
			// get score from input
			float passAttempts = input.nextFloat();
			input.nextLine();
			
			System.out.println("Please enter the QB's passing yards:");
			   
			// get score from input
			float passingYards = input.nextFloat();
			input.nextLine();
			
			System.out.println("Please enter the QB's touchdown passes:");
			   
			// get score from input
			float touchdownPasses = input.nextFloat();
			input.nextLine();
			
			System.out.println("Please enter the QB's interceptions:");
			   
			// get score from input
			float interceptions = input.nextFloat();
			input.nextLine();
			
			// print out QB rating
			System.out.println(Math.round(qbRating(completedPasses, passAttempts, passingYards, touchdownPasses, interceptions) * 10.0) / 10.0);
		}
		
//Problem 4:(Quarterback Rating)		    
	public static float qbRating(float completedPasses, float passAttempts, float passingYards, float touchdownPasses, float interceptions)
			{
			    float rating = 0;
			    float completionRatio = 0;
			    float yardsPerPass = 0;
			    float touchdownRatio = 0;
			    float interceptionRatio = 0;
			    
			    // Completion ratio: W = 250/3 * ((A / B) - 0.3).
			    completionRatio =  (250f / 3f * ((completedPasses / passAttempts) - 0.3f));
			    
		        // Yards per pass: X = 25/6 * ((C / B) - 3).
		        yardsPerPass = 25f / 6f * ((passingYards / passAttempts) - 3f);
		        
		        // Touchdown ratio: Y = 1000/3 * (D / B)
		        touchdownRatio = 1000f / 3f * (touchdownPasses / passAttempts);
		        
		        // Interception ratio: Z = 1250/3 * (0.095 - (E / B))
			    interceptionRatio = (1250f / 3f * (0.095f - (interceptions / passAttempts)));
			    
			    // sum ratings
			    rating = completionRatio + yardsPerPass + touchdownRatio + interceptionRatio;
			    
			    return rating;	      	
	
	}		

	public static int DisplayMenu()
	{
	    int ret = 0;
	    
	    // display menu selection until valid input is captured
	    while (ret == 0)
	    {
	        // display input menu for user selection
		    System.out.println("Please select the medium:");
		    System.out.println("Enter 1 for Air");
		    System.out.println("Enter 2 for Water");
		    System.out.println("Enter 3 for Steel");
		    
		    // validate user input
		    try
		    {
		        // check for valid numeric entry
		        ret = input.nextInt();
		        
		        // validate range of entry
		        if (ret > 0 && ret < 4)
		            break;
	            else
	            {
	                // notify user of invalid input
	                System.out.println("Please enter 1, 2, or 3");
	                
	                // reset int to continue loop
	                ret = 0;
	            }
		    }
		    catch (Exception ex)
		    {
		        // notify user of invalid input
		        System.out.println("That's not a valid menu selection. Please enter 1, 2, or 3");
		        
		        // reset int to continue loop
		        ret = 0;
		    }
	    }
	    
	    // return validated user input
	    return ret;
	}
//problem  7(Speed of Sound)
	public static double SoundSpeed(int medium)
	{
	    double ret = 0;
	    
	    // prompt user for distance
	    // display menu selection until valid input is captured
	    while (ret == 0)
	    {
	        // display input menu for user selection
		    System.out.println("Please enter the distance in feet to calculate:");
		    
		    // validate user input
		    try
		    {
		        // get user input
		        double distance = input.nextDouble();
		    
		        // validate range of entry
		        if (distance <= 0)
		        {
		            // notify user of invalid input
	                System.out.println("Please enter a positive value:");
	                
	                // reset int to continue loop
	                ret = 0;
		        }
		        else
		        {
		            // do speed of sound calculation
		            // speed of sound = distance / time
		            // time through medium = speed of sound / distance
		            // air 1100 ft/s traveling 1100 ft, 1 sec
		            
		            if (medium == 1)
		                ret = distance / 1100; // air 1100 ft/s
		            else if (medium == 2)
		                ret = distance / 4900; // water 4900 ft/s
	                else if (medium == 3)
		                ret = distance / 16400; // steel 16,400 ft/s
		        	
		        	break;
		        }
		    }
		    catch (Exception ex)
		    {
		        // notify user of invalid input
		        System.out.println("That's not a valid distance. Please enter a positive, numeric value:");
		        
		        // reset int to continue loop
		        ret = 0;
		    }
	    }
	    
	    return ret;
	}
	
	
//problem 2 (calculating  the weight)	
	
	public  static String calculateWeight(double mass){
		String return_value = "";
		double weight = mass * 9.8;
		
		if (weight > 100){
			return_value = "object is too heavy";
		}
		else if(weight < 10){
			return_value ="Object weight is too light";
			
		}
		else{
			return_value ="Object weight is normal";
		}
		return return_value;
		
	}
}


//import java.util.Scanner;
//import java.text.DecimalFormat;
//import java.text.Format;
//
//public class Test
//{
//	// initialize scanner
//	static Scanner input = new Scanner(System.in);
//    
//    public static void main(String[] args)
//	{
//		// display master method menu
//		Menu();       
//	}
//
//	public static void Menu()
//	{
//		String ret = "";
//		boolean quit = false;
//		
//		do
//	    {
//			// display menu of methods
//		    System.out.println("Welcome to Lab 5");
//		    System.out.println("1. PI approximation");
//			System.out.println("2. Weight Calculation");
//			System.out.println("3. Gymnastics Judging");
//			System.out.println("4. Quarterback Rating");
//			System.out.println("5. Finding Average and Counting");
//			System.out.println("6. Hurricane Categories");
//			System.out.println("7. Sound Speed");
//			System.out.println("8. Exit");
//		    System.out.println();
//		    System.out.println("Please select option [1-8]:");
//			
//		    // check for valid numeric entry
//	    	ret = input.nextLine();
//	        
//	        try
//		    {
//				int menu = Integer.parseInt(ret);
//				
//		        // validate range of entry
//		        if (menu == 1) piApproximate();
//		        else if (menu == 2)
//		        {
//		        	System.out.println("Please enter mass in kilograms:");
//		        	
//		        	double mass = input.nextDouble();
//		        	input.nextLine();
//		        	
//		        	System.out.println(calculateWeight(mass));
//		        }
//		        else if (menu == 3) gymnasticsJudging();
//		        else if (menu == 4) QuarterbackRating();
//		        else if (menu == 5) averageAndCounting();
//		        else if (menu == 6) hurricaneCategories();
//		        else if (menu == 7) System.out.println(SoundSpeed(DisplayMenu()));
//		        else if (menu == 8) quit = true;
//		        else continue;
//		    }
//		    catch (Exception ex)
//		    {
//		        System.out.println("That's not a valid menu selection.");
//		    }
//	    } while (!quit);
//		
//        // close scanner
//        input.close();
//	}
//	
//	public static double piApproximate()
//	{
//		return 0;
//	}
//	
//	public static double hurricaneCategories()
//	{
//		return 0;
//	}
//	
//	public static double averageAndCounting()
//	{
//		return 0;
//	}
//	
//	public static String calculateWeight(double mass)
//	{
//	    double weight = mass * 9.8;
//		    
//	    String return_value = "";
//	    
//	    // logic to determine message
//	    if (weight > 1000)
//	        return_value = "Object weight is too heavy";
//        else if (weight < 10)
//	        return_value = "Object weight is too light";
//        else
//	        return_value = "Object weight is normal";
//	        
//	   // return weight categorization
//	   return return_value;
//	}
//	
//	public static int DisplayMenu()
//	{
//	    String menu_selection = "";
//	    int ret = 0;
//	    
//	    while (ret == 0)
//	    {
//		    System.out.println("Please select the medium:");
//		    System.out.println("Enter 1 for Air");
//		    System.out.println("Enter 2 for Water");
//		    System.out.println("Enter 3 for Steel");
//		    
//		    menu_selection = input.nextLine();
//		    
//		    try
//		    {
//		        // check for valid numeric entry
//		        ret = Integer.parseInt(menu_selection);
//		        
//		        // validate range of entry
//		        if (ret > 0 && ret < 4)
//		            break;
//	            else
//	            {
//	                System.out.println("Please enter 1, 2, or 3");
//	                
//	                ret = 0;
//	            }
//		    }
//		    catch (Exception ex)
//		    {
//		        System.out.println("That's not a valid menu selection. Please enter 1, 2, or 3");
//		    }
//	    }
//	    
//	    // return menu selection
//	    return ret;
//	}
//	
//	public static double SoundSpeed(int medium)
//	{
//	    double ret = 0;
//	    
//	    // prompt user for distance
//	    // display menu selection until valid input is captured
//	    while (ret == 0)
//	    {
//	        // display input menu for user selection
//		    System.out.println("Please enter the distance to calculate:");
//		    
//		    // validate user input
//		    try
//		    {
//		        // get user input
//		        double distance = input.nextDouble();
//		        input.nextLine();
//		    
//		        // validate range of entry
//		        if (distance <= 0)
//		        {
//		            // notify user of invalid input
//	                System.out.println("Please enter a positive value:");
//	                
//	                // reset int to continue loop
//	                ret = 0;
//		        }
//		        else
//		        {
//		        	// do speed of sound calculation
//		            // speed of sound = distance / time
//		            // time through medium = speed of sound / distance
//		            // air 1100 ft/s traveling 1100 ft, 1 sec
//		            
//		        	if (medium == 1)
//		                ret = distance / 1100; // air 1100 ft/s
//		            else if (medium == 2)
//		                ret = distance / 4900; // water 4900 ft/s
//	                else if (medium == 3)
//		                ret = distance / 16400; // steel 16,400 ft/s
//		        	
//		        	break;
//		        }
//		    }
//		    catch (Exception ex)
//		    {
//		        // notify user of invalid input
//		        System.out.println("That's not a valid distance. Please enter a positive, numeric value:");
//		        
//		        // reset int to continue loop
//		        ret = 0;
//		    }
//	    }
//	    
//	    // return time of sound through medium
//	    return ret;
//	}
//
//	public static void QuarterbackRating()
//	{
//		System.out.println("Please enter the QB's completed passes:");
//	   
//		// get score from input
//		float completedPasses = input.nextFloat();
//		input.nextLine();
//		
//		System.out.println("Please enter the QB's pass attempts:");
//		   
//		// get score from input
//		float passAttempts = input.nextFloat();
//		input.nextLine();
//		
//		System.out.println("Please enter the QB's passing yards:");
//		   
//		// get score from input
//		float passingYards = input.nextFloat();
//		input.nextLine();
//		
//		System.out.println("Please enter the QB's touchdown passes:");
//		   
//		// get score from input
//		float touchdownPasses = input.nextFloat();
//		input.nextLine();
//		
//		System.out.println("Please enter the QB's interceptions:");
//		   
//		// get score from input
//		float interceptions = input.nextFloat();
//		input.nextLine();
//		
//		// print out QB rating
//		System.out.println(Math.round(qbRating(completedPasses, passAttempts, passingYards, touchdownPasses, interceptions) * 10.0) / 10.0);
//	}
//	
//	private static float qbRating(float completedPasses, float passAttempts, float passingYards, float touchdownPasses, float interceptions)
//	{
//	    float rating = 0f;
//	    float completionRatio = 0f;
//	    float yardsPerPass = 0f;
//	    float touchdownRatio = 0f;
//	    float interceptionRatio = 0f;
//	    
//	    // Completion ratio: W = 250/3 * ((A / B) - 0.3).
//	    completionRatio = ((250f / 3f) * ((completedPasses / passAttempts) - 0.3f));
//
//        // Yards per pass: X = 25/6 * ((C / B) - 3).
//        yardsPerPass = (25f / 6f) * ((passingYards / passAttempts) - 3);
//
//        // Touchdown ratio: Y = 1000/3 * (D / B)
//        touchdownRatio = (1000f / 3f) * (touchdownPasses / passAttempts);
//
//        // Interception ratio: Z = 1250/3 * (0.095 - (E / B))
//	    interceptionRatio = (1250f / 3f) * (0.095f - (interceptions / passAttempts));
//
//	    // sum ratings
//	    rating = completionRatio + yardsPerPass + touchdownRatio + interceptionRatio;
//	    
//	    return rating;
//	}
//
//	private static double gymnasticsJudging()
//	{
//	    double score = 0;
//	    double low = 10.0;
//	    double high = 0.0;
//	    double n = 0.0;
//	    
//	    System.out.println("Enter scores for gymnast:");
//	    
//	    for (int i = 0; i < 6; i++)
//	    {
//	    	while (n <= 10.0 && n >= 0.0)
//	    	{
//	    		n = input.nextDouble();
//	    		input.nextLine();
//	    	}
//	    	
//	        // get score from input
//	        double last = n;
//	        
//	        // aggregate scores
//	        score += last;
//	        
//	        // check for lowest
//	        if (last < low) low = last;
//	        
//	        // check for highest
//	        if (last > high) high = last;
//	    }
//	    
//	    // remove highest and lowest scores
//	    score -= high;
//	    score -= low;
//	    
//	    // return average
//	    return score / 4.0;
//	}
//}
//
//	
//	/*public static void main(String[] args)
//	{
//		int n;
//		int tripMiles = 0;
//		int totalMiles = 0;
//		int tripGallons = 0;
//	    int totalGallons = 0;
//	    double totalMpg = 0;
//	    double tripMpg = 0;
//
//	    // while this condition is true, run the loop
//	    Scanner input = new Scanner(System.in);
//	    System.out.println("Enter miles driven (-1 to quit):"); 
//	 
//	    while ((n = input.nextInt()) != -1) {
//	    	tripMiles = n;
//	    	totalMiles += tripMiles;
//	    	
//	    	System.out.println("Enter gallons used:");
//	    	
//	    	tripGallons = input.nextInt();
//	    	totalGallons += tripGallons;
//	    	
//	    	tripMpg = tripMiles / tripGallons;
//	    	totalMpg = totalMiles / totalGallons;
//	    			
//	    	System.out.println("MPG this trip: " + String.format("%.6f", tripMpg));
//	    	System.out.println("Total MPG: " + String.format("%.6f", totalMpg));
//	    }
//	}*/