package project2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/** 
 * COP 3530: Project 2 – Stacks and PriorityQ Queues  
 * <p> 
 * This program prints out country objects using stacks and priority queues with options
 * to either pop/push a country on to a stack or insert/remove a country from a priority queue.
 * <p> 
 * 
 * <p>
 * This program first takes in a csv file of countries and then asks the user to input a number
 * 1-6 or quit the program to end it.
 * <p>
 * @author <Kenniece Harris> 
 * @version <10/09/2022> 
 */ 

public class Project2_N01503765 {
	
	public static Country[] countryArray = new Country[145];
	public static Stack countryStack = new Stack(countryArray.length);
	public static PriorityQ countryPQ = new PriorityQ(countryArray.length);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		System.out.println("Project 2: Stacks and Priority Queues");
		getUserInput();
		
		
	}
	
/** 
* The purpose of this method is to get the user input containing the name of the csv file
* which is then taken in as a parameter for the parseCsvFile method.
* 
 */ 
	
	public static void getUserInput() {
		System.out.print("Please enter the name of the csv file:");
	    Scanner scnr = new Scanner(System.in);
	    String csvFileName = scnr.nextLine();
	    System.out.println("");
	    parseCsvFile(csvFileName);
        
	}
	
/** 
* The purpose of this method is to read in the countries from the csv file into country
* objects which are then pushed/inserted into a stack/priority queue.
* 
* @param fileName, the name of the csv file.
 */
	public static void parseCsvFile(String fileName) {
		
		FileReader newFile;
	      Scanner scnr2;
			try {
				newFile = new FileReader(fileName);
				 scnr2 = new Scanner(newFile);
				
				int count = 0;
				while(scnr2.hasNext())
				{
					  String word = scnr2.nextLine();
					  if(count > 0)
					  {
						  
						  String[] newLine = word.split(",");
						  countryArray[count - 1] = new Country(newLine[0],newLine[1],newLine[2],newLine[3], newLine[4], newLine[5], newLine[6]);
						  countryStack.push(countryArray[count - 1]);
						  countryPQ.insert(countryArray[count - 1]);
						  
					  }

					count++;
				}
				
				
				System.out.println("There were 145 records read.");
				System.out.println(countryArray.length);
				printUserInput();
			} 
			
			catch (FileNotFoundException e) {
				System.out.println("Try Again. Please enter a valid csv file name.");
			}
	}

/** 
* The purpose of this method is to get the user input for options 1-6 and print the result or
* quit the program
 */
public static void printUserInput() {
		
		
		
		System.out.println("Please make a selection:");
	    System.out.println("1. Print stack ");
	    System.out.println("2. Pop a country object from stack ");
	    System.out.println("3. Push a country object onto stack ");
	    System.out.println("4. Print priority queue ");
	    System.out.println("5. Remove a country object from priority queue ");
	    System.out.println("6. Insert a country object into priority queue ");
	    System.out.println("7. Quit Program");
	    System.out.println("");
	    System.out.print("Enter your choice: ");
	    
	    Scanner input = new Scanner(System.in);
		String userInput = input.next();
		boolean exit = false;
		System.out.println("");
		 
		while(!exit)
	      {
		    	
		    	if(userInput.equals("quit"))
		    	{
		    		 exit = true;
		    		 input.close();
		    		 break;
		    	}
		    	
		    	
		    	/*
		    	 * else if((Integer.parseInt(userInput) < 0) || (Integer.parseInt(userInput) > 6) )
			    {
			    	
				    	while((Integer.parseInt(userInput) < 0) || (Integer.parseInt(userInput) > 6) ) {
				    		System.out.print("Invalid choice! Enter 1-7:");
				    		
				    		userInput = input.next();
				    		
				    	}
				    	
				    	System.out.println("");
			    	
			    }
		    	
		    	 */
		    	
		    	else if(userInput.matches("[a-zA-Z_]+") || !userInput.matches("[0-6]")) {
		    		

			    	while(userInput.matches("[a-zA-Z_]+") || !userInput.matches("[0-6]")) {
			    		System.out.print("Invalid choice! Enter 1-7:");
			    		
			    		userInput = input.next();
			    		
			    	}
			    	
			    	System.out.println("");
		    		
		    	}
		    	
		    	
		    	
		    	
		    	else {
				    
				    int i = Integer.parseInt(userInput); 
				    
				    
				    
				   
				    switch(i) {
				    
				      
				      case 1: printOptionOne(); break;
				      case 2: printOptionTwo();  break;
				      case 3: printOptionThree();break;
				      case 4: printOptionFour(); break;
				      case 5: printOptionFive(); break;
				      case 6: printOptionSix(); break;
				      
				    }
				    
				    System.out.println("Please make a selection:");
				    System.out.println("1. Print stack ");
				    System.out.println("2. Pop a country object from stack ");
				    System.out.println("3. Push a country object onto stack ");
				    System.out.println("4. Print priority queue ");
				    System.out.println("5. Remove a country object from priority queue ");
				    System.out.println("6. Insert a country object into priority queue ");
				    System.out.println("7. Quit Program");
				    System.out.println("");
				    System.out.print("Enter your choice: ");
				    
				 
				    userInput = input.next();
				    System.out.println("");
				    }
		    	
	      }
	}

/** 
* The purpose of this method is to print option: printing the stack containing country 
* objects.
 */
	public static void printOptionOne() {
		System.out.printf("%-10s %15s %10s %10s %15s %15s %15s", "Name",   "Capitol",   "GDPPC",   "CFR",   "CaseRate",   "DeathRate",   "PopDensity\n");
		System.out.println("------------------------------------------------------------------------------------------------");
		countryStack.printStack();
	}

/** 
* The purpose of this method is to print option two: pop a country object from the top of
* the stack.
 */

	public static void printOptionTwo() {
		System.out.println(countryStack.pop());
	}
	
/** 
* The purpose of this method is to print option three: push a country object on to the stack.
* Allows users to insert any country along with its information.
 */	
	public static void printOptionThree() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter name: ");
		String name = userInput.next();
		System.out.print("");
		
		System.out.print("Enter capitol: ");
		String capitol = userInput.next();
		System.out.print("");
		
		System.out.print("Enter population: ");
		String population = userInput.next();
		System.out.print("");
		
		System.out.print("Enter GDP (USD): ");
		String gDP = userInput.next();
		System.out.print("");
		
		System.out.print("Enter COVID cases: ");
		String cases = userInput.next();
		System.out.print("");
		
		System.out.print("Enter COVID deaths: ");
		String deaths = userInput.next();
		System.out.print("");
		
		System.out.print("Enter Area (km2): ");
		String area = userInput.next();
		System.out.print("");
		
		Country newCountry = new Country(name,capitol,population,gDP,cases,deaths,area);
		
		countryStack.push(newCountry);
		
	}
	
/** 
* The purpose of this method is to print option four: print the beginning of the priority 
* queue.
 */
	public static void printOptionFour() {
		System.out.printf("%-10s %15s %10s %10s %15s %15s %15s", "Name",   "Capitol",   "GDPPC",   "CFR",   "CaseRate",   "DeathRate",   "PopDensity\n");
		System.out.println("------------------------------------------------------------------------------------------------");
		countryPQ.printPriorityQ();
	}
	
/** 
* The purpose of this method is print option five: to remove a country object from the
*  beginning of the priority queue.
 */
	public static void printOptionFive() {
			countryPQ.remove();
		}
	
/** 
* The purpose of this method is to print option six: insert a country object on to the priority queue.
* Allows users to insert any country along with its information.
*/
	public static void printOptionSix() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter name: ");
		String name = userInput.next();
		System.out.print("");
		
		System.out.print("Enter capitol: ");
		String capitol = userInput.next();
		System.out.print("");
		
		System.out.print("Enter population: ");
		String population = userInput.next();
		System.out.print("");
		
		System.out.print("Enter GDP (USD): ");
		String gDP = userInput.next();
		System.out.print("");
		
		System.out.print("Enter COVID cases: ");
		String cases = userInput.next();
		System.out.print("");
		
		System.out.print("Enter COVID deaths: ");
		String deaths = userInput.next();
		System.out.print("");
		
		System.out.print("Enter Area (km2): ");
		String area = userInput.next();
		System.out.print("");
		
		Country newCountry = new Country(name,capitol,population,gDP,cases,deaths,area);
		
		countryPQ.insert(newCountry);
		
	}
}
