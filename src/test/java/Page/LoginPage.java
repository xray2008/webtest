package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

import Common.ElementInit;

@Test
public class LoginPage extends ElementInit {
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//email输入框
	@FindBy(how=How.ID,using="login_email")
	public static WebElement login_email;
	
	//password输入框
	@FindBy(how=How.NAME,using="password")
	public static WebElement login_password;
	
	//登录button
	@FindBy(how=How.XPATH,using="/html/body/div/div/section[2]/form/button")
	public static WebElement login_btn;
	
	public void login(WebDriver driver,String username,String pwd)
	{
		driver.get("http://www.ksyun.com/user/login");
		login_email.clear();
		login_email.sendKeys(username);
		login_password.clear();
		login_password.sendKeys(pwd);
		login_btn.click();
 	}	
}
