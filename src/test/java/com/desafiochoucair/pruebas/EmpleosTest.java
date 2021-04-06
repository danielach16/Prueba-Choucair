package com.desafiochoucair.pruebas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class EmpleosTest {
	
	private WebDriver driver;
	Empleos ddLpage;

	@Before
	public void setUp() throws Exception {		
		ddLpage = new Empleos(driver);
		driver = ddLpage.chromeDriverConnection();
		driver.manage().window().maximize(); 
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);	
	}

	@Test
	public void test() throws InterruptedException {		
		ddLpage.visit("https://www.choucairtesting.com");	
		ddLpage.Búsqueda();
		Thread.sleep(2000);
		ddLpage.AplicarEmpleo();
		Thread.sleep(4000);
		driver.quit();		
	}

}
