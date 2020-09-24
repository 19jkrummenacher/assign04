package assign04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramCheckerTester
{
	private String s1,s2;
	private String[] smallList , emptyList ,midList;
	private AnagramChecker d;

	@BeforeEach
	public void setUp()
	{
		 smallList = new String[5];
		 emptyList = new String[0];
	      midList = new String[10];
		
		smallList[0] = "";
		smallList[1] = "";
		smallList[2] = "";
		smallList[3] = "";
		smallList[4] = "";
		
		
		s1="racecar";
	}
	@Test
	void sort_Small()
	{
		String result = d.sort(s1);
		assertEquals(result,"aaccerr");
		
	}
	@Test
	void areAnagrams_EmptyString()
	{
		
	}

}
