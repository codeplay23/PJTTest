package DataAPI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class OpenAPI{
	
    public static void main(String[] args) throws IOException {
    	
    	//hOlSrH9rpwUcpck4Zl2Wnewju3LzLtgYgAqtW%2FVCRaCJ4BMFUxYFO%2FkzQYu7hbohWd4Z8PWeG9gWgteLzsZqVQ%3D%3D
    	
        StringBuilder urlBuilder = new StringBuilder("http://api.data.go.kr/openapi/cltur-fstvl-std"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("hOlSrH9rpwUcpck4Zl2Wnewju3LzLtgYgAqtW%2FVCRaCJ4BMFUxYFO%2FkzQYu7hbohWd4Z8PWeG9gWgteLzsZqVQ%3D%3D","UTF-8")); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("s_page","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("s_list","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 크기*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*XML/JSON 여부*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}