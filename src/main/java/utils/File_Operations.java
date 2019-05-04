package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class File_Operations{
	
	public static String strParentFolderName=null;
	public static String strChildFolderName=null;
	
	public static void CreateChildFolder(String strFolderPath, String ParentFolderName, String ChildFolderName)
	{
		/*File objFile = new File(strFolderPath+strFolderName);  //Specify the Folder name here
		objFile.mkdir();  //Creates the folder with the above specified name*/
		//File file = new File(ParentFolderName);
		strParentFolderName= strFolderPath+ParentFolderName;
		File file = new File(strParentFolderName);
		if (!file.exists()) {
			file.mkdirs();
			File subfile = new File(strParentFolderName+ChildFolderName);
			subfile.mkdirs();
			}
		else{
			   strChildFolderName = strParentFolderName+ChildFolderName;
				File subfile = new File(strParentFolderName+ChildFolderName);
				subfile.mkdirs();
			}

	}

	public static void CreateTextFile(String strFilePath) throws IOException
	{
		File objFile = new File(strFilePath);  //Specify the Folder name here
        //Create the file
        if (objFile.createNewFile()){
          System.out.println("File is created!");
        }else{
          System.out.println("File already exists.");
        }
         
        //Write Content
      //  FileWriter writer = new FileWriter(objFile);
        //writer.write("Test data");
        //writer.close();
	}
	public static void CreateTextFile(String strFilePath, String strFileName) throws IOException
	{
		File objFile = new File(strFilePath+strFileName);  //Specify the Folder name here
        //Create the file
        if (objFile.createNewFile()){
          System.out.println("File is created!");
        }else{
          System.out.println("File already exists.");
        }
	}

public static String GetCurrentDateAsPerGivenFormat(String strFileName)
	{
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strFileName);

	String strDate = simpleDateFormat.format(new Date());
	System.out.println(strDate);
	return strDate;
	
	}

}
