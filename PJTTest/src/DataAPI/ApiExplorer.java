package DataAPI;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=hOlSrH9rpwUcpck4Zl2Wnewju3LzLtgYgAqtW%2FVCRaCJ4BMFUxYFO%2FkzQYu7hbohWd4Z8PWeG9gWgteLzsZqVQ%3D%3D&_type=json"); /*Service Key*/
        urlBuilder.append("&"+ URLEncoder.encode("contentTypeId","UTF-8") + "=15" );
        urlBuilder.append("&"+ URLEncoder.encode("areadCode","UTF-8") + "=" );
        urlBuilder.append("&"+ URLEncoder.encode("sigunguCode","UTF-8") + "=" );
        urlBuilder.append("&"+ URLEncoder.encode("cat1","UTF-8") + "=" );
        urlBuilder.append("&"+ URLEncoder.encode("cat2","UTF-8") + "=" );
        urlBuilder.append("&"+ URLEncoder.encode("cat3","UTF-8") + "=" );
        urlBuilder.append("&"+ URLEncoder.encode("listYN","UTF-8") + "=Y" );
        urlBuilder.append("&"+ URLEncoder.encode("MobileOS","UTF-8") + "=ETC" );
        urlBuilder.append("&"+ URLEncoder.encode("MobileApp","UTF-8") + "=TourAPI3.0_Guide" );
        urlBuilder.append("&"+ URLEncoder.encode("arrange","UTF-8") + "=A" );
        urlBuilder.append("&"+ URLEncoder.encode("numOfRows","UTF-8") + "=12" );
        urlBuilder.append("&"+ URLEncoder.encode("pageNo","UTF-8") + "=1" );
        
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

