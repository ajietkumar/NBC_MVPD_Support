package com.nbcd.TestRunner;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.TestNG;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import com.nbcd.GenericLib.DatabaseFunction;

public class TestRunner
{
	public Hashtable<String, String> htTestRunner;
	public List<String> lstBrowser,lstExecutionType,lstBrowserVersion,lstOS,lstOSVersion;
	public int poolSize=0;
	public String browsers;
	@Test
	@Parameters("aut")
	public void tRun(String aut)
	{
		DatabaseFunction objDBF= new DatabaseFunction();
		try
    	{
			switch (aut.toUpperCase()) 
			{
				case "MOBILE":
						htTestRunner=objDBF.getHashTestData("Select * from TestSuite Where Execution ='Yes' AND ExecutionType='" +aut+"'","TestRunner");
						poolSize=2;
						System.out.println("MOBILE:"+htTestRunner.size());
						break;
				case "IPAD":
						htTestRunner=objDBF.getHashTestData("Select * from TestSuite Where Execution ='Yes' AND ExecutionType='" +aut+"'","TestRunner");
						poolSize=2;
						System.out.println("IPAD:"+htTestRunner.size());
						break;
				case "CHROME":
						lstExecutionType = objDBF.getTestDataObject("Select Distinct(ExecutionType) from TestSuite Where Execution ='Yes' and Browser='Chrome'","TestRunner");
						if(lstExecutionType.get(0).compareToIgnoreCase("Remote")== 0)
						{
							poolSize=2;
							htTestRunner=objDBF.getHashTestData("Select * from TestSuite Where Execution ='Yes' AND Browser='Chrome'","TestRunner");
							aut="Remote";
							System.out.println("Chrome:"+htTestRunner.size());
						}
						else
						{
							htTestRunner=objDBF.getHashTestData("Select * from TestSuite Where Execution ='Yes' AND ExecutionType='" +aut+"'","TestRunner");
							poolSize=1;
							System.out.println("Chrome:"+htTestRunner.size());
					
						}
						break;
				case "FIREFOX":
						lstExecutionType = objDBF.getTestDataObject("Select Distinct(ExecutionType) from TestSuite Where Execution ='Yes' and Browser='Firefox'","TestRunner");
						if(lstExecutionType.get(0).compareToIgnoreCase("Remote")== 0)
						{
							poolSize=2;
							htTestRunner=objDBF.getHashTestData("Select * from TestSuite Where Execution ='Yes' AND Browser='Chrome'","TestRunner");
							aut="Remote";
							System.out.println("FF:"+htTestRunner.size());
						}
						else
						{
							htTestRunner=objDBF.getHashTestData("Select * from TestSuite Where Execution ='Yes' AND Browser='Chrome'","TestRunner");
							poolSize=1;
							System.out.println("FF:"+htTestRunner.size());
						}
						break;
					default:
					     System.out.println("Please Specify the Environment to Execute");
			}
		
		
    	}
		catch(Exception exc)
		{
			System.out.println("Exception in TestRunner:"+ exc.getMessage());
		}
		
						
					TestNG myTestNG = new TestNG();  //Create an instance on TestNG
				/*	myTestNG.setParallel("tests");
					myTestNG.setSuiteThreadPoolSize(poolSize);
			*/		XmlSuite mySuite = new XmlSuite(); //Create an instance of XML Suite and assign a name for it.
					mySuite.setName("NBCAutomation");
					
					XmlTest myTest = new XmlTest(mySuite); //Create an instance of XmlTest and assign a name for it.
					myTest.setName("NBCAutomation");			
					List<XmlClass> myClasses = new ArrayList<XmlClass> ();
				 	Set set = htTestRunner.entrySet();
				    Iterator intIterator = set.iterator();
				    while (intIterator.hasNext()) 
				    {
				    	
					      Map.Entry entry = (Map.Entry) intIterator.next();
					   
					      myClasses.add(new XmlClass((String) entry.getKey()));
					      
					      	myTest.setXmlClasses(myClasses); //Assign that to the XmlTest Object created earlier.
					     	lstBrowserVersion = objDBF.getTestDataObject("Select Distinct(BrowserVersion) from TestSuite Where Execution ='Yes' and  ExecutionType='" +aut+"'","TestRunner");
							lstOS = objDBF.getTestDataObject("Select Distinct(OS) from TestSuite Where Execution ='Yes' and  ExecutionType='" +aut+"'","TestRunner");
							lstOSVersion = objDBF.getTestDataObject("Select Distinct(OSVersion) from TestSuite Where Execution ='Yes' and  ExecutionType='" +aut+"'","TestRunner");
							myTestNG.setParallel("tests");
							myTestNG.setSuiteThreadPoolSize(poolSize);
							mySuite.setParallel(XmlSuite.ParallelMode.CLASSES);
							mySuite.setThreadCount(poolSize);
					    /* myTest.addParameter("environment", (String) lstExecutionType.get(0))*/; //Execution Type
					     myTest.addParameter("environment", (String) aut);
					     myTest.addParameter("browser", (String) entry.getValue()); //Add any parameters that you want to set to the Test.
					     myTest.addParameter("version", (String)lstBrowserVersion.get(0)); //Add any parameters that you want to set to the Test.
					     myTest.addParameter("os", (String)lstOS.get(0)); //Add any parameters that you want to set to the Test.
					     myTest.addParameter("osversion", (String) lstOSVersion.get(0)); //Add any parameters that you want to set to the Test.
				
				    } 
				    List<XmlTest> myTests = new ArrayList<XmlTest>();//Create a list of XmlTests and add the Xmltest you created earlier to it.
					myTests.add(myTest);
					mySuite.setTests(myTests); //add the list of tests to your Suite.
					List<XmlSuite> mySuites = new ArrayList<XmlSuite>();//Add the suite to the list of suites.
					mySuites.add(mySuite);
					myTestNG.setXmlSuites(mySuites);

					System.out.println(mySuites);
					myTestNG.run(); //invoke run() - this will run your class.
		
			//}
		//For Parallel Execution
		
		}

}