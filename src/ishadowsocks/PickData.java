package ishadowsocks;

import java.io.Closeable;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public abstract class PickData{

	public  static String pickData() {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			HttpGet httpGet = new HttpGet("http://www.ishadowsocks.org/");
			CloseableHttpResponse response = httpClient.execute(httpGet);
			System.out.println(response.getStatusLine());
			try {
				//获取响应实体
				HttpEntity entity = response.getEntity();
				if(entity!= null){
					return EntityUtils.toString(entity , "UTF-8").trim();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally {
			response.close();	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				httpClient.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return null;
	}
}