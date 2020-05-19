package appium_Package;

import org.testng.annotations.Test;

//import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

//import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

//import org.junit.AfterClass;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
/*import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;*/
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestngSamsung {
	//AppiumDriver<MobileElement> driver = null;
	public static URL url;
	public static DesiredCapabilities caps;
	public static AndroidDriver<MobileElement> driver;
	
	 @BeforeTest
	  public void setupAppium() throws MalformedURLException {
			//final String URL_STRING = "http://192.168.1.167:4723/wd/hub";
			final String URL_STRING = "http://0.0.0.0:4723/wd/hub";
			url = new URL(URL_STRING);

			//Set the Desired Capabilities
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", "Galaxy Tab A (2016)");
			//caps.setCapability("udid", "3300553fd857b59f"); //Give Device ID of your mobile phone
			caps.setCapability("deviceId", "192.168.1.172:5555");
			caps.setCapability("platformName", "Android");
			
			caps.setCapability("platformVersion", "8.1.0");
			caps.setCapability("automationName", "UiAutomator2");
			caps.setCapability("appPackage", "com.obertys.fadel.customercorner");
			caps.setCapability("appActivity", "com.obertys.fadel.customercorner.Vues.OuvertureCompte.Activities.SplashScreenActivityUI");
			//caps.setCapability("appActivity", "com.obertys.fadel.customercorner.Vues.OuvertureCompte.Activities.LoginActivityUI");
			caps.setCapability("noReset", "true");


			//Instantiate Appium Driver
			driver = new AndroidDriver<MobileElement>(url, caps);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			//driver.resetApp();


			//Added 5 seconds wait so that the app loads completely before starting with element identification
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Driver is Launched");
			//Find  element UserName using ID property and click on it
			driver.findElement(By.id("com.obertys.fadel.customercorner:id/login_field")).click();				
			//Find UserName input element using ID property and clear it
			driver.findElement(By.id("com.obertys.fadel.customercorner:id/login_field")).clear();				
			//UserName input element and set value agentterrain02
			driver.findElement(By.id("com.obertys.fadel.customercorner:id/login_field")).sendKeys("agentterrain02");
			System.out.println("Page de connexion ");

			System.out.println("Login : agentterrain02");
			// Find Password input using Id property and click on it
			driver.findElement(By.id("com.obertys.fadel.customercorner:id/password_field")).click();				
			// Clear PassWord Input
			driver.findElement(By.id("com.obertys.fadel.customercorner:id/password_field")).clear();

			// Send PassWord
			driver.findElement(By.id("com.obertys.fadel.customercorner:id/password_field")).sendKeys("Test@123");
			System.out.println("Mot de passe : Test@123");
			((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			// Find Element Button using ID property and click on it
			if(driver.findElement(By.id("com.obertys.fadel.customercorner:id/btn_connexion")).isDisplayed()) {
				System.out.println("Button de connexion affiché successfully");
			}
			driver.findElement(By.id("com.obertys.fadel.customercorner:id/btn_connexion")).click();
			System.out.println("Click sur le bouton de connexion");

		}

	 
	@Test(invocationCount = 10)
	public void CreateAccount() throws InterruptedException {
		// Page Home				

		// Find Element Image using ID property and see if it's visible			
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("");
		System.out.println("*********************************************");
		System.out.println("***************** Début des Tests ****************");
		System.out.println("*********************************************");
		MobileElement BtnOpenAccount = (MobileElement) driver.findElement(By.id("com.obertys.fadel.customercorner:id/cardView"));
						
		// Click sur Item "Ouverture de Compte"
		BtnOpenAccount.click();

		MobileElement epargneCard = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout"));
		epargneCard.click();
		System.out.println("Création de Compte : 'Compte Serenity Agri'");

		System.out.println("*********************************************");
		
		Thread.sleep(1500);
		// Click Pièce d'identité RECTO *
		/*
		 * List<MobileElement> Cni =
		 * driver.findElementsByClassName("android.widget.Button"); System.out.
		 * println("*** Liste des faces à utiliser pour la Carte d'Identité National ***"
		 * ); for (MobileElement faceCNI : Cni) { System.out.println("==> : " +
		 * faceCNI.getText()); }
		 * 
		 * Cni.get(0).click();
		 * 
		 * MobileElement CniItems = driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout"
		 * );
		 * 
		 * 
		 * if(CniItems.isDisplayed()) { //System.out.println("Sélection du face : " +
		 * Cni.get(0).getText()); //Cni.get(0).click(); MobileElement
		 * btnGalerieScanRecto = driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"
		 * )); btnGalerieScanRecto.click();
		 * System.out.println("Click sur le Bouton Galerie et scan");
		 * 
		 * Thread.sleep(2000);
		 * 
		 * @SuppressWarnings("rawtypes") TouchAction FolderPhotoRecto = new
		 * TouchAction(driver); FolderPhotoRecto.tap(PointOption.point(490,
		 * 350)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).perform();
		 * System.out.println("Selection du photo recto");
		 * 
		 * System.out.println("Crop du Photo");
		 * 
		 * @SuppressWarnings("rawtypes") TouchAction CropCorner = new
		 * TouchAction(driver); CropCorner.press(PointOption.point(1181,
		 * 162)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(
		 * PointOption.point(983, 767)).release().perform();
		 * System.out.println("Crop côté droit RECTO");
		 * 
		 * Thread.sleep(2000); CropCorner.press(PointOption.point(10,
		 * 1750)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(
		 * PointOption.point(146, 1297)).release().perform();
		 * System.out.println("Crop côté gauche RECTO");
		 * 
		 * 
		 * MobileElement terminer =
		 * driver.findElement(By.id("com.sec.android.gallery3d:id/save"));
		 * terminer.click(); System.out.println("Enregistrement du photo"); // photo
		 * validé Thread.sleep(2000); MobileElement okOCR =
		 * driver.findElement(By.id("com.obertys.fadel.customercorner:id/confirm_button"
		 * )); okOCR.click(); System.out.println("Validation du OCR");
		 * Thread.sleep(1000);
		 * 
		 * @SuppressWarnings("rawtypes") TouchAction BottomToTop = new
		 * TouchAction(driver); // click sur le bouton Galerie et Scan
		 * BottomToTop.press(PointOption.point(350,
		 * 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(
		 * PointOption.point(350, 580)).release().perform();
		 * System.out.println("==> Swipe Vertical : défilement vers photo verso");
		 * 
		 * Thread.sleep(1500); MobileElement BtnScanGallery =
		 * driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.Button"
		 * ));
		 * 
		 * BtnScanGallery.click();
		 * 
		 * // select button Scan et gallery MobileElement Scan =
		 * driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"
		 * ); Scan.click();
		 * System.out.println("Choix du photo verso : Galerie et Scan");
		 * 
		 * Thread.sleep(2000);
		 * 
		 * @SuppressWarnings("rawtypes") TouchAction FolderPhotoVerso = new
		 * TouchAction(driver); FolderPhotoVerso.tap(PointOption.point(250,
		 * 350)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).perform();
		 * System.out.println("Click sur le photo verso");
		 * 
		 * CropCorner.press(PointOption.point(1181,
		 * 162)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(
		 * PointOption.point(1024, 866)).release().perform();
		 * System.out.println("Crop côté droit verso");
		 * 
		 * Thread.sleep(2000); CropCorner.press(PointOption.point(17,
		 * 1752)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(
		 * PointOption.point(205, 1376)).release().perform();
		 * System.out.println("Crop côté gauche verso");
		 * 
		 * 
		 * MobileElement terminer2 =
		 * driver.findElement(By.id("com.sec.android.gallery3d:id/save"));
		 * terminer2.click(); Thread.sleep(2000); MobileElement okOCR2 =
		 * driver.findElement(By.id("com.obertys.fadel.customercorner:id/confirm_button"
		 * )); okOCR2.click(); System.out.println("Enregistrement de la photo Verso");
		 * 
		 * Thread.sleep(2000);
		 * 
		 * @SuppressWarnings("rawtypes") TouchAction Bottom = new TouchAction(driver);
		 * // click sur le bouton Galerie et Scan Bottom.press(PointOption.point(350,
		 * 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(
		 * PointOption.point(350, 400)).release().perform();
		 * 
		 * Bottom.press(PointOption.point(350,
		 * 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(
		 * PointOption.point(350, 400)).release().perform();
		 * Bottom.press(PointOption.point(350,
		 * 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(
		 * PointOption.point(350, 400)).release().perform();
		 * 
		 * Bottom.press(PointOption.point(350,
		 * 600)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(
		 * PointOption.point(350, 400)).release().perform();
		 * System.out.println("==> Swipe Vertical : Go to bottom");
		 */

			MobileElement btnSuivant = driver.findElement(By.id("com.obertys.fadel.customercorner:id/suivant"));
			btnSuivant.click();
			System.out.println("click sur le button Suivant");

			@SuppressWarnings("rawtypes")
			TouchAction Bottom = new TouchAction(driver);

			/********************** Inscrition done ***********************/
			/**************************************************************/
			List<MobileElement> relativeLayout = driver.findElements(By.className("android.widget.RelativeLayout"));
			System.out.println("*********************************************");
			System.out.println("***** Affichage des Sections Disponible *****");
			for(MobileElement section : relativeLayout) {
				MobileElement sectionBtn = section.findElement(By.className("android.widget.Button"));
				System.out.println("Section : " + sectionBtn.getText());
			}

			// Première Section
			relativeLayout.get(0).click();
			
			MobileElement lastName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText"));
			lastName.clear();
			lastName.sendKeys("Diop");
			
			MobileElement FirstName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.EditText"));
			FirstName.clear();
			FirstName.sendKeys("Amadou");
			

			
			// Prénom et Nom du jeune fille de la mère
			MobileElement firstNameLastNameMother = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.FrameLayout/android.widget.EditText"));
			firstNameLastNameMother.clear();
			firstNameLastNameMother.sendKeys("Aissatou Diop");
			System.out.println("Prénom et Nom de jeune fille de la mère");
			
			MobileElement dateNaissance = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[6]/android.widget.FrameLayout/android.widget.EditText"));
			dateNaissance.click();			
			MobileElement Year = driver.findElement(By.id("android:id/date_picker_header_year"));
			Year.click();
			Thread.sleep(2000);
			Bottom.press(PointOption.point(600, 825)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(600, 1080)).release().perform();
			Bottom.press(PointOption.point(600, 825)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(600, 1080)).release().perform();
			Bottom.press(PointOption.point(600, 825)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(600, 1080)).release().perform();
			Bottom.press(PointOption.point(600, 825)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(600, 1080)).release().perform();
			
			List<MobileElement> listYear = driver.findElements(By.className("android.widget.TextView"));
		    listYear.get(1).click();
		    MobileElement BtnOk = driver.findElement(By.id("android:id/button1"));
		    BtnOk.click();
			
			MobileElement ville = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.EditText"));
			ville.clear();
			ville.sendKeys("Douala");
			
			MobileElement lieuDeNaissance = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.FrameLayout/android.widget.EditText"));
			lieuDeNaissance.clear();
			lieuDeNaissance.sendKeys("Douala");
			System.out.println("Lieu de Naissance : " + lieuDeNaissance.getText());
			
			// Liste Pièce d'identité
			MobileElement cni = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Spinner[3]/android.widget.TextView"));
		    cni.click();
		    
		    List<MobileElement> listPieceCni = driver.findElements(By.className("android.widget.CheckedTextView"));
		    for(MobileElement typePieceCni : listPieceCni) {
		    	System.out.println("**** Type de pièce : " + typePieceCni.getText() + " ****");
		    }
		    
		    // click sur le CNI - NOUVELLE
		    Thread.sleep(2000);
		    listPieceCni.get(10).click();
		    System.out.println("Choix du type de pièce d'identité : ");
		    
		    Thread.sleep(1500);
			// Numéro pièce d'identité
			MobileElement numberCni = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[10]/android.widget.FrameLayout/android.widget.EditText"));
		    
		    int random1 = ThreadLocalRandom.current().nextInt(328635222, 828635222 + 1);
		    String randomCni = String.valueOf(random1);
		    		    
		    if(numberCni != null) {
		    	numberCni.clear();
		    	numberCni.sendKeys("109 " + randomCni);		    	
		    }
		    System.out.println("Numéro de la pièce d'identité : " + numberCni.getText());
		
			MobileElement lieuDelivrance = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[11]/android.widget.FrameLayout/android.widget.EditText"));
			lieuDelivrance.clear();
			lieuDelivrance.sendKeys("Douala");
			System.out.println("Lieu de Délivrance : " + lieuDelivrance.getText());

			//Délivrer le
			MobileElement dateDelivrance = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[12]/android.widget.FrameLayout/android.widget.EditText"));
			dateDelivrance.click();
			
			MobileElement YearDelivre = driver.findElement(By.id("android:id/date_picker_header_year"));
			YearDelivre.click();
			Thread.sleep(2000);
			Bottom.press(PointOption.point(600, 825)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(600, 1080)).release().perform();
			
			List<MobileElement> listYearDelivre = driver.findElements(By.className("android.widget.TextView"));
			listYearDelivre.get(1).click();
		    MobileElement BtnOkDelivre = driver.findElement(By.id("android:id/button1"));
		    BtnOkDelivre.click();
			
			// Expiration CNI
			//Délivrer le
			MobileElement expiration = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[13]/android.widget.FrameLayout/android.widget.EditText"));
			expiration.click();
			MobileElement YearExpire = driver.findElement(By.id("android:id/date_picker_header_year"));
			YearExpire.click();
			Thread.sleep(2000);
			Bottom.press(PointOption.point(600, 1080)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(600, 825)).release().perform();
			Bottom.press(PointOption.point(600, 1080)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(600, 825)).release().perform();
			
			List<MobileElement> listYearExpire = driver.findElements(By.className("android.widget.TextView"));
			listYearExpire.get(1).click();
		    MobileElement BtnOkExpire = driver.findElement(By.id("android:id/button1"));
		    BtnOkExpire.click();
			Thread.sleep(2000);
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			
			// Tél Mobile 1
		/*
		 * MobileElement callMobile = driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[15]/android.widget.FrameLayout/android.widget.EditText"
		 * )); callMobile.clear(); callMobile.sendKeys("334502030");
		 * 
		 * MobileElement el17 = (MobileElement) driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.EditText[1]"
		 * ); el17.sendKeys("ivoirienne");
		 * 
		 * MobileElement el4 = (MobileElement)
		 * driver.findElementById("com.obertys.fadel.customercorner:id/firstname");
		 * el4.sendKeys("Moussa"); MobileElement el5 = (MobileElement)
		 * driver.findElementById("com.obertys.fadel.customercorner:id/lastname");
		 * el5.sendKeys("Diop"); MobileElement el6 = (MobileElement)
		 * driver.findElementById("com.obertys.fadel.customercorner:id/sexe");
		 * el6.sendKeys("M"); MobileElement el7 = (MobileElement)
		 * driver.findElementById("com.obertys.fadel.customercorner:id/dateNaiss");
		 * el7.click(); el7.sendKeys("20/12/1991"); MobileElement el8 = (MobileElement)
		 * driver.findElementById("com.obertys.fadel.customercorner:id/lieuNaiss");
		 * el8.sendKeys("Douala"); MobileElement el9 = (MobileElement)
		 * driver.findElementById("com.obertys.fadel.customercorner:id/delivrance");
		 * el9.sendKeys("12/02/2018"); MobileElement el10 = (MobileElement)
		 * driver.findElementById("com.obertys.fadel.customercorner:id/expiration");
		 * el10.sendKeys("12/02/2028"); MobileElement el11 = (MobileElement)
		 * driver.findElementById("com.obertys.fadel.customercorner:id/adresse");
		 * el11.sendKeys("Douala"); MobileElement el12 = (MobileElement)
		 * driver.findElementById("com.obertys.fadel.customercorner:id/suivant");
		 * el12.click(); MobileElement el13 = (MobileElement) driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.Button"
		 * ); el13.click(); driver.navigate().back(); MobileElement el14 =
		 * (MobileElement)
		 * driver.findElementById("com.obertys.fadel.customercorner:id/suivant");
		 * el14.click(); MobileElement el15 = (MobileElement) driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.Button"
		 * ); el15.click();
		 */
			MobileElement num1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText");
			num1.sendKeys("774220139");
			
			MobileElement num2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText");
			num2.sendKeys("764220139");
			
			MobileElement nationalite = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.EditText[1]");
			nationalite.sendKeys("ivoirienne");
			
			MobileElement adresse = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.FrameLayout/android.widget.EditText"));
			adresse.sendKeys("Plateau villa N*72");
			System.out.println("Adresse : " + adresse.getText());
			
			MobileElement etude = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Spinner/android.widget.TextView"));
			etude.click();
			
			List<MobileElement> listEtude = driver.findElements(By.className("android.widget.CheckedTextView"));
		    for(MobileElement choixEtude : listEtude) {
		    	System.out.println("**** Niveau d'etude : " + choixEtude.getText());
		    }
		    listEtude.get(4).click();
			Thread.sleep(1500);
			MobileElement el19 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.EditText[3]");
			el19.sendKeys("BECIDA");
			MobileElement el20 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[8]");
			el20.click();
			MobileElement el21 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.EditText[4]");
			el21.sendKeys("Abedem");
			
			// Dépli Engagement
			MobileElement engagement = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.Button");
			engagement.click();
			
			//Contrats
			MobileElement adhesion = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.CheckBox[1]");
			adhesion.click();
			MobileElement accept1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]");
			accept1.click();
			
			MobileElement lettre = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.CheckBox[2]");
			lettre.click();
			MobileElement accept2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]");
			accept2.click();
			
			MobileElement formulaire = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.CheckBox[3]");
			formulaire.click();
			MobileElement accept3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]");
			accept3.click();
			
			// Condition générale
			MobileElement CG = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.Button");
			CG.click();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			
			// lire condition générale
			MobileElement readCG = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.CheckBox");
			readCG.click();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			
			
			MobileElement acceptContrat = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]");
			acceptContrat.click();
			MobileElement sign = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button");
			sign.click();
		/*
		 * MobileElement el33 = (MobileElement) driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"
		 * ); el33.click(); MobileElement el34 = (MobileElement)
		 * driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.View"
		 * ); el34.click(); MobileElement el35 = (MobileElement)
		 * driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"
		 * ); el35.click(); MobileElement el36 = (MobileElement)
		 * driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[1]"
		 * ); el36.click();
		 * 
		 * 
		 * MobileElement el37 = (MobileElement) driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.Button"
		 * ); el37.click(); MobileElement el38 = (MobileElement)
		 * driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button[1]"
		 * ); el38.click();
		 * 
		 * 
		 * MobileElement el39 = (MobileElement) driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button[2]"
		 * ); el39.click(); MobileElement el40 = (MobileElement)
		 * driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"
		 * ); el40.click();
		 * 
		 * 
		 * MobileElement el41 = (MobileElement) driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button"
		 * ); el41.click(); MobileElement el42 = (MobileElement)
		 * driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"
		 * ); el42.click();
		 * 
		 * 
		 * MobileElement el43 = (MobileElement) driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"
		 * ); el43.click(); MobileElement el44 = (MobileElement)
		 * driver.findElementById("android:id/button1"); el44.click(); MobileElement
		 * el45 = (MobileElement)
		 * driver.findElementByAccessibilityId("Revenir en haut de la page");
		 * el45.click();
		 */
			


			

		/*
		 * MobileElement cooperative = driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.EditText[2]"
		 * )); cooperative.clear(); cooperative.sendKeys("SECOM");
		 * 
		 * // cooperative.sendKeys(Keys.RETURN); // ((PressesKey) driver).pressKey(new
		 * KeyEvent(AndroidKey.BACK));
		 * 
		 * 
		 * Bottom.press(PointOption.point(350,
		 * 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(
		 * PointOption.point(350, 400)).release().perform();
		 * 
		 * // Dépli Engagement MobileElement engagements = (MobileElement)
		 * driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.Button"
		 * )); engagements.click();
		 * System.out.println("Click sur le bouton 'Engagement'");
		 * 
		 * 
		 * // Parcourir les checkBox List<MobileElement> engagementsCheckBox =
		 * driver.findElements(By.className("android.widget.CheckBox"));
		 * 
		 * 
		 * //String firstCheckBox = engagementsCheckBox.get(1).getAttribute("checked");
		 * if(engagementsCheckBox.get(0).isDisplayed()) {
		 * engagementsCheckBox.get(0).click(); }
		 * 
		 * Thread.sleep(2000); MobileElement accepter = driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]"
		 * )); System.out.println("Choix du Contrat : " + accepter.getText());
		 * accepter.click();
		 * 
		 * Thread.sleep(3000); engagementsCheckBox.get(1).click(); Thread.sleep(2000);
		 * MobileElement accepter2 = driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]"
		 * )); accepter2.click(); System.out.println("Choix du Contrat : " +
		 * accepter2.getText());
		 * 
		 * Thread.sleep(3000); Bottom.press(PointOption.point(350,
		 * 750)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(
		 * PointOption.point(350, 400)).release().perform();
		 * 
		 * if(engagementsCheckBox.get(2).isDisplayed()) {
		 * engagementsCheckBox.get(2).click(); } Thread.sleep(2000); MobileElement
		 * accepter3 = driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]"
		 * )); accepter3.click(); System.out.println("Choix du Contrat : " +
		 * accepter3.getText());
		 * 
		 * Bottom.press(PointOption.point(350,
		 * 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(
		 * PointOption.point(350, 400)).release().perform();
		 * 
		 * MobileElement conditionsGeneralesTab = driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.Button"
		 * )); conditionsGeneralesTab.click();
		 * 
		 * 
		 * MobileElement cg = driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.CheckBox"
		 * )); cg.click(); Thread.sleep(1000); // Accepter les conditions générales
		 * List<MobileElement> acceptCG =
		 * driver.findElements(By.className("android.widget.Button"));
		 * acceptCG.get(0).click();
		 * System.out.println("Accepter les Conditions Générales");
		 */
			
			// Cliquer sur le bouton Signature
		/*
		 * MobileElement btnSign = driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button"
		 * )); btnSign.click();
		 */
			
			// Signature Manuelle
			MobileElement signManuel = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
			signManuel.click();
			Thread.sleep(1000);
			try {
				// Signature dans le Canvas
				WebElement CanvaSign = driver.findElement(By.className("android.view.View"));

				Actions actionProvider = new Actions(driver);

				actionProvider.clickAndHold(CanvaSign).moveByOffset(20, 150).build().perform();
				actionProvider.clickAndHold(CanvaSign).moveByOffset(20, 300).build().perform();
				actionProvider.release();
				System.out.println("Signature du Contrat");
				// Valider la signature
				MobileElement signValidate = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[1]"));
				signValidate.click();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}

			// Performs release event

			Thread.sleep(1000);
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();

			MobileElement pieceJointe = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.Button"));
			pieceJointe.click();
			System.out.println("Click sur pièce Jointe");

			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			
			// OCR - ID RECTO
			MobileElement RECTO = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button[1]"));
			RECTO.click();
			Thread.sleep(1500);
			
			MobileElement Gallery = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
			Gallery.click();
			
			Thread.sleep(2000);
			@SuppressWarnings("rawtypes")
			TouchAction FolderPhotoRecto = new TouchAction(driver);
			FolderPhotoRecto.tap(PointOption.point(240, 350)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).perform();
			
			MobileElement trimSava3 = driver.findElement(By.id("com.sec.android.gallery3d:id/save"));
			trimSava3.click();
			System.out.println("Enregistrement de la photo Recto");
			Thread.sleep(2000);
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			
			
			
			// OCR - ID Verso
			MobileElement Verso = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button[1]"));
			Verso.click();
			
			MobileElement Gallery2 = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
			Gallery2.click();
			
			Thread.sleep(2000);
			@SuppressWarnings("rawtypes")
			TouchAction FolderPhotoVerso = new TouchAction(driver);
			FolderPhotoVerso.tap(PointOption.point(240, 350)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).perform();
			
			MobileElement trimSava4 = driver.findElement(By.id("com.sec.android.gallery3d:id/save"));
			trimSava4.click();
			System.out.println("Enregistrement de la photo Verso");
			
			Thread.sleep(2000);
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			
			
			
			
			
			// Photo
			MobileElement photo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button[1]"));
			photo.click();
			System.out.println("Click sur bouton photo");

			MobileElement Gallery3 = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
			Gallery3.click();
			
			Thread.sleep(2000);
			@SuppressWarnings("rawtypes")
			TouchAction Photo = new TouchAction(driver);
			Photo.tap(PointOption.point(240, 350)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).perform();
			
			MobileElement trimSava5 = driver.findElement(By.id("com.sec.android.gallery3d:id/save"));
			trimSava5.click();
			System.out.println("Enregistrement de la photo");
			
			Thread.sleep(2000);
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			
			
			Thread.sleep(1500);
			
			MobileElement saveAndSend = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
			saveAndSend.click();
			System.out.println("Inscription terminé");
			System.out.println("*********************************************");
			
			Thread.sleep(2000);
			
			try {
		    @SuppressWarnings("rawtypes")
			TouchAction popUp = new TouchAction(driver);
		    popUp.tap(PointOption.point(550, 580)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).perform();
			}catch(Exception e) {
				
			}
		    Thread.sleep(2000);
		    List<MobileElement> retour1 = driver.findElementsByClassName("android.widget.ImageButton");
			retour1.get(0).click();
			
		/*
		 * System.out.println("test 2"); MobileElement retour = (MobileElement) driver.
		 * findElementByAndroidUIAutomator("UiSelector().description(\"Revenir en haut de la page\")"
		 * ); retour.click();
		 */
			
			System.out.println("test 3");
		}
 
  @Test
	public void finBoucle() {
		System.out.println("Fin de la Boucle");
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		if (driver != null) {
			Thread.sleep(3000);
			//driver.quit();
		}
	}

}
