package Page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import Action.WaitWebElement;
import Common.ElementInit;

public class KvmListPage extends ElementInit {
	
	public KvmListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//下拉框打开之前的控件，必须打开，否则找不到下拉框
	@FindBy(how=How.ID,using="ui-id-1-button")
	public static WebElement region_list;
	
	//下拉框
	@FindBy(how=How.XPATH,using="/html/body/div/ul")
	public static WebElement select_region;
	
	///table元素
	@FindBy(how=How.XPATH,using="html/body/article/div/div/section/table/tbody/")
	public static WebElement table;
	
	@FindBy(how=How.XPATH,using="/html/body/article/div/div/section/table/tbody/tr")
	public static WebElement rows;
	
	//下拉列表选择机房
	public void selectOptionByValue(String regiontext) throws InterruptedException
	{
		region_list.click();
		Thread.sleep(3);
		
		List <WebElement> allOptions=select_region.findElements(By.className("ui-menu-item"));
		//遍历allOptions
        for (WebElement option : allOptions) {
            if (regiontext.equals(option.getText()))
            {
                option.click();
                Thread.sleep(3);
                break;
            }
        }
	}
	
	//获取所在行数
	public  int GetRowNum(String name,int linenum) throws Exception
	{	
		int rownum=0;
		List <WebElement> allOptions=driver.findElements(By.xpath(Xpath.row_xpath));
		for(WebElement option:allOptions)
		{
			String text="没有查询到符合条件的主机";
			if(text.equals(option.getText().trim()))
			{
				throw new Exception("列表为空：没有查询到符合条件的主机");
			}
		}
		
		System.out.println("KvmList的行数为："+allOptions.size());
		
		//等待元素加载
//		String path="/html/body/article/div/div/section/table/tbody/tr";
		WaitWebElement wait=new WaitWebElement();
		wait.WaitWebElementLoading(driver, Xpath.row_xpath);

		//通过for循环获取kvm所在行数
		for(int i=1;i<=allOptions.size();i++)
		{
			String name_xpath=Xpath.row_xpath+"["+i+"]/td["+linenum+"]";
			WebElement name_text=driver.findElement(By.xpath(name_xpath));
			if(name.equals(name_text.getText().trim()))
			{
				rownum=i;
				System.out.println("rownum："+i);
				break;
			}
		}
		if(rownum==0)
		{
			throw new Exception("Cannot find the kvm in the kvm list");
		}
		return rownum;
	}
	
	//选择kvmlist对应的checkbox
	public void SelectCheckBox(int rownum)
	{
		System.out.println("选择第 "+rownum+" 行");
		String checkbox_xpath="/html/body/article/div/div/section/table/tbody/tr["+rownum+"]/td/a";
		WebElement checkbox=driver.findElement(By.xpath(checkbox_xpath));
		checkbox.click();
	}
}
