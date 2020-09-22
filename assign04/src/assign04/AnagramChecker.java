package assign04;

import java.util.Comparator;

/**
 * 
 * @author Pratyush & Jonathan
 *
 */
public class AnagramChecker {
	
	/**
	 * sort accepts on input string sorts through
	 * @param inputString
	 * @return resultString that's sorted
	 */
	public static String sort(String inputString) 
	{
		if(inputString.equals(null))
			throw new NullPointerException();
		
		inputString = inputString.toLowerCase();
		char tempVal;
		char[] charArray = inputString.toCharArray();
		int j;
		
		for(int i = 1; i<inputString.length(); i++) // goes through every of the unsorted array except index 0(already sorted)
		{
			tempVal = charArray[i];
			for(j = i-1; j>=0 && charArray[j] > tempVal; j--)
			{
				charArray[j+1]=charArray[j];
			}
			charArray[j+1] = tempVal;
		}
		 
		
		return new String(charArray);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param inputTArray
	 * @param inputComp
	 */
	public static <T> void insertionSort(T[] tArray, Comparator<? super T> inputComp) 
	{
		
	}
	
	/**
	 * 
	 * @param inputString
	 * @param secondInputString
	 * @return
	 */
	public static boolean areAnagrams(String inputString, String secondInputString) 
	{
		return sort(inputString).equals(sort(secondInputString));
	}
	
	/**
	 * 
	 * @param inputStringArray
	 * @return
	 */
	public static String[] getLargestAnagramGroup(String[] inputStringArray) 
	{
		
		return null;
	}
	
	/**
	 * 
	 * @param filename
	 * @return
	 */
	public static String[] getLargestAnagramGroup(String filename) 
	{
		return null;
	}
	
	public static void main(String[] args) 
	{
			System.out.println(sort("abc"));
			System.out.println(sort("cba"));
			System.out.println(sort("cbaABDA"));
			System.out.println(sort("yourS"));
	}

//Insertion sort application
	//5 Methods
}
