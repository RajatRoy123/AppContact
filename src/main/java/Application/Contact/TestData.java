package Application.Contact;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestData {

	@DataProvider(name="InputData")
		public Object[][] DataForContact()
	{
		Object[][] obj = new Object[][]
				{
					{"test123", "1236777"}, {"test1234", "12368777"}
				};
		return obj;
		
		
	}
	

	

}
