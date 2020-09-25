package assign04;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Dixit && Krummenacher
 *
 */
class AnagramCheckerTester
{
	private String s1;
	private String[] smallList, emptyList, midList, nullList;
	private Comparator comp;

	@BeforeEach
	public void setUp()
	{
		smallList = new String[5];
		nullList = null;
		emptyList = new String[0];
		midList = new String[10];

		smallList[0] = "cat";
		smallList[1] = "the";
		smallList[2] = "act";
		smallList[3] = "teh";
		smallList[4] = "meep";
		
		midList[0] = "CAT";
		midList[1] = "cat";
		midList[2] = "meep";
		midList[3] = "your";
		midList[4] = "dcad";
		midList[5] = "mepE";
		midList[6] = "ACDC";
		midList[7] = "moop";
		midList[8] = "act";
		midList[9] = "lsat";

		s1 = "racecar";
		comp = ( a, b) -> ((String) a).compareTo((String) b);
	}

	/**
	 * this sets the use of sort an a small String
	 */
	@Test
	void sort_Small()
	{
		String result = AnagramChecker.sort(s1);
		assertEquals(result, "aaccerr");

	}

	/**
	 * this sets the use of sort on an empty String
	 */
	@Test
	void sort_EmptyString()
	{
		String result = AnagramChecker.sort("");
		assertEquals(result, "");
	}

	/**
	 * this sets the use of sort on an null value.
	 */
	@Test
	void sort_NullInput()
	{
		assertThrows(NullPointerException.class, () -> {
			AnagramChecker.sort(null);
		});
	}

	/**
	 * Checks insertion sort with a small size array with comparator

	 */
	@Test
	void insertionSort_smallList()
	{
		AnagramChecker.insertionSort(smallList, comp);
		String[] key = new String[5];
		
		key[0] = "act";
		key[1] = "cat";
		key[2] = "meep";
		key[3] = "teh";
		key[4] = "the";		
		
		assertArrayEquals(smallList, key);
	}
	
	/**
	 * Checks insertion sort with a mid size array with comparator
	 */
	@Test
	void insertionSort_midList()
	{
		
		String[] key = midList.clone();
		Arrays.sort(key);
		
		AnagramChecker.insertionSort(midList, comp);	
		assertArrayEquals(midList, key);
	}

	/**
	 * Testing for Null parameter handling
	 */
	@Test
	void insertionSort_NullInput()
	{
		assertThrows(NullPointerException.class, () -> {AnagramChecker.insertionSort(null, null);});
	}
	
	/**
	 * This method checks the handling of empty strings
	 */
	@Test
	void areAnagrams_EmptyString()
	{
		assertFalse(AnagramChecker.areAnagrams(s1,""));
	}
	
	/**
	 * This tests are Anagrams ability to handle no anagrams
	 */
	@Test
	void areAnagrams_noAnagrams()
	{
		assertFalse(AnagramChecker.areAnagrams("cart","meep"));
	}
	
	/**
	 * This tests are Anagrams ability to handle a pair of anagrams
	 */
	@Test
	void areAnagrams_areAnagrams()
	{
		assertTrue(AnagramChecker.areAnagrams("cart","Trac"));
	}
	
	/**
	 * This tests are Anagrams ability to handle null agruements
	 */
	@Test
	void areAnagrams_NullInput()
	{
		assertThrows(NullPointerException.class, () -> {AnagramChecker.areAnagrams(null, null);});
	}
	
	/**
	 * This tests getLargestAnagramGroup ability to handle null agruements
	 */
	@Test
	void getLargestAnagramGroup_NullPoint()
	{
		assertThrows(NullPointerException.class, () -> {AnagramChecker.getLargestAnagramGroup(nullList);});
	}
	
	/**
	 * This tests getLargestAnagramGroup ability to handle a tie in Anagram groups
	 */
	@Test
	void getLargestAnagramGroup_Tie()
	{
		
		String[] key = new String[2];
		
		key[0] = "act";
		key[1] = "cat";
		Arrays.sort(key);
		String[] answer = AnagramChecker.getLargestAnagramGroup(smallList);
		Arrays.sort(answer);
		assertArrayEquals(key, answer);
	}
	
	/**
	 * This tests getLargestAnagramGroup ability to handle one groups of anagrams
	 */
	@Test
	void getLargestAnagramGroup_OneGroup()
	{
		String[] answer = new String[6];
		String[] key = new String[2];
		
		answer[0] = "allergy";
		answer[1] = "meh";
		answer[2] = "meep";
		answer[3] = "gallery";
		answer[4] = "thanks";	
		answer[5] = "t";
		
		key[0] = "allergy";
		key[1] = "gallery";
		
		String[] result = AnagramChecker.getLargestAnagramGroup(answer);
		
		Arrays.sort(key);
		Arrays.sort(result);
		
		assertArrayEquals(key, result);
		
	}
	
	/**
	 * This tests getLargestAnagramGroup ability to handle two groups of anagrams
	 */
	@Test
	void getLargestAnagramGroup_TwoGroup()
	{
		String[] answer = new String[6];
		String[] key = new String[3];
		
		answer[0] = "allergy";
		answer[1] = "arts";
		answer[2] = "star";
		answer[3] = "gallery";
		answer[4] = "thanks";	
		answer[5] = "rats";
		
		key[0] = "star";
		key[1] = "rats";
		key[2] = "arts";
				
		
		String[] result = AnagramChecker.getLargestAnagramGroup(answer);
		
		Arrays.sort(key);
		Arrays.sort(result);
		
		assertArrayEquals(key, result);
	}
	
	/**
	 * This tests getLargestAnagramGroup ability to handle three groups of anagrams
	 */
	@Test
	void getLargestAnagramGroup_ThreeGroup()
	{
		String[] answer = new String[10];
		String[] key = new String[3];
		
		answer[0] = "allergy";
		answer[1] = "arts";
		answer[2] = "star";
		answer[3] = "gallery";
		answer[4] = "thanks";	
		answer[5] = "rats";
		answer[6] = "rat";
		answer[7] = "baker";
		answer[8] = "brake";
		answer[9] = "";
		
		key[0] = "star";
		key[1] = "rats";
		key[2] = "arts";
				
		
		String[] result = AnagramChecker.getLargestAnagramGroup(answer);
		
		Arrays.sort(key);
		Arrays.sort(result);
		
		assertArrayEquals(key, result);
	}
	
	/**
	 *  This tests when there are no matches
	 */
	@Test
	void getLargestAnagramGroup_NoAnagrams()
	{
		String[] answer = new String[6];
		String[] key = new String[0];
		
		answer[0] = "allrgy";
		answer[1] = "meh";
		answer[2] = "meep";
		answer[3] = "gallery";
		answer[4] = "thanks";	
		answer[5] = "t";
		
		String[] result = AnagramChecker.getLargestAnagramGroup(answer);
		
		assertArrayEquals(key, result);
	}
	
	/**
	 * This tests getLargestAnagramGroup ability to handle a bunch of Anagrams
	 */
	@Test
	void getLargestAnagramGroupFile_SampleWordList()
	{
		String[] answer = { "carets", "Caters", "caster", "crates", "Reacts", "recast", "traces" };
		String[] result = AnagramChecker.getLargestAnagramGroup("src/assign04/sample_word_list.txt");
		
		Arrays.sort(answer);
		Arrays.sort(result);
		
		assertArrayEquals(answer, result);
		
	}
	
	/**
	 * This tests getLargestAnagramGroup ability to find the only set of anagrams in one_Angarams.txt
	 */
	@Test
	void getLargestAnagramGroupFile_oneAnagram()
	{
		String[] answer = { "lame", "meal", "male" };
		String[] result = AnagramChecker.getLargestAnagramGroup("src/assign04/one_Anagram.txt");
		
		Arrays.sort(answer);
		Arrays.sort(result);
		
		assertArrayEquals(answer, result);
		
	}
	
	/**
	 * This tests  getLargestAnagramGroup to find no matching anagrams in a file.
	 */
	@Test
	void getLargestAnagramGroupFile_NoAnagram()
	{
		String[] answer = {};
		String[] result = AnagramChecker.getLargestAnagramGroup("src/assign04/No_Anagram.txt");
		
		assertArrayEquals(answer, result);
		
	}
	
	/**
	 * This tests when getLargestAnagramGroup is given an empty file
	 */
	@Test
	void getLargestAnagramGroupFile_EmptyFile()
	{
		String[] answer = {};
		String[] result = AnagramChecker.getLargestAnagramGroup("src/assign04/emptyFile.txt");
		
		assertArrayEquals(answer, result);
	}
	
	/**
	 * This tests the getLargest ability when there's no file there
	 */
	@Test
	void getLargestAnagramGroupFile_NoFile()
	{
		String[] result = {};
		assertArrayEquals(AnagramChecker.getLargestAnagramGroup("src/assign04/sam.txt"), result);
	}
	
}
