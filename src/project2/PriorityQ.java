package project2;

/** 
 * The PriorityQ class creates a priority queue using an array that inserts the country objects
 * in ascending order as well as allowing for removal of a country object.
 * 
 * @author <Kenniece Harris> 
 * @version <10/09/2022> 
 */ 
public class PriorityQ {

	private int arraySize;
	private Country[] priorityQArray;
	private int nItems;
	private int head;
	

	
/** 
* Stores the size of the priority queue, creates the array, and stores the number items.
* 
* @param  size, the size of the priority queue.
 */
	public PriorityQ(int size) {
		
		this.arraySize = size;
		this.priorityQArray = new Country[arraySize];
		this.nItems = 0;
		this.head = 0;
		
		
	}
	
/** 
* Inserts a country object into the priority queue based on its CFR.
* 
* @param  country, a country object.
 */
	public void insert(Country country) {
		
		double cfr1 = country.getCFR();
		
		if(isEmpty()) {
			priorityQArray[nItems] = country;
			nItems++;
		}
		
		else if(isFull())
		{
			System.out.println("Priority Queue is Full. Cannot Insert Country into Queue.");
		}
		
		else {
			int i;
			for(i = nItems - 1; i >= 0; i--) {
				double cfr2 = priorityQArray[i].getCFR();
				
				if(cfr1  < cfr2) {
					priorityQArray[i + 1] = priorityQArray[i];
					
				}
				
				else {
					break;
  			    }
				
			}
			
			priorityQArray[i + 1] = country;
			nItems++;
			
		}
		
	}
	
/** 
* Removes a country object from the priority queue if its is not empty.
* 
* @return either the removed country or a string stating the priority queue is empty.
 */
	public String remove() {
		
		if(isEmpty())
		{
			return "Priority Queue is Empty. Cannot Remove Country from Queue";
		}
		
		else {
			head++;
		   return priorityQArray[--nItems].getCountryData();
		}
	}
	
/** 
* Prints the priority queue. 
 */
	public void printPriorityQ() {
		
		for(int i = head; i < nItems; i++) {
			System.out.println(priorityQArray[i].getCountryData());
		}
	}
	
/** 
* Checks whether the priority queue is empty.
* 
* 
* @return if empty return true, else false. 
 */
	public boolean isEmpty() {
		return (nItems == 0);
	}
	
/** 
* Checks whether the priority queue is full.
* @return is the full return true, else false.
 */
	public boolean isFull() {
		return (nItems == arraySize);
	}
}
