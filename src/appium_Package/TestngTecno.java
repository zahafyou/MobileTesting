package appium_Package;
import java.lang.System;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class TestngTecno {
	//AppiumDriver<MobileElement> driver = null;
	public static URL url;
	public static DesiredCapabilities caps;
	public static AndroidDriver<MobileElement> driver;

	@BeforeTest
	public void setupAppium() throws MalformedURLException {
		final String URL_STRING = "http://10.0.1.4:4723/wd/hub";
		//final String URL_STRING = "http://0.0.0.0:4723/wd/hub";
		url = new URL(URL_STRING);

		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Tecno J8");
		caps.setCapability("udid", "0153801730301908"); //Give Device ID of your mobile phone
		//caps.setCapability("deviceId", "192.168.1.111:5555");
		caps.setCapability("platformName", "Android");
		
		caps.setCapability("platformVersion", "5.1");
		//caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.obertys.fadel.customercorner");
		caps.setCapability("appActivity", "com.obertys.fadel.customercorner.Vues.OuvertureCompte.Activities.SplashScreenActivityUI");
		caps.setCapability("noReset", "true");


		//Instantiate Appium Driver
		driver = new AndroidDriver<MobileElement>(url, caps);
		driver.manage().timeouts().implicitlyWait(640, TimeUnit.SECONDS);
		//driver.resetApp();


		//Added 5 seconds wait so that the app loads completely before starting with element identification
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Driver is Launched");
		
		System.out.println("");
		System.out.println("*********************************************");
		System.out.println("***************** Connexion à l'application ****************");
		System.out.println("*********************************************");
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
	
	
	@Test(invocationCount = 10, skipFailedInvocations = true)
	//@Test()
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

		MobileElement epargneCard = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.view.View/android.support.v4.view.ViewPager/android.widget.FrameLayout[1]"));
		epargneCard.click();
		System.out.println("Création de Compte : 'Compte Serenity Agri'");

		System.out.println("*********************************************");
		
		Thread.sleep(1500);
		// Click Pièce d'identité RECTO *
		List<MobileElement> Cni = driver.findElementsByClassName("android.widget.Button");
		System.out.println("*** Liste des faces à utiliser pour la Carte d'Identité National ***");
		for (MobileElement faceCNI : Cni) {
			System.out.println("==> : " + faceCNI.getText());
		}

		Cni.get(0).click();

		MobileElement CniItems = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout");


		if(CniItems.isDisplayed()) {
			//System.out.println("Sélection du face : " + Cni.get(0).getText());
			//Cni.get(0).click();
			MobileElement btnGalerieScanRecto = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
			btnGalerieScanRecto.click();
			System.out.println("Click sur le Bouton Galerie et scan");

			Thread.sleep(2000);
			@SuppressWarnings("rawtypes")
			TouchAction FolderPhotoRecto = new TouchAction(driver);
			FolderPhotoRecto.tap(PointOption.point(120, 550)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).perform();
			System.out.println("Selection du photo recto");
			
			@SuppressWarnings("rawtypes")
			TouchAction SelectPhotoRecto = new TouchAction(driver);
			SelectPhotoRecto.tap(PointOption.point(120, 250)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).perform();
			System.out.println("Selection du photo");
			MobileElement trimSava = driver.findElement(By.id("com.android.gallery3d:id/trim_save"));
			trimSava.click();
			System.out.println("Enregistrement du photo");
			// choix de l'emplacement and Once or Always
			Thread.sleep(2000);
			MobileElement okOCR = driver.findElement(By.id("com.obertys.fadel.customercorner:id/confirm_button"));
			okOCR.click();
			System.out.println("Validation du OCR");
			Thread.sleep(1000);
			@SuppressWarnings("rawtypes")
			TouchAction BottomToTop = new TouchAction(driver);
			// click sur le bouton Galerie et Scan
			BottomToTop.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(350, 580)).release().perform();			
			System.out.println("==> Swipe Vertical : défilement vers photo verso");

			Thread.sleep(2000);
			MobileElement BtnScanGallery = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.Button"));

			BtnScanGallery.click();

			// select button Scan et gallery
			MobileElement Scan = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]");
			Scan.click();

			Thread.sleep(2000);
			@SuppressWarnings("rawtypes")
			TouchAction FolderPhotoVerso = new TouchAction(driver);
			FolderPhotoVerso.tap(PointOption.point(120, 550)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).perform();
			System.out.println("Click sur le dossier photo");
			@SuppressWarnings("rawtypes")
			TouchAction SelectPhotoVerso = new TouchAction(driver);
			SelectPhotoVerso.tap(PointOption.point(120, 250)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).perform();
			System.out.println("Selection photo grace à ses coordonnées (X-Y)");

			MobileElement trimSava2 = driver.findElement(By.id("com.android.gallery3d:id/trim_save"));
			trimSava2.click();
			Thread.sleep(2000);
			MobileElement okOCR2 = driver.findElement(By.id("com.obertys.fadel.customercorner:id/confirm_button"));
			okOCR2.click();
			System.out.println("Enregistrement de la photo Verso");

			Thread.sleep(2000);
			@SuppressWarnings("rawtypes")
			TouchAction Bottom = new TouchAction(driver);
			// click sur le bouton Galerie et Scan
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			
			Bottom.press(PointOption.point(350, 600)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			System.out.println("==> Swipe Vertical : Go to bottom");

			MobileElement btnSuivant = driver.findElement(By.id("com.obertys.fadel.customercorner:id/suivant"));
			btnSuivant.click();
			System.out.println("click sur le button Suivant");



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
			
			// Prénom et Nom du jeune fille de la mère
			MobileElement firstNameLastNameMother = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.FrameLayout/android.widget.EditText"));
			firstNameLastNameMother.clear();
			firstNameLastNameMother.sendKeys("Aissatou Diop");
			System.out.println("Prénom et Nom de jeune fille de la mère");
			
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
						
			MobileElement numberCni = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[6]/android.widget.FrameLayout/android.widget.EditText"));
			numberCni.clear();
			
		    int random1 = ThreadLocalRandom.current().nextInt(328635222, 828635222 + 1);
		    String randomCni = String.valueOf(random1);		    		    
		    
		    numberCni.sendKeys("109 " + randomCni);    
		    System.out.println("Numéro de la pièce d'identité : " + numberCni.getText());
			
		    //Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			
		    MobileElement lieuDelivrance = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.FrameLayout/android.widget.EditText")); 
		    lieuDelivrance.clear();
		    lieuDelivrance.sendKeys("Dakar");
		    System.out.println("Lieu de Délivrance : " + lieuDelivrance.getText());
		 
		    Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			 
			// Tél Fixe
			MobileElement callMobile = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[6]/android.widget.FrameLayout/android.widget.EditText"));
			callMobile.clear();
			
			int random2 = ThreadLocalRandom.current().nextInt(435222, 835666 + 1);
		    String randomCni2 = String.valueOf(random2);		    		    
		    
		    callMobile.sendKeys("77" + randomCni2);    
		    System.out.println("Numéro de la pièce d'identité : " + callMobile.getText());

			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();

			// Pays de Résidence
			/*
			 * MobileElement paysResidence = driver.findElement(By.xpath(
			 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Spinner[1]/android.widget.TextView"
			 * )); paysResidence.click(); // scroll List des pays MobileElement paysTest =
			 * (MobileElement) driver.findElement( MobileBy.AndroidUIAutomator(
			 * "new UiScrollable(new UiSelector()).scrollIntoView(" +
			 * "new UiSelector().text(\"Sénégal\"));"));
			 * System.out.println(paysTest.getLocation()); paysTest.click();
			 * System.out.println("Choix du Pays : " + paysTest.getText());
			 */

			// Niveau d'éducation
			/*
			 * MobileElement education = driver.findElement(By.xpath(
			 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Spinner[2]/android.widget.TextView"
			 * )); education.click(); // List<MobileElement> listEducation =
			 * driver.findElements(By.className("android.widget.CheckedTextView"));
			 * System.out.println("Affichage de la liste : Situation Familiale");
			 * for(MobileElement edu : listEducation) { System.out.println("==> : " +
			 * edu.getText()); }
			 */
//
			// Choix Université
			/*
			 * listEducation.get(3).click(); System.out.println("Choix : " +
			 * listEducation.get(3).getText());
			 */
			
			MobileElement cooperative = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.EditText[2]"));
			cooperative.clear();
			cooperative.sendKeys("SECOM");
			
			/*
			 * MobileElement cooperative = driver.findElement(By.xpath(
			 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Spinner[3]/android.widget.TextView"
			 * )); cooperative.click();
			 */

			/*
			 * List<MobileElement> listCooperative =
			 * driver.findElements(By.className("android.widget.CheckedTextView"));
			 * System.out.println("Affichage de la liste : Situation Familiale");
			 * for(MobileElement coop : listCooperative) { System.out.println("==> : " +
			 * coop.getText()); } listCooperative.get(1).click();
			 * System.out.println("Choix : " + listCooperative.get(1).getText());
			 */
			
			
			// Dépli Engagement				    
			List<MobileElement> engagements = driver.findElements(By.className("android.widget.Button"));
			engagements.get(0).click();
			System.out.println("Click sur le bouton 'Engagement'");

			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			

			// Parcourir les textes
			//List<MobileElement> engagementsTxt = driver.findElements(By.className("android.widget.TextView"));
			// Parcourir les checkBox
			List<MobileElement> engagementsCheckBox = driver.findElements(By.className("android.widget.CheckBox"));

			/*
			 * System.out.println("*** Les types de contrats disponible ***");
			 * for(MobileElement engagementtxt : engagementsTxt) {
			 * System.out.println("==> : " + engagementtxt.getText()); }
			 */			    

			//String firstCheckBox = engagementsCheckBox.get(1).getAttribute("checked");
			//System.out.println("Veuillez accepter le contrat *** ==> " + engagementsTxt.get(4).getText());
			if(engagementsCheckBox.get(0).isDisplayed()) {

				engagementsCheckBox.get(0).click();
			}

			Thread.sleep(3000);
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();

			Thread.sleep(2000);

			MobileElement accepter = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]"));

			System.out.println("Choix du Contrat : " + accepter.getText());
			accepter.click();

			Thread.sleep(3000);

			//System.out.println("Veuillez accepter le contrat *** ==> " + engagementsTxt.get(5).getText());
			engagementsCheckBox.get(1).click();
			Thread.sleep(3000);
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();			   		
			Thread.sleep(2000);				    
			MobileElement accepter2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]"));

		    //List<MobileElement> btnletter = driver.findElements(By.className("android.widget.Button"));
			accepter2.click();
			//letterContract.click();
			System.out.println("Choix du Contrat : " + accepter2.getText());


			Thread.sleep(5000);
			//System.out.println("Veuillez accepter le contrat *** ==> " + engagementsTxt.get(6).getText());
			engagementsCheckBox.get(2).click();

			Thread.sleep(3000);
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();			    
			Thread.sleep(1500);
			MobileElement accepter3 = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]"));
			accepter3.click();
			System.out.println("Choix du Contrat : " + accepter3.getText());				    

			//Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			MobileElement conditionsGeneralesTab = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.Button"));
			conditionsGeneralesTab.click();		
			Bottom.press(PointOption.point(350, 600)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();			    
			
			MobileElement cgCheck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.CheckBox"));
			cgCheck.click();
			
			/*
			 * MobileElement cg = driver.findElement(By.xpath(
			 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.CheckBox"
			 * )); cg.click();
			 */
			Thread.sleep(1000);
			// Accepter les conditions générales
			List<MobileElement> acceptCG = driver.findElements(By.className("android.widget.Button"));
			acceptCG.get(0).click();
			System.out.println("Accepter les Conditions Générales");
			
			// Cliquer sur le bouton Signature
			MobileElement btnSign = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button")); 
			btnSign.click();
			
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
				System.out.println("Choix de la signature : " + signValidate.getText());
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}

			// Performs release event

			Thread.sleep(1000);
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();

			MobileElement pieceJointe = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.Button"));
			pieceJointe.click();
			System.out.println("Click sur pièce Jointe");

			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();

			MobileElement photo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button"));
			photo.click();
			System.out.println("Click sur bouton photo");

//			Thread.sleep(2000);
			MobileElement btnGalery = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
			btnGalery.click();
			
			Thread.sleep(1500);
			@SuppressWarnings("rawtypes")
			TouchAction FolderPhoto = new TouchAction(driver);
			FolderPhoto.tap(PointOption.point(120, 550)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).perform();
			System.out.println("Click sur le dossier photo");
			@SuppressWarnings("rawtypes")
			TouchAction SelectPhoto = new TouchAction(driver);
			SelectPhoto.tap(PointOption.point(120, 250)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).perform();
			System.out.println("Selection du photo");

			MobileElement trimSava3 = driver.findElement(By.id("com.android.gallery3d:id/trim_save"));
			trimSava3.click();
			System.out.println("Enregistrement de la photo");

			Thread.sleep(1500);
			Bottom.press(PointOption.point(350, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
			//Bottom.press(PointOption.point(350, 800)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(350, 400)).release().perform();
		
			MobileElement saveAndSend = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
			saveAndSend.click();
			System.out.println("Inscription terminé");
			System.out.println("*********************************************");
					    
		    Thread.sleep(1000);
		    @SuppressWarnings("rawtypes")
			TouchAction endInscription = new TouchAction(driver);
		    endInscription.tap(PointOption.point(350, 410)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).perform();
			

//			((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.BACK));
//			
			Thread.sleep(1000);
			//android.widget.ImageButton[@content-desc="Revenir en haut de la page"]
			MobileElement retour = (MobileElement) driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Revenir en haut de la page\"]"));
			//MobileElement retour = (MobileElement) driver.findElementByAndroidUIAutomator("UiSelector().description(\"Revenir en haut de la page\")");
			
			retour.click();
		}
	}
	
	/*
	 * @Test public void finBoucle() { System.out.println("Fin de la Boucle"); }
	 */
	@AfterTest
	public void tearDown() throws InterruptedException {
		
		  if (driver != null)
		  	{ 
			  Thread.sleep(3000); driver.quit();
		  	}		 
	}
}
