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
		// Checks for empty Strings
		if (inputString.equals(null))
			throw new NullPointerException();
		// Lowers the input string for comparison
		inputString = inputString.toLowerCase();
		char targetVal;
		char[] charArray = inputString.toCharArray();
		int j;
		for (int index = 1; index < inputString.length(); index++) // goes through every of the unsorted array except															// index 0(already sorted)
		{
			targetVal = charArray[index];
			for (j = index - 1; j >= 0 && charArray[j] > targetVal; j--) {
				charArray[j + 1] = charArray[j];
			}
			charArray[j + 1] = targetVal;
		}
		return new String(charArray);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param inputTArray
	 * @param inputComp
	 */
	public static <T> void insertionSort(T[] inputArr, Comparator<? super T> inputComp) 
	{
	T key;
	int j;
	for(int i=1; i<inputArr.length; i++)
	{
		key= inputArr[i];
		
		for(j= i-1; j>=0 && inputComp.compare(inputArr[j], key)> 0 ;j--)
		{
			inputArr[j+1]=inputArr[j];
		}
		inputArr[j+1]=key;
	}
	System.out.println(inputArr.toString());
		
	}
	
	/**
	 * Checks whether the two given strings are anagrams or not.Returns truw if they are.
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
	
	public static  <T> void main(String[] args) 
	{
			System.out.println(sort("abc"));
			System.out.println(sort("cba"));
			System.out.println(sort("cbaABDA"));
			System.out.println(sort("yourS"));
			System.out.println(areAnagrams("RonaldReagan","Adarnlongera"));
			String [] arr = new String[5];
			arr[0]="cba";
			arr[1]="abc";
			arr[2]="cbaABDA";
			arr[3]="yourS";
			arr[4]="anagrams";
	}

//Insertion sort application
	//5 Methods
}
