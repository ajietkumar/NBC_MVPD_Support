package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGTSJFGuestDetailPage;
import com.nbcd.Pages.PGTVE;

public class TCTVE_Authvod extends GetWebDriverInstance
{ 
	
	@Test(groups="TCTVE_Authvod")
	 
	 public void Authvod() throws Exception 
	 {

		PGTVE objHP = new PGTVE(driver);
		
		objHP.Authvod();
		
	 }
}