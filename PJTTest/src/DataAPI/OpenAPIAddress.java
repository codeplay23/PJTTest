/*package DataAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.model2.mvc.service.domain.Festival;

public class OpenAPIAddress {

	public static void main(String[] args) throws Exception {

		String url = "http://api.data.go.kr/openapi/cltur-fstvl-std";
		url += "?serviceKey=hOlSrH9rpwUcpck4Zl2Wnewju3LzLtgYgAqtW%2FVCRaCJ4BMFUxYFO%2FkzQYu7hbohWd4Z8PWeG9gWgteLzsZqVQ%3D%3D";
		url += "&type=json";
		url += "&s_page=1";
		url += "&s_list=3";

		URL url1 = new URL(url);
		URLConnection urlConnection = url1.openConnection();
		HttpURLConnection connection = null;
		if (urlConnection instanceof HttpURLConnection) {
			connection = (HttpURLConnection) urlConnection;
		} else {
			System.out.println("error");
			return;
		}
		// ==> InputStream 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();

		JSONArray jsonarray = (JSONArray) JSONValue.parse(serverData);

		for (int i = 0; i < jsonarray.size(); i++) {
			JSONObject jsonobj = (JSONObject) jsonarray.get(i);

			Festival festival = new Festival();

			festival.setLatitude(jsonobj.get("위도"));
			festival.setContents(jsonobj.get("축제내용"));
			festival.setDetailRegion(jsonobj.get("주관기관"));
			festival.setDorojuso(jsonobj.get("소재지도로명주소"));
			festival.setEndDate(jsonobj.get("축제종료일자"));
			festival.setFestivalName(jsonobj.get("축제명"));
			festival.setJibunjuso(jsonobj.get("소재지지번주소"));
			festival.setLocation(jsonobj.get("개최장소"));
			festival.setLongitude(jsonobj.get("경도"));
			festival.setPhone(jsonobj.get("연락처"));
			festival.setRegion(jsonobj.get("주최기관"));
			festival.setRelations(jsonobj.get("관련정보"));
			festival.setSponser(jsonobj.get("후원기관"));
			festival.setStartDate(jsonobj.get("축제시작일자"));
			festival.setWebSite(jsonobj.get("홈페이지주소"));

			if (jsonobj.get("위도") == null || jsonobj.get("경도") == null) {

				String text = URLEncoder.encode(jsonobj.get("소재지도로명주소").toString(), "UTF-8");

				System.out.println("소재지..................." + jsonobj.get("소재지도로명주소").toString());

				String daumOpenAPIURL = "https://dapi.kakao.com/v2/local/search/address?query=" + text
						+ "&page=1&size=1";

				URL url2 = new URL(daumOpenAPIURL);
				HttpURLConnection con = (HttpURLConnection) url2.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("Authorization", "KakaoAK a6419e542017d8fd315556f745f29fcf");

				int responseCode = con.getResponseCode();

				BufferedReader br2 = null;

				if (responseCode == 200) {
					br2 = new BufferedReader(new InputStreamReader(con.getInputStream()));
				} else { // ???? ???
					br2 = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}

				String jsonData = br2.readLine();

				JSONObject jsonobj2 = (JSONObject) JSONValue.parse(jsonData);

				JSONArray jsonobj3 = (JSONArray) JSONValue.parse(jsonobj2.get("documents").toString());

				for (int j = 0; j < jsonobj3.size(); j++) {
					JSONObject jj = (JSONObject) jsonobj3.get(j);

					festival.setLatitude(jj.get("x"));
					festival.setLongitude(jj.get("y"));
				}

				festival.setContents(jsonobj.get("축제내용"));
				festival.setDetailRegion(jsonobj.get("주관기관"));
				festival.setDorojuso(jsonobj.get("소재지도로명주소"));
				festival.setEndDate(jsonobj.get("축제종료일자"));
				festival.setFestivalName(jsonobj.get("축제명"));
				festival.setJibunjuso(jsonobj.get("소재지지번주소"));
				festival.setLocation(jsonobj.get("개최장소"));
				festival.setPhone(jsonobj.get("연락처"));
				festival.setRegion(jsonobj.get("주최기관"));
				festival.setRelations(jsonobj.get("관련정보"));
				festival.setSponser(jsonobj.get("후원기관"));
				festival.setStartDate(jsonobj.get("축제시작일자"));
				festival.setWebSite(jsonobj.get("홈페이지주소"));

				br2.close();

				System.out.println("페스티발 객체다!!!!!!!!!!!!!" + festival);
			}

		}

	}

}
*/