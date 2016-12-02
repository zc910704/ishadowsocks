package ishadowsocks;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONException;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test {

	public static void main(String[] args) throws JSONException, IOException {
		
//		System.out.println(PickData.pickData());  //测试是否正确获取网页
		String s = PickData.pickData();
		Elements result ;
		 Document document =Jsoup.parse(s);
//		 System.out.println(document);
//		 result=document.getElementsByTag("h4");	//利用h4标签找到元素
//		 System.out.println(result.get(1).toString());
		 result = document.getElementsByClass("col-sm-4 text-center");
		 try {
			DataIo.clearData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		 for(int i=0;i<3;i++){ 
		 int i =0;
		 System.out.println("**************get-informations*************");
		 String server;
		 String port;
		 String password;
		 String method;
		 String status;
		 String name;
		 System.out.println((char)('A'+i)+"服务器");
		 server = result.get(i).child(0).ownText().toString().substring(7);
		 port=result.get(i).child(1).ownText().toString().substring(3);
		 password=result.get(i).child(2).ownText().toString().substring(4);
		 method=result.get(i).child(3).ownText().toString().substring(5);
		 status=result.get(i).child(4).child(0).ownText().toString();
		 name=(char)('A'+i)+"";
		 // start test
		 System.out.println(server);
		 System.out.println(port);
		 System.out.println(password);
		 System.out.println(method);
		 System.out.println(status);
		 System.out.println("**************current-End*************");
		 DataIo.doDataIo(server, port, password, method, name);
		 
//		 }
		 Runtime.getRuntime().exec("./Shadowsocks.exe");
	}

}
