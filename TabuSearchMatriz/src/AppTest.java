import junit.framework.TestCase;

public class AppTest extends TestCase {

	public void testApp() {
		String filename = "csv/data-test.csv";
		TabuSearch.main(new String[] { filename, "true" });
	}
}
