package Zawoo;

import java.util.Arrays;
import java.util.Scanner;

public class PROGRAM2
{
	static Scanner input = new Scanner(System.in);
	static int numOfEmployees = 0;
	
	public static void main(String[] args)
	{
		String[] employeeNames;
		String[] employeeIds;
		Boolean[] hourlyEmployee;
		float[] hourlyWorked;
		float[] hourlyRate;
		float[] salaries;
		float[] grossIncome;
		float[] netIncome;
		
		// display company logo
		PrintLogo();
		
		// get number of employees to process
		NumOfEmployees();
		
		// process employee payroll
		ProcessEmployee(numOfEmployees, employeeNames, employeeIds, hourlyEmployee, hourlyWorked, hourlyRate, salaries, grossIncome, netIncome);
		
		// display payroll information
		PayRollReport();
	}

	public static void PrintLogo()
	{
		System.out.println("+=======================+");
		System.out.println("+       OLDISH PUB      +");
		System.out.println("+=======================+");
	}
	
	public static void NumOfEmployees()
	{
		// local temp var to hold user input
		String tempVar = "";
		
		// prompt user for number of employees
		do
	    {
			// display menu of methods
			System.out.println("Enter number of employees:");
			
		    // check for valid numeric entry
	    	tempVar = input.nextLine();
	        
	        try
		    {
				numOfEmployees = Integer.parseInt(tempVar);
		    }
		    catch (Exception ex)
		    {
		    	System.out.println("INVLALID. Enter '1' or more.");
		    }
	    } while (numOfEmployees <= 0);
	}
	
	public static void ProcessEmployee(String[] employeeNames, String[] employeeIds, Boolean[] hourlyEmployee, float[] hourlyWorked, float[] hourlyRate, float[] salaries, float[] grossIncome, float[] netIncome)
	{
		// fill employee data
		for (int i = 0; i < numOfEmployees; i++)
		{
			// collect and validate employee id
			employeeIds[i] = getEmployeeId(employeeIds);
			
			// collect and validate employee name
			employeeNames[i] = getEmployeeName();
			
			// collect and validate employee type
			hourlyEmployee[i] = getEmployeeType();
			
			// collect and validate hourly hours worked
			hourlyWorked[i] = getHourlyWorked();
			
			// collect and validate hourly rates
			hourlyRate[i] = getHourlyRate();
			
			// collect and validate salary data
			salaries[i] = getSalaries();
			
			// collect and validate gross income
			grossIncome[i] = getGrossIncome();
			
			// collect and validate net income
			netIncome[i] = getNetIncome();
		}
	}
	
	public static String getEmployeeId(String[] employeeIds)
	{
		// local temp var to validate user input
		Boolean isValid = false;
		String userInput = "";
		
		// collect and validate employee id
		do
	    {
			// display menu of methods
			System.out.println("Enter data for employee (" + i + ")");
			System.out.println("\tEmployee ID:");
			
		    // check for valid numeric entry
	    	userInput = input.nextLine();
	    	
	    	// ensure unique id
	    	if (Arrays.asList(employeeIds).contains(userInput))
	    	{
	    		// notify user of duplicate id
	    		System.out.println("This ID has already been entered. Please try again.");
	    		
	    		// restart loop
	    		continue;
	    	}
	        
	    	// ensure ID is in correct format
	        if (userInput.substring(0, 1).toLowerCase() != "h" && userInput.substring(0, 1).toLowerCase() != "s")
	        {
	        	// notify user of duplicate id
	    		System.out.println("This ID is invalid. Must start with 'H' or 'S'. Please try again.");
	    		
	    		// restart loop
	    		continue;
		    }
	        
	        // valid id
	        isValid = true;		        
	    } while (!isValid);
	}
	
	public static String getEmployeeName()
	{
		// prompt user for employee name
		System.out.println("\tEmployee Name (first last):");
		
	    // check for valid numeric entry
    	return input.nextLine();
	}
	
	public static Boolean getEmployeeType()
	{
		// local temp var to validate user input
		Boolean isValid = false;
		String userInput = "";
		
		// collect and validate employee id
		do
	    {
			// display menu of methods
			System.out.println("\tHourly or Salary (H/S):");
			
		    // check for valid numeric entry
	    	userInput = input.nextLine();
	    	
	    	// ensure ID is in correct format
	        if (userInput.substring(0, 1).toLowerCase() != "h" && userInput.substring(0, 1).toLowerCase() != "s")
	        {
	        	// notify user of duplicate id
	    		System.out.println("INVALID. Enter 'H' or 'S'. Please try again.");
	    		
	    		// restart loop
	    		continue;
		    }
	        
	        // valid id
	        isValid = true;		        
	    } while (!isValid);
		
		return (userInput.toLowerCase() == "h");
	}
	
	public static float getHoursWorked()
	{
		// local temp var to validate user input
		Boolean isValid = false;
		String userInput = "";
		
		// collect and validate employee id
		do
	    {
			// display menu of methods
			System.out.println("\tHours worked this period:");
			
		    // check for valid numeric entry
	    	userInput = input.nextLine();
	    	
	    	// ensure ID is in correct format
	        if (userInput.substring(0, 1).toLowerCase() != "h" && userInput.substring(0, 1).toLowerCase() != "s")
	        {
	        	// notify user of duplicate id
	    		System.out.println("This ID is invalid. Must start with 'H' or 'S'. Please try again.");
	    		
	    		// restart loop
	    		continue;
		    }
	        
	        // valid id
	        isValid = true;		        
	    } while (!isValid);
	}
}
