package appiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_1 {
	
	
	  public double getFormatedAmount(String amount)
      {
      	Double price = Double.parseDouble(amount.substring(1));
      	return price;
      }
	
	@Test
	public void FillForm() throws MalformedURLException, InterruptedException
	{
		
		//code to start the server
		AppiumDriverLocalService Service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\tahmi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		Service.start();
		
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("pixel_3");
        //new app
        options.setApp("C:\\Users\\tahmi\\eclipse-workspace\\appiumTest\\src\\test\\java\\resources\\General-Store.apk");
		
		//Android Driver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait maximum 10 seconds to run a test
		//Appium code -> Appium server ->  Mobile
        
        //Actual Test
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.className("android.widget.ListView"));
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));"));		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Afghanistan\"));"));
		driver.findElement(AppiumBy.xpath("(//android.widget.TextView)[8]")).click();
        //Thread.sleep(3000);
		
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String toastMessage = driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        Assert.assertEquals(toastMessage ,"Please enter your name");
        //Thread.sleep(3000);	
	

		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Mou");
		driver.hideKeyboard();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		driver.findElement(AppiumBy.xpath("(//android.widget.TextView)[1]")).click();
	    int productCount = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).size();
		for (int i=0; i<productCount; i++)
		{
		String productName = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).get(i).getText();
		if(productName.equalsIgnoreCase("Jordan 6 Rings"))
				{
			     driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				}
		}
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		//Wait until cart page is open
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));
		
		String cartPage = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(cartPage, "Jordan 6 Rings");
		//Thread.sleep(2000);
		//driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_back")).click();
		//driver.findElement(AppiumBy.xpath("(/android.widget.ImageButton)[0]")).click();
		//driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_back")).click();
		//driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_back"));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

      
//		Thread.sleep(2000);
//		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike SFB Jungle\"));"));
//		driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")).click();
//		driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")).click();
//		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait1.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));
// 
//		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike SFB Jungle\"));"));	
//		List<WebElement> produtPrices = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
//		int count = produtPrices.size();
//		double totalSum = 0;
//		for(int i=0; i<count; i++)
//		{
//			String amountString = produtPrices.get(i).getText(); 
//			//Double price = Double.parseDouble(amountString.substring(1));
//			Double price = getFormatedAmount(amountString);
//			totalSum = totalSum + price;
//		}
//		
//		String displaysum = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
//		Double displayFormatedsum = getFormatedAmount(displaysum);
//		//Assert.assertEquals(totalSum, displayFormatedsum);
//		
		
		
		
		
		
		//		Thread.sleep(5000);
//	    driver.quit();//stop the driver
//		Service.stop();//code to stop server
		
	}
	
	
	
	

}



