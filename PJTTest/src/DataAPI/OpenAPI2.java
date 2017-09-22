package DataAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class OpenAPI2 {

	public static void main(String[] args) throws Exception {
		
		System.out.println(1);
		
		String strUrl = "http://api.data.go.kr/openapi/cltur-fstvl-std";
		strUrl += "?serviceKey=hOlSrH9rpwUcpck4Zl2Wnewju3LzLtgYgAqtW%2FVCRaCJ4BMFUxYFO%2FkzQYu7hbohWd4Z8PWeG9gWgteLzsZqVQ%3D%3D";
		strUrl += "&type=json";
		strUrl += "&s_page=1";
		strUrl += "&s_list=10";
		URL url = new URL(strUrl);
		URLConnection urlConnection = url.openConnection();
		HttpURLConnection connection = null;
		if (urlConnection instanceof HttpURLConnection) {
			connection = (HttpURLConnection) urlConnection;
		} else {
			System.out.println("error");
			return;
		}
		
		System.out.println(2);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String urlString = "";
		String current;
		
		System.out.println(3);
			while ((current = in.readLine()) != null) {
		urlString += current + "\n";
		}
		System.out.println(urlString);
		


	}
}
