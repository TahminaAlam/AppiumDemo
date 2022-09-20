package appiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.SupportsContextSwitching;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import org.openqa.selenium.remote.RemoteWebDriver; 

 

public class eCommarce_tc_2 {
	
	
	  public double getFormatedAmount(String amount)
      {
      	Double price = Double.parseDouble(amount.substring(1));
      	return price;
      }
	  
	  
	  
	@Test
	public void Cart() throws MalformedURLException, InterruptedException
	{
		
		//code to start the server
		AppiumDriverLocalService Service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\tahmi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		Service.start();
		
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("pixel_3");
        options.setChromedriverExecutable("C:\\Users\\tahmi\\Downloads\\chromedriver");
        //new app
        options.setApp("C:\\Users\\tahmi\\eclipse-workspace\\appiumTest\\src\\test\\java\\resources\\General-Store.apk");
		//Android Driver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait maximum 10 seconds to run a test
		//Appium code -> Appium server ->  Mobile
        
        //Actual Test
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.className("android.widget.ListView"));
		driver.findElement(AppiumBy.xpath("(//android.widget.TextView)[8]")).click();
     
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Mou");
		driver.hideKeyboard();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")).click();
		driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait1.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));
 
		Thread.sleep(6000);
		List<WebElement> produtPrices = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
		int count = produtPrices.size();
		double totalSum = 0;
		for(int i=0; i<count; i++)
		{
			String amountString = produtPrices.get(i).getText(); 
			double price = getFormatedAmount(amountString);
			totalSum = totalSum + price;
			System.out.println("totalSum: " + totalSum);
		}
		
		String displaysum = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double displayFormatedsum = getFormatedAmount(displaysum);
		System.out.println("displayFormatedsum: " +displayFormatedsum);
		//Assert.assertEquals(totalSum, displayFormatedsum);
		Thread.sleep(5000);
		
		WebElement ele = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
					ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000 ));
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		
		//driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.CheckBox")).click();  
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(6000);
		Set<String> contexts = driver.getContextHandles(); //this method get all the active contexts(native app is one context, webview is another context)
		for (String contextName :contexts)
		{
			System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore"); //switch the mode from native app to web browser 
        driver.findElement(AppiumBy.name("q")).sendKeys("appium");
        driver.findElement(AppiumBy.name("q")).sendKeys(Keys.ENTER);
		
		
        
        
	 
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    driver.context("NATIVE_APP");
	    
	    
//		Thread.sleep(5000);
//		
//		Set a = driver.getContextHandles();
//
//        System.out.println(a);
//
//        if (driver.getContext().equals("NATIVE_APP")){
//
//        	driver.context("CHROMIUM");
//
//            System.out.println("Switched to WebView");
//
//        } else if (driver.getContext().equals("CHROMIUM")){
//
//            System.out.println("Was Already On WebView");
//
//        }
	
		
//		((WebDriver) options).navigate().back();
//		 ((SupportsContextSwitching) options).context("NATIVE_APP");
		 
		 
		
	    
	    
		//Hybrid(hybridApp handels both native app$android) - Google page->
	}
	
	
	
	

}



