package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Page.ControlIndexPage;
import Page.KvmListPage;
import Page.LoginPage;

public class test {	
	public static void main(String[] args)throws Exception{
	
		OpenBrowser op=new OpenBrowser();
		WebDriver driver=new FirefoxDriver(op.Openbrowser());
		
		String username="ksc_test3@163.com";
		String password="Ksc@kingsoft123";
		String region="上海1区";
		String kvm_name="ksc-600780217210502484";
		
		LoginPage login=new LoginPage(driver);
		login.login(driver,username, password);
		
		driver.get("http://www.ksyun.com/console/vm/instance/list");
//		ControlIndexPage c=new ControlIndexPage(driver);
//		c.ClickKvmRegion();
		
		KvmListPage k=new KvmListPage(driver);
		k.selectOptionByValue(region);
		
		int rownum=k.GetRowNum(kvm_name,2);
		k.SelectCheckBox(rownum);
		
	}

}
