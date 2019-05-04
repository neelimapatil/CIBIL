package utils;

import org.openqa.selenium.WebDriver;

public class Results extends Config {
WebDriver driver;
	
	public Results(WebDriver driver){
		 this.driver = driver;
	}
	
	public void setLogRep(String strOp,String strStatus, String strMethodName,String strMessage)
	{
		System.out.println("test");
	Config.logger.info(Config.strOp);
//	Screenshot.CaptureScreenshot(Config.strScreenShotFolderPath, "doUserLoginByRole",this.driver);
	}


}
