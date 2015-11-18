package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitWebElement {
	public void WaitWebElementLoading(WebDriver driver,String path)
	{
		new WebDriverWait(driver, 300).until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
	}
}
