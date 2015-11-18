package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class ElementInit {
	
	protected WebDriver driver;

	
	//对页面元素初始化
	public ElementInit(WebDriver driver)
	{
		this.driver=driver;
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
	            120);
	    PageFactory.initElements(finder, this);
	}
}
