package ishadowsocks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class DataIo {
	public static void writeFile(JSONObject jsonObject)throws IOException{
		    
		        FileWriter fw = new FileWriter("./gui-config.json");  
		        PrintWriter writer = new PrintWriter(fw);  
		        writer.write( jsonObject.toString());  
		        writer.println();  
		        fw.close();  
		        writer.close(); 
	}
	public static void clearData() throws JSONException, IOException{
		JSONObject jsonObject = new JSONObject(new JSONTokener(new FileReader(new File("./gui-config.json"))));
		jsonObject.remove("configs");
		DataIo.writeFile(jsonObject);
		
	}
	
	public static void doDataIo (String server,String port,String password,String method,String name) throws JSONException, IOException   {
		/*
		org.json ¿â·½·¨
		*/
		
		JSONObject jsonObject = new JSONObject(new JSONTokener(new FileReader(new File("./gui-config.json"))));
		JSONArray jsonArray = new JSONArray(jsonObject.get("configs"));
		System.out.println(jsonArray.get(0));
		//test node
		System.out.println(jsonObject.toString());
		ArrayList<HashMap<String, String>> arrayList= new ArrayList<HashMap<String, String>>();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("server", server);
		hashMap.put("server_port", port);
		hashMap.put("password", password);
		hashMap.put("method", method);
		hashMap.put("remarks",name );
		arrayList.add(hashMap);
		//test node
		//System.out.println(arrayList.toString());
		jsonObject.put("configs", arrayList);
		System.out.println(jsonObject.toString());
		DataIo.writeFile(jsonObject);
//	 
	}
	public static void main(String[] args)  throws JSONException, FileNotFoundException {
		JSONObject jsonObject = new JSONObject(new JSONTokener(new FileReader(new File("./gui-config.json"))));
		System.out.println(jsonObject.get("configs").toString());
		JSONArray jsonArray = (JSONArray)(jsonObject.get("configs"));
		System.out.println(((JSONObject) jsonArray.get(0)).put("server", "www.baidu.com"));
		System.out.println((JSONObject) jsonArray.get(0));
//		System.out.println(jsonArray.toString());
		
	}
}
