package unitExample;

import org.junit.After;
import org.junit.Before;

public class BaseTest {
	
	@Before
	public void launchApp() {
		
		System.out.println("launching application");
		
	}
	
	@After
	public void closingApp() {
		
		System.out.println("closing application");
		
	}

}
