package Zawoo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class PROGRAM2
{
	static Scanner input = new Scanner(System.in);
	static int numOfEmployees = 0;
	
	public static void main(String[] args)
	{
		String[] employeeNames;
		String[] employeeIds;
		Boolean[] hourlyEmployee;
		Boolean[] localResidents;
		float[] hourlyWorked;
		float[] hourlyRate;
		float[] salaryRate;
		float[] grossIncome;
		float[] netIncome;
		
		// display company logo
		PrintLogo();
		
		// get number of employees to process
		NumOfEmployees();
		
		// allocate arrays
		employeeNames = new String[numOfEmployees];
		employeeIds = new String[numOfEmployees];
		hourlyEmployee = new Boolean[numOfEmployees];
		localResidents = new Boolean[numOfEmployees];
		hourlyWorked = new float[numOfEmployees];
		hourlyRate = new float[numOfEmployees];
		salaryRate = new float[numOfEmployees];
		grossIncome = new float[numOfEmployees];
		netIncome = new float[numOfEmployees];
		
		// process employee payroll
		ProcessEmployee(employeeNames, employeeIds, hourlyEmployee, localResidents, hourlyWorked, hourlyRate, salaryRate, grossIncome, netIncome);
		
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
		    	System.out.println("INVALID. Enter '1' or more.");
		    }
	    } while (numOfEmployees <= 0);
	}
	
	public static void ProcessEmployee(String[] employeeNames, String[] employeeIds, Boolean[] hourlyEmployee, Boolean[] localResidents, float[] hourlyWorked, float[] hourlyRate, float[] salaryRate, float[] grossIncome, float[] netIncome)
	{
		// fill employee data
		for (int i = 0; i < numOfEmployees; i++)
		{
			// collect and validate employee id
			employeeIds[i] = getEmployeeId(i, employeeIds);
			
			// collect and validate employee name
			employeeNames[i] = getEmployeeName();
			
			// collect and validate employee type
			hourlyEmployee[i] = getEmployeeType();
			
			// collect and validate hourly hours worked
			hourlyWorked[i] = getHoursWorked();
			
			// collect and validate hourly rates
			hourlyRate[i] = getHourlyRate();
			
			// collect and validate salary data
			salaryRate[i] = getSalary();
			
			// collect and validate employee resident type
			localResidents[i] = getEmployeeLocality();
			
			// calculate gross income
			grossIncome[i] = getGrossIncome(hourlyEmployee[i], hourlyWorked[i], hourlyRate[i], salaryRate[i]);
			
			// collect and validate net income
			netIncome[i] = getNetIncome(localResidents[i], grossIncome[i]);
		}
	}
	
	public static String getEmployeeId(int currentEmployee, String[] employeeIds)
	{
		// local temp var to validate user input
		Boolean isValid = false;
		String userInput = "";
		
		// collect and validate employee id
		do
	    {
			// display menu of methods
			System.out.println("Enter data for employee (" + currentEmployee + ")");
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
		
		// return
		return userInput;
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
	
	public static Boolean getEmployeeLocality()
	{
		// local temp var to validate user input
		Boolean isValid = false;
		String userInput = "";
		
		// collect and validate employee id
		do
	    {
			// display menu of methods
			System.out.println("\tLocal resident (Y/N):");
			
		    // check for valid numeric entry
	    	userInput = input.nextLine();
	    	
	    	// ensure ID is in correct format
	        if (userInput.toLowerCase() != "y" && userInput.toLowerCase() != "n")
	        {
	        	// notify user of duplicate id
	    		System.out.println("INVALID. Enter 'Y' or 'N'. Please try again.");
	    		
	    		// restart loop
	    		continue;
		    }
	        
	        // valid id
	        isValid = true;		        
	    } while (!isValid);
		
		return (userInput.toLowerCase() == "y");
	}
	
	public static float getHoursWorked()
	{
		// local temp var to hold user input
		float hoursWorked = 0f;
		
		// display menu of methods
		System.out.println("\tHours worked this period:");
		
	    // check for valid numeric entry
    	hoursWorked = input.nextFloat();
    	
    	// consume carriage return
    	input.nextLine();
    	
    	// return
    	return hoursWorked;
	}

	public static float getHourlyRate()
	{
		// local temp var to hold user input
		float hourlyRate = 0f;
		
		// display menu of methods
		System.out.println("\tHourly Rate:");
		
	    // check for valid numeric entry
		hourlyRate = input.nextFloat();
    	
    	// consume carriage return
    	input.nextLine();
    	
    	// return
    	return hourlyRate;
	}
	
	public static float getSalary()
	{
		// local temp var to hold user input
		float salary = 0f;
		
		// display menu of methods
		System.out.println("\tWeekly salary:");
		
	    // check for valid numeric entry
    	salary = input.nextFloat();
    	
    	// consume carriage return
    	input.nextLine();
    	
    	// return
    	return salary;
	}
	
	// calculate gross income
	public static float getGrossIncome(Boolean hourlyEmployee, float hoursWorked, float hoursRate, float salaryRate)
	{
		// calculate for hourly/salary
		if (hourlyEmployee)
			if (hoursWorked > 40)
				return (hoursWorked - 40) * (hoursRate * 1.5f);
			else
				return hoursWorked * hoursRate;
		else
			return salaryRate;
	}
	
	// calculate net income for employee
	public static float getNetIncome(Boolean localResident, float gross)
	{
		// calculate net income
		return (gross - calcFedTax(gross) - calcStateTax(gross) - calcLocalTax(localResident, gross));
	}
	
	// calculate federal tax
	public static float calcFedTax(float gross)
	{
		final float taxRate0 = 0.00f;
		final float taxRate4 = 0.04f;
		final float taxRate8 = 0.08f;
		final float taxRate12 = 0.12f;
		
		if (gross >= 0.00f && gross <= 599.99f) return gross * taxRate0;
		else if (gross >= 600.00f && gross <= 799.99f) return gross * taxRate4;
		else if (gross >= 800.00f && gross <= 1099.99f) return gross * taxRate8;
		else if (gross >= 1100.00f) return gross * taxRate12;
		else return 0;
	}
	
	// calculate state tax
	public static float calcStateTax(float gross)
	{
		final float taxRate6 = 0.06f;
		
		if (gross >= 600.00) return gross * taxRate6;
		else return 0;
	}
	
	// calculate local tax
	public static float calcLocalTax(Boolean localResident, float gross)
	{
		final float taxRateLocal = 0.015f;
		final float taxRateNonLocal = 0.01f;
		
		if (localResident) return gross * taxRateLocal;
		else return gross * taxRateNonLocal;
	}
}
