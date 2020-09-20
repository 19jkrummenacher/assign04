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
		
		String resultString = inputString.charAt(0) + "";
		String tempVal;
		
		for(int i = 1; i<inputString.length(); i++) // goes through every of the unsorted array except index 0(already sorted)
		{
			tempVal = inputString.charAt(i) + "";
			int j = i-1;
			while( j >= 0 && Character.getNumericValue(inputString.charAt(i)) > Character.getNumericValue(tempVal.charAt(0))) //inserts the tempVal into the sorted string
			{
				resultString += tempVal.charAt(0);
							
					
				
				j--;
			}
		}
		
		
		return resultString;
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
		return false;
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
			System.out.println(sort("cba"));
	}

//Insertion sort application
	//5 Methods
}
