package assign04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 * @author Dixit & Krummenacher
 *
 */
public class AnagramChecker
{

	/**
	 * Using insertion sort , this method sorts an String lexicographically.
	 * 
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
		int loopCounter;
		for (int index = 1; index < inputString.length(); index++) // goes through every of the unsorted array except //
																	// index 0(already sorted)
		{
			targetVal = charArray[index];
			for (loopCounter = index - 1; loopCounter >= 0 && charArray[loopCounter] > targetVal; loopCounter--)
			{
				charArray[loopCounter + 1] = charArray[loopCounter];
			}
			charArray[loopCounter + 1] = targetVal;
		}
		return new String(charArray);
	}

	/**
	 * Sorts an generic array with insertion sort and uses Comparator object for
	 * comparison
	 * 
	 * @param <T>
	 * @param inputTArray
	 * @param inputComp
	 */
	public static <T> void insertionSort(T[] inputArr, Comparator<? super T> inputComp)
	{
		T key;
		int loopIndex;
		for (int index = 1; index < inputArr.length; index++)
		{
			key = inputArr[index];

			for (loopIndex = index - 1; loopIndex >= 0 && inputComp.compare(inputArr[loopIndex], key) > 0; loopIndex--)
			{
				inputArr[loopIndex + 1] = inputArr[loopIndex];
			}
			inputArr[loopIndex + 1] = key;
		}
	}

	/**
	 * Checks whether the two given strings are anagrams or not.Returns true if they
	 * are.
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
	 * This method finds the largest group of anagrams in a Array of Strings.
	 * Returns an empty array if no anagrams are present.
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

		insertionSort(inputStringArray, (a, b) -> sort(a).compareTo(sort(b)));

		if (inputStringArray.length > 0)
		{
			for (int index = 0; index < inputStringArray.length - 1; index++)
			{
				if (areAnagrams(inputStringArray[index], inputStringArray[index + 1]))
				{
					currentMax++;
					resultList.add(inputStringArray[index]);
					result = (String[]) resultList.toArray(new String[resultList.size()]);
				} else
				{
					if (currentMax > max)
					{
						resultList.add(inputStringArray[index]);
						max = currentMax;
						result = (String[]) resultList.toArray(new String[resultList.size()]);
						resultList.clear();
					}
					currentMax = 1;
				}
			}
		}
		if (result.length == 1)
			result = new String[0];
		return result;
	}

	/**
	 * This method finds the largest group of anagrams in a File. Returns an empty
	 * array if no anagrams are present.
	 * 
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String[] getLargestAnagramGroup(String filename)
	{
		ArrayList<String> result = new ArrayList<String>();
		File file;
		Scanner scn;
		try
		{
			file = new File(filename);
			scn = new Scanner(file);
		} catch (FileNotFoundException e)
		{
			return new String[0];
		}

		while (scn.hasNext())
		{
			result.add(scn.next());
		}
		scn.close();

		return getLargestAnagramGroup(result.toArray(new String[result.size()]));
	}

	public static <T> void main(String[] args)
	{
		System.out.println(sort("abc"));
		System.out.println(sort("cba"));
		System.out.println(sort("cbaABDA"));
		System.out.println(sort("yourS"));
		System.out.println(areAnagrams("RonaldReagan", "Adarnlongera"));
		String[] arr = new String[4];
		arr[0] = "cba";
		// arr[1]="abc";
		arr[1] = "cbaABDA";
		arr[2] = "yourS";
		arr[3] = "anagrams";
		// arr[5]="bac";
		System.out.println(Arrays.toString(getLargestAnagramGroup(arr)));

	}
}
