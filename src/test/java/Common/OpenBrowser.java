package Common;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class OpenBrowser {

	public FirefoxProfile Openbrowser() 
	{
		//配置浏览器
		System.setProperty("webdriver.firefox.bin", "D:/Program Files (x86)/Mozilla Firefox/firefox.exe");
		
		//浏览器使用firefox的现有配置
		ProfilesIni pi = new ProfilesIni();
		FirefoxProfile profile = pi.getProfile("default");	
		
		
		return profile;	
	}
	
	public void SwitchNewFirefoxPage(WebDriver driver)
	{
		String currentWindow = driver.getWindowHandle();//获取当前窗口句柄
		Set<String> handles = driver.getWindowHandles();//获取所有窗口句柄
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
		if (currentWindow == it.next()) {
		continue;
		}
		WebDriver window = driver.switchTo().window(it.next());//切换到新窗口
		}
	}
}


