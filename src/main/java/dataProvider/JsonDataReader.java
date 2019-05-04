package dataProvider;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import testDataTypes.Company;
import testDataTypes.Users;


 
public class JsonDataReader {
	static Object objData=null;
 public static Object getJsonData(String strFileName, String strClassName) throws IOException
 {
 if(objData == null)
 {
 Gson gson = new Gson();
 BufferedReader bufferReader = null;
 try {
 bufferReader = new BufferedReader(new FileReader(strFileName));
 /*switch(strClassName)
 {
 case "Company":
	 objData = (Company[]) gson.fromJson(bufferReader, Company[].class);
 break;
 case "Users":
	 objData = (Users[]) gson.fromJson(bufferReader, Users[].class);
 break;
  }*/
 if(strClassName.equals("Company"))
 {
	 objData = (Company[]) gson.fromJson(bufferReader, Company[].class);
 }
 if(strClassName.equals("Users"))
 {
	 objData = (Users[]) gson.fromJson(bufferReader, Users[].class);
 }
 }catch(FileNotFoundException e) {
 throw new RuntimeException("Json file not found at path : " + strFileName);
 }finally {
 try { if(bufferReader != null) bufferReader.close();}
 catch (IOException ignore) {}
 }
 }
 return (objData);
 }

}