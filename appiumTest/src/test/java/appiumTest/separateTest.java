package appiumTest;

import java.net.MalformedURLException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class separateTest extends InheritTest{

	
//	        @BeforeMethod
//	        public void preSetup()
//	        {
//	        Activity activity= new Activity("com.androidsample.generalstore" , "com.androidsample.generalstore.MainActivity");
//	        driver.startActivity(activity);//screen to homepage
//	        }
		   
	        @Test
		    public void Test1() throws MalformedURLException, InterruptedException
		    {
	        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
			driver.findElement(AppiumBy.className("android.widget.ListView"));
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));"));		
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Afghanistan\"));"));
			driver.findElement(AppiumBy.xpath("(//android.widget.TextView)[8]")).click();
	        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	        String toastMessage = driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
	        Assert.assertEquals(toastMessage ,"Please enter your name");
		    }
		
	        @Test
			public void Test2() throws MalformedURLException, InterruptedException
			{
			driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Mou");
			driver.hideKeyboard();
			driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
			driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			}
	        
	        @Test
			public void Test3() throws MalformedURLException, InterruptedException
			{
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
		}

	}

