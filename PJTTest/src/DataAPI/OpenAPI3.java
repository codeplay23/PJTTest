/*package DataAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.model2.mvc.service.domain.Festival;

public class OpenAPI3 {

	public static void main(String[] args) throws Exception {
		
		String url = "http://api.data.go.kr/openapi/cltur-fstvl-std";
		url += "?serviceKey=hOlSrH9rpwUcpck4Zl2Wnewju3LzLtgYgAqtW%2FVCRaCJ4BMFUxYFO%2FkzQYu7hbohWd4Z8PWeG9gWgteLzsZqVQ%3D%3D";
		url += "&type=json";
		url += "&s_page=1";
		url += "&s_list=10";

		// HttpResponse : Http Protocol 응답 Message 추상화
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

			System.out.println("Domain........" + festival);

		}

	}

}
*/