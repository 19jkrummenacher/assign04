package assign04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

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
			for(int i = 0; i<inputStringArray.length-1; i++)
			{
				if(areAnagrams(inputStringArray[i], inputStringArray[i+1]))
				{
					currentMax++;
					resultList.add(inputStringArray[i]);
					result = (String[]) resultList.toArray(new String[resultList.size()]);	
				}
				else
				{
					if(currentMax > max)
					{
						resultList.add(inputStringArray[i]);
						max = currentMax;
						result = (String[]) resultList.toArray(new String[resultList.size()]);
						resultList.clear();
					}
					currentMax = 1;
				}
			}
		}
		if(result.length == 1)
			result = null;
		return result;
	}
	
	/**
	 * 
	 * @param filename
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static String[] getLargestAnagramGroup(String filename)
	{
		ArrayList<String> result = new ArrayList<String>();
		File file;
		Scanner s;
		try
		{
			file = new File(filename);
			s = new Scanner(file);
		}
		catch(FileNotFoundException e)
		{
			return null;
		}
		
		while(s.hasNext())
		{
			result.add(s.next());
		}
		s.close();
		
		return getLargestAnagramGroup(result.toArray(new String[result.size()]));
	}
	
	public static  <T> void main(String[] args) 
	{
			System.out.println(sort("abc"));
			System.out.println(sort("cba"));
			System.out.println(sort("cbaABDA"));
			System.out.println(sort("yourS"));
			System.out.println(areAnagrams("RonaldReagan","Adarnlongera"));
			String [] arr = new String[6];
			arr[0]="cba";
			arr[1]="abc";
			arr[2]="cbaABDA";
			arr[3]="yourS";
			arr[4]="anagrams";
			arr[5]="bac";
			System.out.println(Arrays.toString(getLargestAnagramGroup(arr)));
			String file = "src\\assign04\\sample_word_list.txt";
	}

//Insertion sort application
	//5 Methods
}
