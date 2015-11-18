package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Common.ElementInit;

public class ControlIndexPage extends ElementInit {
	
	public ControlIndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how=How.XPATH,using="/html/body/article/article/section/div/div/a")
	public static WebElement KVM_linktext;
	
	public void ClickKvmRegion()
	{
		
		KVM_linktext.click();
	}
}
