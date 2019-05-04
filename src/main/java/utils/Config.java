package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.SimpleLayout;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Config {
	
	public static String strOp=null;
	public static Logger logger=Logger.getLogger(Config.class);
	public static WebDriverWait objWaitDriver = null;
	public static int intMaxTimeOut = 60;
	public static String strReadValue=null;
	public static Integer intVar=null;
	public static String strResultFolder=null;
	public static boolean isLogEnabled;
	public static  boolean isCaptureScreenShotEnabled;
	public static int intStepCounter=0;
	public static String IS_SCREEN_CAPTURE_ENABLED=null;
	public static String IS_LOG_ENABLED=null;
	public static boolean InitStarted = false;
	public static String strScreenShotFolderPath=null;
	public static String strReportFolderPath=null;
	public static String strScreenShotFileName=null;
	public static String testDataResourcePath=null;
	public static int intcnt=1;
	

	public static void SetLogPath() throws IOException
	{
		SimpleLayout layout = new SimpleLayout(); 
		RollingFileAppender appender = new RollingFileAppender(layout,"E:/log4j-application.log",true);
		logger.addAppender(appender);
		logger.setLevel((Level) Level.DEBUG);
	}
	
	public String GetParameterValue(String strParamterName) throws IOException
	{
		InputStream input=null;
		Properties objProp=new Properties();
		input=getClass().getClassLoader().getResourceAsStream("\\Properties\\Config.properties");
		objProp.load(input);
		String strParameterValue= objProp.getProperty(strParamterName);
		return strParameterValue;
	}

	public static void InitFlags() throws IOException {
		
		Config objConfig=new Config();
		strReadValue=objConfig.GetParameterValue("IS_SCREEN_CAPTURE_ENABLED");
		if(strReadValue.equalsIgnoreCase("Yes"))
		{
			isCaptureScreenShotEnabled = true;
		}
		
		if(strReadValue.equalsIgnoreCase("true"))
		{
			isCaptureScreenShotEnabled = true;
		}
		if(strReadValue.equalsIgnoreCase("No"))
		{
			isCaptureScreenShotEnabled = false;
		}
		if(strReadValue.equalsIgnoreCase("false"))
		{
			isCaptureScreenShotEnabled = false;
		}
		strReadValue=objConfig.GetParameterValue("IS_LOG_ENABLED");
		if(strReadValue.equalsIgnoreCase("Yes"))
		{
			isLogEnabled = true;
		}
		
		if(strReadValue.equalsIgnoreCase("true"))
		{
			isLogEnabled = true;
		}
		if(strReadValue.equalsIgnoreCase("No"))
		{
			isLogEnabled = false;
		}
		if(strReadValue.equalsIgnoreCase("false"))
		{
			isLogEnabled = false;
		}
		if(isLogEnabled==false)
			{
			//  Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
				 Logger.getRootLogger().setLevel(Level.OFF);
			}
		else
		{
			Logger.getRootLogger().setLevel(Level.ALL);
		}
		String workingDir = System.getProperty("user.dir");
		//System.out.println(workingDir);
		String strDateFormat=File_Operations.GetCurrentDateAsPerGivenFormat("yyyy-MM-dd_hh_mm_ss");
		
		File_Operations.CreateChildFolder(workingDir,"\\Result"+strDateFormat,"\\LOGS");
		//String strParentFolderName = File_Operations.strParentFolderName;
		
		File_Operations.CreateChildFolder(workingDir,"\\Result"+strDateFormat,"\\REPORT");
		strReportFolderPath = File_Operations.strChildFolderName+"\\Report_"+strDateFormat+".html";
//		Config.strReportFolderPath = "E:\\selenium\\Workspace\\workspace_maven\\EJCUCUMBER\\REPORTS\\report.html";
		File_Operations.CreateChildFolder(workingDir,"\\Result"+strDateFormat,"\\SCREENSHOTS");	
		strScreenShotFolderPath = File_Operations.strChildFolderName+"\\";
		//Config.strScreenShotFolderPath = "E:\\selenium\\Workspace\\workspace_maven\\EJCUCUMBER\\SCREENSHOTS\\";
	}
	}
