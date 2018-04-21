package com.nbcd.Pages;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.GenericLib.Synchronization;
import com.nbcd.GenericLib.Utilities;
import com.relevantcodes.extentreports.LogStatus;
@Test
//=======================================CLASS & METHODS===========================================================================================

public class PGTVE 
{
	
	private  WebDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	
	public List<String> lstObject,lstTestData;
	String sqlQry,Status;
	WebElement objnav,objRespNavBar;
	//=================================================Business Logic====================================================================
	//Constructor to initialize all the Page Objects  
	
	public PGTVE(WebDriver driver) throws MalformedURLException 
	{      
		
		this.driver = driver; 
		lstTestData=db.getTestDataObject("Select * from TVE","Input");
		lstObject=db.getTestDataObject("Select * from TVE","ObjectRepository");
	
	}
	
	//=========================================================================================================================
@Test
	public  PGTVE Authvod() throws Exception 
	{
   	 //Launching the URL
	driver.manage().deleteAllCookies();

       		driver.get(lstTestData.get(0));
       		driver.navigate().refresh();
       		 Thread.sleep(10000);
       		try {
    			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "NBC Home Page should Launch"
    					+ Extent_Reports.logActual + "NBC Home page launched succesfull", driver);

    		} catch (Exception exc) {
    			System.out.println(exc.getMessage());
    		}
	       	WebElement objnav =Utilities.returnElement(driver,lstObject.get(2),lstObject.get(1));
	       	objnav.click();
	       	Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Click on Shows" + Extent_Reports.logActual
					+ "Shows Link is clicked from global navigation", driver);
	       	
			List<WebElement> objShowLists = Utilities.returnElements(driver, lstObject.get(5), lstObject.get(4));
			List<WebElement> objShowList = objShowLists.get(0).findElements(By.tagName("li"));
			int ilinksMenuCount = objShowList.size();
			for (int ilinksIterator = 0; ilinksIterator < ilinksMenuCount; ilinksIterator++) {
				String strMenuLinkName = objShowList.get(ilinksIterator).getText();
				if (strMenuLinkName.contentEquals("This Is Us")) {
					objShowList.get(ilinksIterator).click();
					Thread.sleep(40000);
					Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Click on Shows" + Extent_Reports.logActual+ "Shows Link is clicked from global navigation and the show is "+ strMenuLinkName,driver);
					break;
				}

			}       		
			List <WebElement> objloadbutton = Utilities.returnElements(driver,lstObject.get(11),lstObject.get(10));
			objloadbutton.get(0).click();
			Thread.sleep(20000);
			Synchronization.waitForPageLoad(driver);
	       	List <WebElement> objauthcode = Utilities.returnElements(driver,lstObject.get(8),lstObject.get(7));
			
			if(objauthcode.size()>0)
			{
				objauthcode.get(0).click();
				Thread.sleep(30000);
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Auth code required video should be clicked"+Extent_Reports.logActual+"Auth code required video is clicked", driver);
				
			}
			else
			{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected+"Show doesn't have Auth videos"+Extent_Reports.logActual+"Show does not have Auth Video", driver);
				
			}
		
			//Synchronization.waitForPageLoad(driver);
	      	WebElement objTVProvider = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
			//wait.until(ExpectedConditions.visibilityOf(objTVProvider.get(1)));
			objTVProvider.click();
			Thread.sleep(10000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider should be clicked"+Extent_Reports.logActual+"TV provider is clicked", driver);
		
		//1.Optimum
			WebElement objOptinium = Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
			//wait.until(ExpectedConditions.visibilityOf(objOptinium));
			objOptinium.click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider Optimum should be clicked"+Extent_Reports.logActual+"Provider Optimum is clicked", driver);
			String ParentWindow = driver.getWindowHandle();
			Set<String> s1=driver.getWindowHandles();
			Iterator<String> nWindow= s1.iterator();
			while(nWindow.hasNext()){
				String childWindow = nWindow.next();
				driver.switchTo().window(childWindow);
			}
			
			WebElement objUserName = Utilities.returnElement(driver,lstObject.get(20),lstObject.get(19));			
			objUserName.sendKeys(lstTestData.get(25));	
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter User Name "+Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(25),driver);
			WebElement objPassword = Utilities.returnElement(driver,lstObject.get(23),lstObject.get(22));
			objPassword.sendKeys(lstTestData.get(24));			
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+Extent_Reports.logActual+"Password is entered as "+lstTestData.get(25),driver);			
			WebElement objSignIn = Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
			objSignIn.click();
			Thread.sleep(30000);
			driver.switchTo().window(ParentWindow); 
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Sign In button"+Extent_Reports.logActual+"Sign In button is clicked",driver);				    
			
			
			try{
			WebElement objlogo1 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));			
			objlogo1.click();
			WebElement objunlink1 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider logo should be clicked"+Extent_Reports.logActual+"Provider logo is clicked",driver);
			objunlink1.click();
			Thread.sleep(20000);			
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Unlink link should be clicked"+Extent_Reports.logActual+"Unlink link is clicked",driver);

			}catch(Exception exc)
			{

			   PGTVE obj = new PGTVE(driver);
			   obj.Childwindow();
			   driver.navigate().refresh();	
			   Thread.sleep(10000);
			   Extent_Reports.executionLog("INFO",Extent_Reports.logExpected+"Login is not sucessfull"+Extent_Reports.logActual+"Login is not sucessfull",driver);
			}
		
			//2.objxfinity 
			WebElement objTVProvider1 = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));			
			objTVProvider1.click();
			Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"TV Provider Bridge screen is displayed and TV Provider link should be clicked"+Extent_Reports.logActual+" Link Provider link is clicked");
			WebElement objxfinity = Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));			
			objxfinity.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider xfinity should be clicked"+Extent_Reports.logActual+"TV provider xfinity is clicked", driver);
			String ParentWindow1 = driver.getWindowHandle();
			Set<String> s2=driver.getWindowHandles();
			Iterator<String> nWindow1= s2.iterator();
			while(nWindow1.hasNext()){
				String childWindow1 = nWindow1.next();
				driver.switchTo().window(childWindow1);
			}
			
			WebElement objUserName1 = Utilities.returnElement(driver,lstObject.get(74),lstObject.get(73));			
			objUserName1.sendKeys(lstTestData.get(23));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter User Name "+Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(2),driver);
			
			WebElement objPassword1 = Utilities.returnElement(driver,lstObject.get(77),lstObject.get(76));
			objPassword1.sendKeys(lstTestData.get(22));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+Extent_Reports.logActual+"Password is entered as "+lstTestData.get(2),driver);
			
			WebElement objSignIn1 = Utilities.returnElement(driver,lstObject.get(80),lstObject.get(79));
			objSignIn1.click();
			Thread.sleep(20000);
			driver.switchTo().window(ParentWindow1); 
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Sign In button"+Extent_Reports.logActual+"Sign In button is clicked",driver);
			  
			try{
			WebElement objlogo2 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));			
			objlogo2.click();
			Thread.sleep(2000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider logo should be clicked"+Extent_Reports.logActual+"Provider logo is clicked",driver);
			WebElement objunlink2 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));			
			objunlink2.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Unlink link should be clicked"+Extent_Reports.logActual+"Unlink link is clicked",driver);			
			driver.navigate().refresh();
			}catch(Exception exc)
			{

			   PGTVE obj = new PGTVE(driver);
			   obj.Childwindow();
			   driver.navigate().refresh();	
			   Thread.sleep(20000);
			   Extent_Reports.executionLog("INFO",Extent_Reports.logExpected+"Login is not sucessfull"+Extent_Reports.logActual+"Login is not sucessfull",driver);
			}
			
		//3.DirectTV
		WebElement objTVProvider2 = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));			
			objTVProvider2.click();	
			String strCurURL = driver.getCurrentUrl();
	        Thread.sleep(30000);
	        Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Bridge screen is displayed and TV Provider link should be clicked"+Extent_Reports.logActual+" Link Provider link is clicked",driver);
			WebElement objdtv = Utilities.returnElement(driver,lstObject.get(38),lstObject.get(37));			
			Actions act = new Actions(driver);
			act.moveToElement(objdtv).click().build().perform();

		//	objdtv.click();
			Thread.sleep(200000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Direct Tv should be clicked"+Extent_Reports.logActual+"TV provider Direct Tv is clicked", driver);	
			driver.switchTo().frame("mvpdframe");
			WebElement objUserName2 = Utilities.returnElement(driver,lstObject.get(83),lstObject.get(82));			
			objUserName2.sendKeys(lstTestData.get(21));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter User Name "+Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(2),driver);
			
			WebElement objPassword2 = Utilities.returnElement(driver,lstObject.get(86),lstObject.get(85));
			objPassword2.sendKeys(lstTestData.get(20));
			
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+Extent_Reports.logActual+"Password is entered as "+lstTestData.get(2),driver);
			
			WebElement objSignIn2 = Utilities.returnElement(driver,lstObject.get(89),lstObject.get(88));
			objSignIn2.click();
			Thread.sleep(20000);
			//driver.switchTo().window(ParentWindow1);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Sign In button"+Extent_Reports.logActual+"Sign In button is clicked",driver);
			try{
			WebElement objlogo4 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
			objlogo4.click();
			Thread.sleep(2000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider logo should be clicked"+Extent_Reports.logActual+"Provider logo is clicked",driver);
			WebElement objunlink4 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink4.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Unlink link should be clicked"+Extent_Reports.logActual+"Unlink link is clicked",driver);
			//driver.navigate().refresh();
			//Thread.sleep(20000);
			}catch(Exception exc)
			{
			   PGTVE obj = new PGTVE(driver);
			   obj.Childwindow();
				driver.navigate().back();
			   driver.navigate().refresh();	
			   Thread.sleep(20000);
			   
			   Extent_Reports.executionLog("INFO",Extent_Reports.logExpected+"Login is not sucessfull"+Extent_Reports.logActual+"Login is not sucessfull",driver);
			}
			
					
			
			
			//Verizon
			//driver.navigate().to(strCurURL);
			//Thread.sleep(10000);
			WebElement objTVProvider5 = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
			//wait.until(ExpectedConditions.visibilityOf(objTVProvider5.get(1)));
			objTVProvider5.click();
			//driver.navigate().refresh();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Bridge screen is displayed and TV Provider link should be clicked"+Extent_Reports.logActual+" Link Provider link is clicked",driver);
			
			WebElement objveri = Utilities.returnElement(driver,lstObject.get(47),lstObject.get(46));			
			objveri.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider verizon  should be clicked"+Extent_Reports.logActual+"TV provider verizon Tv is clicked", driver);

			String ParentWindow3 = driver.getWindowHandle();
			Set<String> s4=driver.getWindowHandles();
			Iterator<String> nWindow3= s4.iterator();
			while(nWindow3.hasNext()){
				String childWindow3 = nWindow3.next();
				driver.switchTo().window(childWindow3);
			}
			
			WebElement objUserName5 = Utilities.returnElement(driver,lstObject.get(110),lstObject.get(109));			
			objUserName5.sendKeys(lstTestData.get(16));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter User Name "+Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(16),driver);
		
			WebElement objPassword5 = Utilities.returnElement(driver,lstObject.get(113),lstObject.get(112));
			objPassword5.sendKeys(lstTestData.get(17));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+Extent_Reports.logActual+"Password is entered as "+lstTestData.get(17),driver);
		
			WebElement objSignIn5= Utilities.returnElement(driver,lstObject.get(116),lstObject.get(115));
			objSignIn5.click();
			driver.switchTo().window(ParentWindow3);

			Thread.sleep(50000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Sign In button"+Extent_Reports.logActual+"Sign In button is clicked",driver);
			try{
			WebElement objlogo6 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));			
			objlogo6.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider logo should be clicked"+Extent_Reports.logActual+"Provider logo is clicked",driver);
			WebElement objunlink6 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink6.click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Unlink link should be clicked"+Extent_Reports.logActual+"Unlink link is clicked",driver);
			}catch(Exception exc)
			{
			   PGTVE obj = new PGTVE(driver);
			   obj.Childwindow();
			   driver.navigate().refresh();	
			   Thread.sleep(40000);
			   Extent_Reports.executionLog("INFO",Extent_Reports.logExpected+"Login is not sucessfull"+Extent_Reports.logActual+"Login is not sucessfull",driver);
			}		
			//Charaterspectrum
			//driver.navigate().to(strCurURL);
			
		WebElement objTVProvider8 = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));			
			objTVProvider8.click();	
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Bridge screen is displayed and TV Provider link should be clicked"+Extent_Reports.logActual+" Link Provider link is clicked",driver);
			WebElement objchaspec = Utilities.returnElement(driver,lstObject.get(56),lstObject.get(55));			
			objchaspec.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider CharterSpectrum  should be clicked"+Extent_Reports.logActual+"TV provider CharterSpectrum Tv is clicked", driver);
	
			String ParentWindow6 = driver.getWindowHandle();
			Set<String> s7=driver.getWindowHandles();
			Iterator<String> nWindow6= s7.iterator();
			while(nWindow6.hasNext()){
				String childWindow6 = nWindow6.next();
				driver.switchTo().window(childWindow6);
			}
	 
			WebElement objUserName8 = Utilities.returnElement(driver,lstObject.get(137),lstObject.get(136));			
			objUserName8.sendKeys(lstTestData.get(13));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter User Name "+Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(2),driver);
		
			WebElement objPassword8 = Utilities.returnElement(driver,lstObject.get(140),lstObject.get(139));
			objPassword8.sendKeys(lstTestData.get(12));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+Extent_Reports.logActual+"Password is entered as "+lstTestData.get(2),driver);
		
			WebElement objSignIn8= Utilities.returnElement(driver,lstObject.get(143),lstObject.get(142));
			objSignIn8.click();
			driver.switchTo().window(ParentWindow6);

			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Sign In button"+Extent_Reports.logActual+"Sign In button is clicked",driver);
			try{
				
			
			WebElement objlogo9 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));			
			objlogo9.click();
			Thread.sleep(20000);
			Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Provider logo should be clicked"+Extent_Reports.logActual+"Provider logo is clicked");
			
			WebElement objunlink9 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink9.click();
			Thread.sleep(20000);
			Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Unlink link should be clicked"+Extent_Reports.logActual+"Unlink link is clicked");
			}
			catch(Exception exc)
			{
			   PGTVE obj = new PGTVE(driver);
			   obj.Childwindow();
			   driver.navigate().refresh();	
			   Thread.sleep(20000);
			   Extent_Reports.executionLog("INFO",Extent_Reports.logExpected+"Login is not sucessfull"+Extent_Reports.logActual+"Login is not sucessfull",driver);
			}	
			
			
			
			//Mediacon
			
		WebElement objTVProvider11 = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
			//wait.until(ExpectedConditions.visibilityOf(objTVProvider11.get(1)));
			objTVProvider11.click();	
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Bridge screen is displayed and TV Provider link should be clicked"+Extent_Reports.logActual+" Link Provider link is clicked",driver);
			WebElement objmedcon = Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64));
			//wait.until(ExpectedConditions.visibilityOf(objmedcon));
			objmedcon.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Mediacon Tv should be clicked"+Extent_Reports.logActual+"TV provider Mediacon Tv is clicked", driver);

			String ParentWindow9 = driver.getWindowHandle();
			Set<String> s10=driver.getWindowHandles();
			Iterator<String> nWindow9= s10.iterator();
			while(nWindow9.hasNext()){
				String childWindow9 = nWindow9.next();
				driver.switchTo().window(childWindow9);
			}

			WebElement objUserName11 = Utilities.returnElement(driver,lstObject.get(164),lstObject.get(163));			
			objUserName11.sendKeys(lstTestData.get(7));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter User Name "+Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(2),driver);
			
			WebElement objPassword11 = Utilities.returnElement(driver,lstObject.get(167),lstObject.get(166));
			objPassword11.sendKeys(lstTestData.get(6));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+Extent_Reports.logActual+"Password is entered as "+lstTestData.get(2),driver);
			
			WebElement objSignIn11= Utilities.returnElement(driver,lstObject.get(170),lstObject.get(169));
			objSignIn11.click();
			driver.switchTo().window(ParentWindow9);
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Sign In button"+Extent_Reports.logActual+"Sign In button is clicked",driver);
			
			//driver.switchTo().window(ParentWindow9);			
			try{			
			WebElement objlogo13 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
			//wait.until(ExpectedConditions.visibilityOf(objlogo13));
			objlogo13.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider logo should be clicked"+Extent_Reports.logActual+"Provider logo is clicked",driver);
			WebElement objunlink13 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink13.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Unlink link should be clicked"+Extent_Reports.logActual+"Unlink link is clicked",driver);
			}
			catch(Exception exc)
			{
			   PGTVE obj = new PGTVE(driver);
			   obj.Childwindow();
			   driver.navigate().refresh();	
			   Thread.sleep(20000);
			   Extent_Reports.executionLog("INFO",Extent_Reports.logExpected+"Login is not sucessfull"+Extent_Reports.logActual+"Login is not sucessfull",driver);
			}
			
		//	//Wow
			
			WebElement objTVProvider12 = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
			//wait.until(ExpectedConditions.visibilityOf(objTVProvider12.get(1)));
			objTVProvider12.click();	
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Bridge screen is displayed and TV Provider link should be clicked"+Extent_Reports.logActual+" Link Provider link is clicked",driver);
			WebElement objwow = Utilities.returnElement(driver,lstObject.get(68),lstObject.get(67));
			//wait.until(ExpectedConditions.visibilityOf(objwow));
			objwow.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider wow Tv should be clicked"+Extent_Reports.logActual+"TV provider wow Tv is clicked", driver);

			String ParentWindow11 = driver.getWindowHandle();
			Set<String> s12=driver.getWindowHandles();
			Iterator<String> nWindow11= s12.iterator();
			while(nWindow11.hasNext()){
				String childWindow11 = nWindow11.next();
				driver.switchTo().window(childWindow11);
			}
			
			WebElement objwowclk = Utilities.returnElement(driver,lstObject.get(206),lstObject.get(205));			
			objwowclk.click();
			Thread.sleep(20000);
			
			WebElement objUserName13 = Utilities.returnElement(driver,lstObject.get(173),lstObject.get(172));			
			objUserName13.sendKeys(lstTestData.get(5));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter User Name "+Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(2),driver);
			
			WebElement objPassword13 = Utilities.returnElement(driver,lstObject.get(176),lstObject.get(175));
			objPassword13.sendKeys(lstTestData.get(4));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+Extent_Reports.logActual+"Password is entered as "+lstTestData.get(2),driver);
			
			WebElement objSignIn13= Utilities.returnElement(driver,lstObject.get(179),lstObject.get(178));
			objSignIn13.click();
			driver.switchTo().window(ParentWindow11);			
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Sign In button"+Extent_Reports.logActual+"Sign In button is clicked",driver);
			try{

			WebElement objlogo14 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
			//wait.until(ExpectedConditions.visibilityOf(objlogo14));
			objlogo14.click();
			Thread.sleep(10000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider logo should be clicked"+Extent_Reports.logActual+"Provider logo is clicked",driver);
			
			WebElement objunlink14 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink14.click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Unlink link should be clicked"+Extent_Reports.logActual+"Unlink link is clicked",driver);
			}
			catch(Exception exc)
			{
			   PGTVE obj = new PGTVE(driver);
			   obj.Childwindow();
			   driver.navigate().refresh();	
			   Thread.sleep(20000);
			   Extent_Reports.executionLog("INFO",Extent_Reports.logExpected+"Login is not sucessfull"+Extent_Reports.logActual+"Login is not sucessfull",driver);
			}
			
			//RCN
			driver.navigate().refresh();
			Thread.sleep(10000);
			//driver.navigate().to(strCurURL);
			Thread.sleep(10000);
			WebElement objTVProvider14 = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));			
			objTVProvider14.click();	
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Bridge screen is displayed and TV Provider link should be clicked"+Extent_Reports.logActual+" Link Provider link is clicked",driver);
			
			WebElement objrcn = Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
			//wait.until(ExpectedConditions.visibilityOf(objrcn));
			objrcn.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider RCN Tv should be clicked"+Extent_Reports.logActual+"TV provider RCN Tv is clicked",driver);

			//Synchronization.waitForPageLoad(driver);
			driver.switchTo().frame("mvpdframe");
			WebElement objUserName14 = Utilities.returnElement(driver,lstObject.get(182),lstObject.get(181));			
			//Synchronization.explicitWait(driver,objUserName14,"visible");
			objUserName14.sendKeys(lstTestData.get(2));
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter User Name "+Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(2),driver);
			WebElement objPassword14 = Utilities.returnElement(driver,lstObject.get(185),lstObject.get(184));
			objPassword14.sendKeys(lstTestData.get(3));
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+Extent_Reports.logActual+"Password is entered as "+lstTestData.get(3),driver);
			WebElement objSignIn14 = Utilities.returnElement(driver,lstObject.get(188),lstObject.get(187));
			objSignIn14.click();

			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Sign In button"+Extent_Reports.logActual+"Sign In button is clicked",driver);
			
						
			return null;
		  }
			
	
	
//==========================================================================================================
@Test
public  PGTVE Livepagetve() throws Exception 
	  {
	 //Launching the URL
   	{
   	 driver.get(lstTestData.get(0));
   	 driver.navigate().refresh();
   	 Thread.sleep(20000);
   	
   	WebElement objLivenav =Utilities.returnElement(driver,lstObject.get(215),lstObject.get(214));
   	objLivenav.click();
  	 Thread.sleep(10000);

    WebDriverWait wait= new WebDriverWait(driver,60);
 //  	wait.until(ExpectedConditions.urlContains("https://www.nbc.com/live"));
   WebElement objOptinium = Utilities.returnElement(driver,lstObject.get(17),lstObject.get(16));
	//wait.until(ExpectedConditions.visibilityOf(objOptinium));
	objOptinium.click();
	Thread.sleep(10000);
	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider Optimum should be clicked"+Extent_Reports.logActual+"Provider Optimum is clicked", driver);
	String ParentWindow = driver.getWindowHandle();
	Set<String> s1=driver.getWindowHandles();
	Iterator<String> nWindow= s1.iterator();
	while(nWindow.hasNext()){
		String childWindow = nWindow.next();
		driver.switchTo().window(childWindow);
	}
	
	WebElement objUserName = Utilities.returnElement(driver,lstObject.get(20),lstObject.get(19));			
	objUserName.sendKeys(lstTestData.get(25));	
	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter User Name "+Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(25),driver);
	WebElement objPassword = Utilities.returnElement(driver,lstObject.get(23),lstObject.get(22));
	objPassword.sendKeys(lstTestData.get(24));			
	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+Extent_Reports.logActual+"Password is entered as "+lstTestData.get(25),driver);			
	WebElement objSignIn = Utilities.returnElement(driver,lstObject.get(26),lstObject.get(25));
	objSignIn.click();
	Thread.sleep(30000);
	driver.switchTo().window(ParentWindow); 
	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Sign In button"+Extent_Reports.logActual+"Sign In button is clicked",driver);				    
	
	
	try{
	WebElement objlogo1 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));			
	objlogo1.click();
	WebElement objunlink1 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider logo should be clicked"+Extent_Reports.logActual+"Provider logo is clicked",driver);
	objunlink1.click();
	Thread.sleep(20000);			
	Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Unlink link should be clicked"+Extent_Reports.logActual+"Unlink link is clicked",driver);
	driver.navigate().refresh();

	}catch(Exception exc)
	{

	   PGTVE obj = new PGTVE(driver);
	   obj.Childwindow();
	   driver.navigate().refresh();	
	   Thread.sleep(10000);
	   Extent_Reports.executionLog("INFO",Extent_Reports.logExpected+"Login is not sucessfull"+Extent_Reports.logActual+"Login is not sucessfull",driver);
	}
		
	//2.objxfinity 
WebElement objxfinity = Utilities.returnElement(driver,lstObject.get(35),lstObject.get(34));			
			objxfinity.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider xfinity should be clicked"+Extent_Reports.logActual+"TV provider xfinity is clicked", driver);
			String ParentWindow1 = driver.getWindowHandle();
			Set<String> s2=driver.getWindowHandles();
			Iterator<String> nWindow1= s2.iterator();
			while(nWindow1.hasNext()){
				String childWindow1 = nWindow1.next();
				driver.switchTo().window(childWindow1);
			}
			
			WebElement objUserName1 = Utilities.returnElement(driver,lstObject.get(74),lstObject.get(73));			
			objUserName1.sendKeys(lstTestData.get(23));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter User Name "+Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(2),driver);
			
			WebElement objPassword1 = Utilities.returnElement(driver,lstObject.get(77),lstObject.get(76));
			objPassword1.sendKeys(lstTestData.get(22));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+Extent_Reports.logActual+"Password is entered as "+lstTestData.get(2),driver);
			
			WebElement objSignIn1 = Utilities.returnElement(driver,lstObject.get(80),lstObject.get(79));
			objSignIn1.click();
			Thread.sleep(20000);
			driver.switchTo().window(ParentWindow1); 
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Sign In button"+Extent_Reports.logActual+"Sign In button is clicked",driver);
			  
			try{
			WebElement objlogo2 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));			
			objlogo2.click();
			Thread.sleep(2000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider logo should be clicked"+Extent_Reports.logActual+"Provider logo is clicked",driver);
			WebElement objunlink2 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));			
			objunlink2.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Unlink link should be clicked"+Extent_Reports.logActual+"Unlink link is clicked",driver);			
			driver.navigate().refresh();
			}catch(Exception exc)
			{

			   PGTVE obj = new PGTVE(driver);
			   obj.Childwindow();
			   driver.navigate().refresh();	
			   Thread.sleep(20000);
			   Extent_Reports.executionLog("INFO",Extent_Reports.logExpected+"Login is not sucessfull"+Extent_Reports.logActual+"Login is not sucessfull",driver);
			}
			
		//3.DirectTV
	
			String strCurURL = driver.getCurrentUrl();
	        Thread.sleep(30000);
	        Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Bridge screen is displayed and TV Provider link should be clicked"+Extent_Reports.logActual+" Link Provider link is clicked",driver);
			WebElement objdtv = Utilities.returnElement(driver,lstObject.get(38),lstObject.get(37));			
			Actions act = new Actions(driver);
			act.moveToElement(objdtv).click().build().perform();

		//	objdtv.click();
			Thread.sleep(200000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Direct Tv should be clicked"+Extent_Reports.logActual+"TV provider Direct Tv is clicked", driver);	
			driver.switchTo().frame("mvpdframe");
			WebElement objUserName2 = Utilities.returnElement(driver,lstObject.get(83),lstObject.get(82));			
			objUserName2.sendKeys(lstTestData.get(21));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter User Name "+Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(2),driver);
			
			WebElement objPassword2 = Utilities.returnElement(driver,lstObject.get(86),lstObject.get(85));
			objPassword2.sendKeys(lstTestData.get(20));
			
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+Extent_Reports.logActual+"Password is entered as "+lstTestData.get(2),driver);
			
			WebElement objSignIn2 = Utilities.returnElement(driver,lstObject.get(89),lstObject.get(88));
			objSignIn2.click();
			Thread.sleep(20000);
			//driver.switchTo().window(ParentWindow1);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Sign In button"+Extent_Reports.logActual+"Sign In button is clicked",driver);
			try{
			WebElement objlogo4 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
			objlogo4.click();
			Thread.sleep(2000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider logo should be clicked"+Extent_Reports.logActual+"Provider logo is clicked",driver);
			WebElement objunlink4 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink4.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Unlink link should be clicked"+Extent_Reports.logActual+"Unlink link is clicked",driver);
			//driver.navigate().refresh();
			//Thread.sleep(20000);
			}catch(Exception exc)
			{
			   PGTVE obj = new PGTVE(driver);
			   obj.Childwindow();
				driver.navigate().back();
			   driver.navigate().refresh();	
			   Thread.sleep(20000);
			   
			   Extent_Reports.executionLog("INFO",Extent_Reports.logExpected+"Login is not sucessfull"+Extent_Reports.logActual+"Login is not sucessfull",driver);
			}
			
					
			
			
			//Verizon
			//driver.navigate().to(strCurURL);
			//Thread.sleep(10000);
		
		driver.navigate().refresh();
			Thread.sleep(30000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Bridge screen is displayed and TV Provider link should be clicked"+Extent_Reports.logActual+" Link Provider link is clicked",driver);
			
			WebElement objveri = Utilities.returnElement(driver,lstObject.get(47),lstObject.get(46));			
			objveri.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider verizon  should be clicked"+Extent_Reports.logActual+"TV provider verizon Tv is clicked", driver);

			String ParentWindow3 = driver.getWindowHandle();
			Set<String> s4=driver.getWindowHandles();
			Iterator<String> nWindow3= s4.iterator();
			while(nWindow3.hasNext()){
				String childWindow3 = nWindow3.next();
				driver.switchTo().window(childWindow3);
			}
			
			WebElement objUserName5 = Utilities.returnElement(driver,lstObject.get(110),lstObject.get(109));			
			objUserName5.sendKeys(lstTestData.get(16));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter User Name "+Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(16),driver);
		
			WebElement objPassword5 = Utilities.returnElement(driver,lstObject.get(113),lstObject.get(112));
			objPassword5.sendKeys(lstTestData.get(17));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+Extent_Reports.logActual+"Password is entered as "+lstTestData.get(17),driver);
		
			WebElement objSignIn5= Utilities.returnElement(driver,lstObject.get(116),lstObject.get(115));
			objSignIn5.click();
			Thread.sleep(50000);
			driver.switchTo().window(ParentWindow3);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Sign In button"+Extent_Reports.logActual+"Sign In button is clicked",driver);
			try{
			WebElement objlogo6 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));			
			objlogo6.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider logo should be clicked"+Extent_Reports.logActual+"Provider logo is clicked",driver);
			WebElement objunlink6 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink6.click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Unlink link should be clicked"+Extent_Reports.logActual+"Unlink link is clicked",driver);
			}catch(Exception exc)
			{
			   PGTVE obj = new PGTVE(driver);
			   obj.Childwindow();
			   driver.navigate().refresh();	
			   Thread.sleep(40000);
			   Extent_Reports.executionLog("INFO",Extent_Reports.logExpected+"Login is not sucessfull"+Extent_Reports.logActual+"Login is not sucessfull",driver);
			}	
			//Charaterspectrum
			//driver.navigate().to(strCurURL);
			
	//	WebElement objTVProvider8 = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));			
	//		objTVProvider8.click();	
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Bridge screen is displayed and TV Provider link should be clicked"+Extent_Reports.logActual+" Link Provider link is clicked",driver);
			WebElement objchaspec = Utilities.returnElement(driver,lstObject.get(56),lstObject.get(55));			
			objchaspec.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider CharterSpectrum  should be clicked"+Extent_Reports.logActual+"TV provider CharterSpectrum Tv is clicked", driver);
	
			String ParentWindow6 = driver.getWindowHandle();
			Set<String> s7=driver.getWindowHandles();
			Iterator<String> nWindow6= s7.iterator();
			while(nWindow6.hasNext()){
				String childWindow6 = nWindow6.next();
				driver.switchTo().window(childWindow6);
			}
	 
			WebElement objUserName8 = Utilities.returnElement(driver,lstObject.get(137),lstObject.get(136));			
			objUserName8.sendKeys(lstTestData.get(13));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter User Name "+Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(2),driver);
		
			WebElement objPassword8 = Utilities.returnElement(driver,lstObject.get(140),lstObject.get(139));
			objPassword8.sendKeys(lstTestData.get(12));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+Extent_Reports.logActual+"Password is entered as "+lstTestData.get(2),driver);
		
			WebElement objSignIn8= Utilities.returnElement(driver,lstObject.get(143),lstObject.get(142));
			objSignIn8.click();
			driver.switchTo().window(ParentWindow6);
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Sign In button"+Extent_Reports.logActual+"Sign In button is clicked",driver);
		//	driver.switchTo().window(ParentWindow6);
			try{
				
			
			WebElement objlogo9 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));			
			objlogo9.click();
			Thread.sleep(20000);
			Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Provider logo should be clicked"+Extent_Reports.logActual+"Provider logo is clicked");
			
			WebElement objunlink9 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink9.click();
			Thread.sleep(20000);
			Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Unlink link should be clicked"+Extent_Reports.logActual+"Unlink link is clicked");
			}
			catch(Exception exc)
			{
			   PGTVE obj = new PGTVE(driver);
			   obj.Childwindow();
			   driver.navigate().refresh();	
			   Thread.sleep(20000);
			   Extent_Reports.executionLog("INFO",Extent_Reports.logExpected+"Login is not sucessfull"+Extent_Reports.logActual+"Login is not sucessfull",driver);
			}	
			
			
			
	
			WebElement objmedcon = Utilities.returnElement(driver,lstObject.get(65),lstObject.get(64));
			//wait.until(ExpectedConditions.visibilityOf(objmedcon));
			objmedcon.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Mediacon Tv should be clicked"+Extent_Reports.logActual+"TV provider Mediacon Tv is clicked", driver);

			String ParentWindow9 = driver.getWindowHandle();
			Set<String> s10=driver.getWindowHandles();
			Iterator<String> nWindow9= s10.iterator();
			while(nWindow9.hasNext()){
				String childWindow9 = nWindow9.next();
				driver.switchTo().window(childWindow9);
			}

			WebElement objUserName11 = Utilities.returnElement(driver,lstObject.get(164),lstObject.get(163));			
			objUserName11.sendKeys(lstTestData.get(7));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter User Name "+Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(2),driver);
			
			WebElement objPassword11 = Utilities.returnElement(driver,lstObject.get(167),lstObject.get(166));
			objPassword11.sendKeys(lstTestData.get(6));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+Extent_Reports.logActual+"Password is entered as "+lstTestData.get(2),driver);
			
			WebElement objSignIn11= Utilities.returnElement(driver,lstObject.get(170),lstObject.get(169));
			objSignIn11.click();
			driver.switchTo().window(ParentWindow9);			

			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Sign In button"+Extent_Reports.logActual+"Sign In button is clicked",driver);
			
			try{			
			WebElement objlogo13 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
			//wait.until(ExpectedConditions.visibilityOf(objlogo13));
			objlogo13.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider logo should be clicked"+Extent_Reports.logActual+"Provider logo is clicked",driver);
			WebElement objunlink13 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink13.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Unlink link should be clicked"+Extent_Reports.logActual+"Unlink link is clicked",driver);
			}
			catch(Exception exc)
			{
			   PGTVE obj = new PGTVE(driver);
			   obj.Childwindow();
			   driver.navigate().refresh();	
			   Thread.sleep(20000);
			   Extent_Reports.executionLog("INFO",Extent_Reports.logExpected+"Login is not sucessfull"+Extent_Reports.logActual+"Login is not sucessfull",driver);
			}
			
		//	//Wow
			
		//	WebElement objTVProvider12 = Utilities.returnElement(driver,lstObject.get(14),lstObject.get(13));
			//wait.until(ExpectedConditions.visibilityOf(objTVProvider12.get(1)));
		//	objTVProvider12.click();	
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Bridge screen is displayed and TV Provider link should be clicked"+Extent_Reports.logActual+" Link Provider link is clicked",driver);
			WebElement objwow = Utilities.returnElement(driver,lstObject.get(68),lstObject.get(67));
			//wait.until(ExpectedConditions.visibilityOf(objwow));
			objwow.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider wow Tv should be clicked"+Extent_Reports.logActual+"TV provider wow Tv is clicked", driver);

			String ParentWindow11 = driver.getWindowHandle();
			Set<String> s12=driver.getWindowHandles();
			Iterator<String> nWindow11= s12.iterator();
			while(nWindow11.hasNext()){
				String childWindow11 = nWindow11.next();
				driver.switchTo().window(childWindow11);
			}
			
			WebElement objwowclk = Utilities.returnElement(driver,lstObject.get(206),lstObject.get(205));			
			objwowclk.click();
			Thread.sleep(20000);
			
			WebElement objUserName13 = Utilities.returnElement(driver,lstObject.get(173),lstObject.get(172));			
			objUserName13.sendKeys(lstTestData.get(5));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter User Name "+Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(2),driver);
			
			WebElement objPassword13 = Utilities.returnElement(driver,lstObject.get(176),lstObject.get(175));
			objPassword13.sendKeys(lstTestData.get(4));
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+Extent_Reports.logActual+"Password is entered as "+lstTestData.get(2),driver);
			
			WebElement objSignIn13= Utilities.returnElement(driver,lstObject.get(179),lstObject.get(178));
			objSignIn13.click();
			driver.switchTo().window(ParentWindow11);

			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Sign In button"+Extent_Reports.logActual+"Sign In button is clicked",driver);
			try{

			WebElement objlogo14 = Utilities.returnElement(driver,lstObject.get(29),lstObject.get(28));
			//wait.until(ExpectedConditions.visibilityOf(objlogo14));
			objlogo14.click();
			Thread.sleep(10000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Provider logo should be clicked"+Extent_Reports.logActual+"Provider logo is clicked",driver);
			
			WebElement objunlink14 = Utilities.returnElement(driver,lstObject.get(32),lstObject.get(31));
			objunlink14.click();
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Unlink link should be clicked"+Extent_Reports.logActual+"Unlink link is clicked",driver);
			}
			catch(Exception exc)
			{
			   PGTVE obj = new PGTVE(driver);
			   obj.Childwindow();
			   driver.navigate().refresh();	
			   Thread.sleep(20000);
			   Extent_Reports.executionLog("INFO",Extent_Reports.logExpected+"Login is not sucessfull"+Extent_Reports.logActual+"Login is not sucessfull",driver);
			}
			
			//RCN
			driver.navigate().refresh();
			//driver.navigate().to(strCurURL);
			
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider Bridge screen is displayed and TV Provider link should be clicked"+Extent_Reports.logActual+" Link Provider link is clicked",driver);
			
			WebElement objrcn = Utilities.returnElement(driver,lstObject.get(71),lstObject.get(70));
			//wait.until(ExpectedConditions.visibilityOf(objrcn));
			objrcn.click();
			Thread.sleep(30000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"TV Provider RCN Tv should be clicked"+Extent_Reports.logActual+"TV provider RCN Tv is clicked",driver);

			//Synchronization.waitForPageLoad(driver);
			driver.switchTo().frame("mvpdframe");
			WebElement objUserName14 = Utilities.returnElement(driver,lstObject.get(182),lstObject.get(181));			
			//Synchronization.explicitWait(driver,objUserName14,"visible");
			objUserName14.sendKeys(lstTestData.get(2));
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"User Name should be entered"+Extent_Reports.logActual+"User Name is entered");
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter User Name "+Extent_Reports.logActual+"User Name is entered as "+lstTestData.get(2),driver);
			WebElement objPassword14 = Utilities.returnElement(driver,lstObject.get(185),lstObject.get(184));
			objPassword14.sendKeys(lstTestData.get(3));
			//Extent_Reports.logger.log(LogStatus.PASS,Extent_Reports.logExpected+"Password should be entered"+Extent_Reports.logActual+"Password is entered");
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Enter Password"+Extent_Reports.logActual+"Password is entered as "+lstTestData.get(3),driver);
			WebElement objSignIn14 = Utilities.returnElement(driver,lstObject.get(188),lstObject.get(187));
			objSignIn14.click();
			Thread.sleep(20000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected+"Click on Sign In button"+Extent_Reports.logActual+"Sign In button is clicked",driver);
			
						
			return null;
		  }
	  }	
public PGTVE Childwindow()
{
	//String ParentWindow = driver.getWindowHandle();
//Set<String> sas1=driver.getWindowHandles();
//Iterator<String> nWindows= sas1.iterator();
//while(nWindows.hasNext()){
	//String childWindow = nWindows.next();
	//driver.switchTo().window(childWindow);
	//driver.close();

//}
//driver.switchTo().window(ParentWindow); 
	String originalHandle = driver.getWindowHandle();
	for(String handle : driver.getWindowHandles()) {
        if (!handle.equals(originalHandle)) {
            driver.switchTo().window(handle);
            driver.close();
        }
    }

    driver.switchTo().window(originalHandle);
return null;
}


}