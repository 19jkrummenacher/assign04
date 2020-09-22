package assign04;

import java.util.Comparator;

/**
 * 
 * @author Dixit  & Krummenacher
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
		//Checks for empty Strings
		if(inputString.equals(null))
			throw new NullPointerException();
		//Lowers the input string for comparison
		inputString = inputString.toLowerCase();
		char targetVal;
		char[] charArray = inputString.toCharArray();
		int j;
		
		for(int i = 1; i<inputString.length(); i++) // goes through every of the unsorted array except index 0(already sorted)
		{
			targetVal = charArray[i];
			for(j = i-1; j>=0 && charArray[j] > targetVal; j--)
			{
				charArray[j+1]=charArray[j];
			}
			charArray[j+1] = targetVal;
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
