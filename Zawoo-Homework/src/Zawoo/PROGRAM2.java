package Zawoo;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class PROGRAM2
{
	static Scanner input = new Scanner(System.in);
	static int numOfEmployees = 0;
	
	public static void main(String[] args)
	{
		// local variables
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
		payrollReport(hourlyEmployee, grossIncome, netIncome);
	}

	public static void PrintLogo()
	{
		System.out.println("+============================+");
		System.out.println("+         OLDISH PUB         +");
		System.out.println("+============================+");
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
			
			// collect hours worked or salary
			if (hourlyEmployee[i])
			{
				// collect and validate hourly hours worked
				hourlyWorked[i] = getHoursWorked();
				
				// collect and validate hourly rates
				hourlyRate[i] = getHourlyRate();
			}
			else
			{
				// collect and validate salary data
				salaryRate[i] = getSalary();
			}
			
			// collect and validate employee resident type
			localResidents[i] = getEmployeeLocality();
			
			// calculate gross income
			grossIncome[i] = getGrossIncome(hourlyEmployee[i], hourlyWorked[i], hourlyRate[i], salaryRate[i]);
			
			// collect and validate net income
			netIncome[i] = getNetIncome(localResidents[i], grossIncome[i]);
		}
		
		// print employee pay stub data
		for (int i = 0; i < numOfEmployees; i++)
			printPayStub(employeeNames[i], employeeIds[i], hourlyEmployee[i], localResidents[i], hourlyWorked[i], hourlyRate[i], salaryRate[i], grossIncome[i], netIncome[i]);
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
			System.out.println("Enter data for employee (" + (currentEmployee + 1) + ")");
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
	        if (!userInput.toLowerCase().startsWith("h") && !userInput.toLowerCase().startsWith("s"))
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
	        if (!userInput.toLowerCase().startsWith("h") && !userInput.toLowerCase().startsWith("s"))
	        {
	        	// notify user of duplicate id
	    		System.out.println("INVALID. Enter 'H' or 'S'. Please try again.");
	    		
	    		// restart loop
	    		continue;
		    }
	        
	        // valid id
	        isValid = true;		        
	    } while (!isValid);
		
		return (userInput.toLowerCase().startsWith("h"));
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
	        if (!userInput.toLowerCase().startsWith("y") && !userInput.toLowerCase().startsWith("n"))
	        {
	        	// notify user of duplicate id
	    		System.out.println("INVALID. Enter 'Y' or 'N'. Please try again.");
	    		
	    		// restart loop
	    		continue;
		    }
	        
	        // valid id
	        isValid = true;		        
	    } while (!isValid);
		
		return (userInput.toLowerCase().startsWith("y"));
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
			if (hoursWorked > 40.0f)
				return ((40.0f * hoursRate) + ((hoursWorked - 40.0f) * (hoursRate * 1.5f)));
			else
				return hoursWorked * hoursRate;
		else
			return salaryRate;
	}
	
	// calculate net income for employee
	public static float getNetIncome(Boolean localResident, float gross)
	{
		// calculate net income
		return (gross - calcSSITax(gross) - calcFedTax(gross) - calcStateTax(gross) - calcLocalTax(localResident, gross));
	}
	
	// calculate Social Security tax
	public static float calcSSITax(float gross)
	{
		final float taxRate3 = 0.03f;
		
		return gross * taxRate3;
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
	
	// print employee pay stub
	public static void printPayStub(String employeeName, String employeeId, Boolean hourlyEmployee, Boolean localResident, float hourlyWorked, float hourlyRate, float salaryRate, float grossIncome, float netIncome)
	{
		// print header
		System.out.println("+-------OLDISH PUB Pay Stub-------+\n");
				
		// print employee info
		System.out.println("Name: " + employeeName.split(" ")[1] + ", " + employeeName.split(" ")[0]);
		System.out.println("Gross: " + NumberFormat.getCurrencyInstance().format(grossIncome));
		
		// print tax detail
		System.out.println("\tTaxes Detail------------------");
		System.out.println("\t\tFed Tax:\t" + NumberFormat.getCurrencyInstance().format(calcFedTax(grossIncome)));
		System.out.println("\t\tSSI Tax:\t" + NumberFormat.getCurrencyInstance().format(calcSSITax(grossIncome)));
		System.out.println("\t\tState Tax:\t" + NumberFormat.getCurrencyInstance().format(calcStateTax(grossIncome)));
		System.out.println("\t\tLocal Tax:\t" + NumberFormat.getCurrencyInstance().format(calcLocalTax(localResident, grossIncome)));
		
		// print totals
		System.out.println("\t\t======================");
		System.out.println("\t\tTotal Tax: " + NumberFormat.getCurrencyInstance().format(grossIncome - netIncome));
		System.out.println("======================================");
		System.out.println("Net: " + NumberFormat.getCurrencyInstance().format(netIncome));
		System.out.println("======================================");
		
		// print divider
		System.out.println("\n+---------------------------------+\n");
	}
	
	// print payroll report
	public static void payrollReport(Boolean[] hourlyEmployee, float[] grossIncome, float[] netIncome)
	{
		// variables to hold totals
		float totalEmployees = 0f;
		float totalFederal = 0f;
		float totalSSI = 0f;
		float totalState = 0f;
		float totalLocal = 0f;
		
		// calculate totals
		for (int i = 0; i < grossIncome.length; i++)
		{
			totalEmployees += netIncome[i];
			totalFederal += calcFedTax(grossIncome[i]);
			totalSSI += calcSSITax(grossIncome[i]);
			totalState += calcStateTax(grossIncome[i]);
			totalLocal += calcLocalTax(hourlyEmployee[i], grossIncome[i]);
		}
		
		// print header
		System.out.println("+---------Payroll  Report---------+\n");
				
		// print tax detail
		System.out.println("Total Pay to Employees:\t\t" + NumberFormat.getCurrencyInstance().format(totalEmployees));
		System.out.println("Total Pay to Federal Tax:\t" + NumberFormat.getCurrencyInstance().format(totalFederal));
		System.out.println("Total Pay to SSI Tax:\t\t" + NumberFormat.getCurrencyInstance().format(totalSSI));
		System.out.println("Total Pay to State Tax:\t\t" + NumberFormat.getCurrencyInstance().format(totalState));
		System.out.println("Total Pay Local Tax:\t\t" + NumberFormat.getCurrencyInstance().format(totalLocal));
		
		// print divider
		System.out.println("\n+---------------------------------+\n");
	}
}
