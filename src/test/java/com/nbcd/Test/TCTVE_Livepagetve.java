package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGTVE;

public class TCTVE_Livepagetve extends GetWebDriverInstance
{ 
	
	@Test(groups="TCTVE_Livepagetve")
	 
	 public void Livepagetve() throws Exception 
	 {

		PGTVE objHP = new PGTVE(driver);
		
		objHP.Livepagetve();
		
	 }
}