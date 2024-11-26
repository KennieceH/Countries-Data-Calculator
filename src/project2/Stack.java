package project2;

/** 
 *The Stack class creates a stack containing country objects that can either be pushed/popped 
 *from the stack.
 * 
 * @author <Kenniece Harris> 
 * @version <10/09/2022> 
 */ 
public class Stack {
	
	private Country[] stackArray;
	private int arraySize;
	private int head;
	
/** 
* Stores the size of the array, creates the array for the stack and the head.
* 
* @param  size, the size of the array.
 */
	public Stack(int size) {
		
		this.arraySize = size;
		this.stackArray = new Country[arraySize];
		this.head = -1;
	}
	
/** 
* Pushes a country object to the stack only if it is empty.
* 
* @param  country, a country object. 
 */
	public void push(Country country) {
		
		if(isFull() == true)
		{
			System.out.println("The stack is full, cannot push item to stack.");
		}
		
		else {stackArray[++head] = country;}
	}
	
/** 
* Pops a country object from the stack only if it is not empty.
* 
* @return pop, the country removed from the stack. 
 */
	public String pop() {
		
		String pop ="";
		
		if(isEmpty() == true) {
			
			System.out.println("The stack is empty, cannot pop item from stack.");
		}
		
		else {pop = stackArray[head--].getCountryData();}
		
		return pop;
	}
	
	
/** 
* Prints the stack of country objects.
 */
	public void printStack() {
		for(int i = head; i >= 0 ; i--) {
			System.out.println(stackArray[i].getCountryData());
		}
	}
	
/** 
* Checks whether the stack is empty.
* 
* @return empty, if the stack is empty (true) or not (false).
 */
	public boolean isEmpty() {
		
		boolean empty = false;
		
		if(head == - 1)
		{
			empty = true;
		}
		return empty;
	}
	
/** 
* Checks whether the stack is full.
* 
* @return full, if the stack is full (true) or not (false).
 */
	public boolean isFull() {
		
		boolean full = false;
		
		if(head == arraySize - 1)
		{
			full = true;
		}
		return full;
	}
}
