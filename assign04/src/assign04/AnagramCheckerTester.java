package assign04;

import static org.junit.jupiter.api.Assertions.*;

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
	private String s1, s2;
	private String[] smallList, emptyList, midList, nullList;
	private AnagramChecker d;
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
		String result = d.sort(s1);
		assertEquals(result, "aaccerr");

	}

	/**
	 * this sets the use of sort on an empty String
	 */
	@Test
	void sort_EmptyString()
	{
		String result = d.sort("");
		assertEquals(result, "");
	}

	/**
	 * this sets the use of sort on an null value.
	 */
	@Test
	void sort_NullInput()
	{
		assertThrows(NullPointerException.class, () -> {
			d.sort(null);
		});
	}

	/**
	 * 
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
	 * 
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
		assertThrows(NullPointerException.class, () -> {d.insertionSort(null, null);});
	}
	
	/**
	 * 
	 */
	@Test
	void areAnagrams_EmptyString()
	{
		assertFalse(AnagramChecker.areAnagrams(s1,""));
	}
	
	/**
	 * 
	 */
	@Test
	void areAnagrams_noAnagrams()
	{
		assertFalse(AnagramChecker.areAnagrams("cart","meep"));
	}
	
	/**
	 * 
	 */
	@Test
	void areAnagrams_areAnagrams()
	{
		assertTrue(AnagramChecker.areAnagrams("cart","Trac"));
	}
	
	/**
	 * 
	 */
	@Test
	void areAnagrams_NullInput()
	{
		assertThrows(NullPointerException.class, () -> {AnagramChecker.areAnagrams(null, null);});
	}
	
	/**
	 * 
	 */
	@Test
	void getLargestAnagramGroup_NullPoint()
	{
		assertThrows(NullPointerException.class, () -> {AnagramChecker.getLargestAnagramGroup(nullList);});
	}
	
	/**
	 * 
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
	 * 
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
	 * 
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
	 * 
	 */
	@Test
	void getLargestAnagramGroup_ThreeGroup()
	{
		
	}
	
	/**
	 * 
	 */
	@Test
	void getLargestAnagramGroup_EmptyGroup()
	{
		
	}
	
	/**
	 * 
	 */
	@Test
	void getLargestAnagramGroupFile_NullPoint()
	{
		
	}
	
}
