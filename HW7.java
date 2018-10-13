/*Hannah Posch
* HW 7, Summer 2018
* The code in this file will utilize two selection algorithms to find the kth largest number in a group of N numbers.
* This code will also be used to generate the time it takes for each algorithm to complete which will be compared in another document.
*/
import java.util.Random;
import java.util.Scanner;

public class HW7 extends HW7_AbstractClass{

	/*
	 * selection1 : This method utilizes a priority queue to organize N number of elements and return the kth element.
	 * The method performs k deleteMin operations and returns the last element extracted as the answer.
	 * @param N value 
	 * @return Kth value 
	 */
	public int selection1(int N) {
		Random rand = new Random();
		int K = N/2;
		int kElement = 0;
		Integer[] b = new Integer[N];
		
		//Array filled with N number of elements to build priority queue
		for(int i = 0; i<N; i++) {	
			b[i] = rand.nextInt(100);
		}
		
		a = new BinaryHeap<Integer>(b);
		

		
		//K number of delete min
		for( int i = 0; i < K; i++ ) {
            try {
            		
            		kElement = a.deleteMin( );
            			
			} 
            catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return kElement;
	}

	/*
	 * selection2 : This method utilizes a priority queue to store the first K elements. Then the method compares
	 * the rest of the new elements generated and if larger, the top element is removed and the new element is added.
	 * The smallest element on top is returned at the end.
	 * @param N value 
	 * @return Kth value 
	 */
	public int selection2(int N) {
		Random rand = new Random();
		int K = N/2;
		int kElement = 0;
		int randNumToCheck, minNumToCheck;
		
		a = new BinaryHeap<>( );
		
		//Priority queue filled with K number of elements
		for(int i = 0; i<K; i++) {	
			a.insert( rand.nextInt(100) );
		}
		
		//Rest of elements generated and compared
		for(int i = 0; i<N-K; i++) {
			randNumToCheck = rand.nextInt(100);	
			try {
				minNumToCheck = a.findMin();
				if(randNumToCheck > minNumToCheck) {
					a.deleteMin();
					a.insert(randNumToCheck);			
				}//if
			} //try
			catch (Exception e) {
				
				e.printStackTrace();
			} //catch	
			
		}//for
		
		//Smallest element is found to return
		try {
			kElement = a.findMin();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return kElement;
	}
	
	/*
	 * main: This method calls each of the selection methods with an N value provided by the user. The method records the time
	 * each selection method takes, records the difference and prints the time and Kth values.
	 * @precondition N value must be supplied by user to continue
	 */
   public static void main( String [ ] args ) throws Exception{
	   
	   Scanner scnr = new Scanner(System.in);
	   HW7 homework7 = new HW7();
	   long timeBeforeSel1, timeAfterSel1, timeBeforeSel2, timeAfterSel2, lengthOfTimeSel1, lengthOfTimeSel2;
	   int kValueSel1 = 0;
	   int kValueSel2 = 0;
	   
	   //N value entered
	   System.out.println("Enter a value for N: ");
	   int nValue = scnr.nextInt();
	   
	   //Selection1
	   timeBeforeSel1 = System.currentTimeMillis();
	   kValueSel1 = homework7.selection1(nValue);
	   timeAfterSel1 = System.currentTimeMillis();
	   System.out.println("Selection 1 Value at K: " + kValueSel1);
	   lengthOfTimeSel1 = timeAfterSel1 - timeBeforeSel1;
	   System.out.println("Selection 1 Time: " + lengthOfTimeSel1 + " ms\n");
		
	   //Selection 2
	   timeBeforeSel2 = System.currentTimeMillis();
	   kValueSel2 = homework7.selection2(nValue);
	   timeAfterSel2 = System.currentTimeMillis();
	   System.out.println("Selection 2 Value at K: " + kValueSel2);
	   lengthOfTimeSel2 = timeAfterSel2 - timeBeforeSel2;
	   System.out.println("Selection 2 Time: " + lengthOfTimeSel2 + " ms");
		
	   scnr.close();
               
   }

}
