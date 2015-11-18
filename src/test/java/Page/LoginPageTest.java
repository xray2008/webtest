package Page;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Common.OpenBrowser;

public class LoginPageTest {

	static OpenBrowser op=new OpenBrowser();
	static WebDriver driver=new FirefoxDriver(op.Openbrowser());
	public static LoginPage login=new LoginPage(driver);
	@Before
	public void setUp() throws Exception {
//		OpenBrowser op=new OpenBrowser();
//		WebDriver driver=new FirefoxDriver(op.Openbrowser());
//		LoginPage login=new LoginPage(driver);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogin() {
		login.login(driver, "ksc_test3@163.com", "Ksc@kingsfot123");
	}

}
