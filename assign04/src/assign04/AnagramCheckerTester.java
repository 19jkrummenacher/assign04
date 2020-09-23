package assign04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramCheckerTester
{

	@BeforeEach
	public void setUp()
	{
		String[] smallList = new String[5];
		String[] emptyList = null;
		String[] midList = new String[10];
		
		smallList[0] = "";
		smallList[1] = "";
		smallList[2] = "";
		smallList[3] = "";
		smallList[4] = "";
		
	}
	
	@Test
	void areAnagrams_EmptyString()
	{
		
	}

}
