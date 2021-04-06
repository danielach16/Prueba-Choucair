package com.desafiochoucair.pruebas;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Empleos {

private static WebDriver driver;
	
	public Empleos (WebDriver driver){
		this.driver=driver;
	}
	
	public static WebDriver chromeDriverConnection(){
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public WebElement findElement (By locator){
		return driver.findElement(locator);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
		
	}
	
	public void clic(WebElement element) {
		element.click();
	}
	
	public void visit(String url){
		driver.get(url);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public void Búsqueda() throws InterruptedException {
		driver.findElement(By.linkText("Empleos")).click();
		Thread.sleep(2000);
		String page =driver.findElement(By.cssSelector("h2[class='elementor-heading-title elementor-size-default']")).getText();
		System.out.println("Página: "+page);
		Thread.sleep(2000);
		driver.findElement(By.id("search_keywords")).sendKeys("Analista de Pruebas");
		driver.findElement(By.id("search_location")).sendKeys("Lima");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/2020/11/Recurso-7-150x150.png']")).click();
		Thread.sleep(2000);
		String empleo =driver.findElement(By.cssSelector("h1[class='title-post entry-title']")).getText();
		System.out.println("Empleo buscado: "+empleo);
	}
	
	public void AplicarEmpleo() throws InterruptedException {
		WebElement apply = driver.findElement(By.xpath("//input[@class='application_button button']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", apply);
		Thread.sleep(2000);
		driver.findElement(By.id("nombre-completo")).sendKeys("Alonso Rodriguez Sánchez");
		driver.findElement(By.id("correo-electronico")).sendKeys("alonso.rodriguez@gmail.com");
		driver.findElement(By.id("celular-o-telefono-de-contacto")).sendKeys("987654321");
		driver.findElement(By.id("que-estudios-formales-tienes-o-en-que-semestre-te-encuentras-actualmente")).sendKeys("Bachiller");
		driver.findElement(By.id("que-tiempo-de-experiencia-certificada-tienes-en-pruebas-o-en-desarrollo-de-softwaresi-aplica")).sendKeys("2 años");
		driver.findElement(By.id("conoces-de-automatizacion-de-pruebas-te-gustaria-aprendersi-aplica")).sendKeys("Sí, he automizado pruebas para aplicaciones web.");
		driver.findElement(By.id("cual-es-tu-aspiracion-salarial")).sendKeys("4000");
		driver.findElement(By.id("si-eres-seleccionado-que-disponibilidad-de-tiempo-para-ingresar-tendrias")).sendKeys("3 semanas");
		driver.findElement(By.id("mensaje-adicional")).sendKeys("Soy una persona proactiva y con capacidad rápida de aprender.");
		Thread.sleep(2000);	
		File file = new File("./src/test/resources/cv/cv.pdf");
		String path =file.getAbsolutePath();
		driver.findElement(By.id("cv")).sendKeys(path);
		Thread.sleep(2000);
		WebElement send = driver.findElement(By.xpath("//input[@class='button wp_job_manager_send_application_button']"));
		JavascriptExecutor jss = (JavascriptExecutor)driver;
		jss.executeScript("arguments[0].click()", send);		
		Thread.sleep(3000);
		String applyok =driver.findElement(By.cssSelector("p[class='job-manager-message']")).getText();
		System.out.println(applyok);	
	}

	
}
