package assign04;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * @author Dixit  & Krummenacher
 *
 */
public class AnagramChecker {
	
	/**
	 * sort accepts on input String by breaking it up into chars and doing an insertion sort and them combining it together again.
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
	 * sort accepts an array of type T and a comparator for Type 
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
	 * Checks whether the two given strings are anagrams or not.Returns true if they are.
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
		ArrayList<String> resultList = new ArrayList<String>();
		String[] result = null;
		int max = 0;
		int currentMax = 1;
		
		insertionSort(inputStringArray,(a, b) ->sort(a).compareTo(sort(b)));
		if(inputStringArray.length > 0)
		{
			resultList.add(inputStringArray[0]);
			for(int i = 1; i<inputStringArray.length; i++)
			{
				if(areAnagrams(inputStringArray[i], inputStringArray[i-1]))
				{
					currentMax++;
					resultList.add(inputStringArray[i]);
				}
				else
				{
					if(currentMax > max)
					{
						max = currentMax;
						System.out.println(resultList.toString());
						result = (String[]) resultList.toArray();
						resultList.clear();
					}
					currentMax = 0;
				}
			}
		}
		//result = {{"cat","act","cta"},{"at","ta"}};
		return result;
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
			System.out.println(getLargestAnagramGroup(arr) == null);
	}

//Insertion sort application
	//5 Methods
}
