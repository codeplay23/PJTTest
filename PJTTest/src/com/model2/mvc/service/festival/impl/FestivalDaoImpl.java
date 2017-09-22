package com.model2.mvc.service.festival.impl;

import java.beans.Encoder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Festival;
import com.model2.mvc.service.festival.FestivalDao;

@Repository("festivalDaoImpl")
public class FestivalDaoImpl implements FestivalDao {

	/// Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;

	private Festival festival;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	/// Constructor
	public FestivalDaoImpl() {
		System.out.println(this.getClass());
	}

	public void addFestival(Festival festival) throws Exception {
		sqlSession.insert("FestivalMapper.addFestival", festival);
	}

	@Override
	public void getFestival(Festival festival) {
		// TODO Auto-generated method stub
		sqlSession.select("FestivalMapper.getFestival", (ResultHandler) festival);

	}

	/*
	 * @Override public Festival getOpen() throws Exception {
	 * 
	 * String url = "http://api.data.go.kr/openapi/cltur-fstvl-std"; url +=
	 * "?serviceKey=hOlSrH9rpwUcpck4Zl2Wnewju3LzLtgYgAqtW%2FVCRaCJ4BMFUxYFO%2FkzQYu7hbohWd4Z8PWeG9gWgteLzsZqVQ%3D%3D";
	 * url += "&type=json"; url += "&s_page=1"; url += "&s_list=3";
	 * 
	 * URL url1 = new URL(url); URLConnection urlConnection =
	 * url1.openConnection(); HttpURLConnection connection = null; if
	 * (urlConnection instanceof HttpURLConnection) { connection =
	 * (HttpURLConnection) urlConnection; }
	 * 
	 * // ==> InputStream 생성ss BufferedReader br = new BufferedReader(new
	 * InputStreamReader(connection.getInputStream(),"UTF-8"));
	 * System.out.println("[ Server 에서 받은 Data 확인 ] "); String serverData =
	 * br.readLine();
	 * 
	 * JSONArray jsonarray = (JSONArray) JSONValue.parse(serverData);
	 * 
	 * for (int i = 0; i < jsonarray.size(); i++) { JSONObject jsonobj =
	 * (JSONObject) jsonarray.get(i);
	 * 
	 * Festival festival = new Festival();
	 * 
	 * festival.setLatitude(jsonobj.get("위도"));
	 * festival.setContents(jsonobj.get("축제내용"));
	 * festival.setDetailRegion(jsonobj.get("주관기관"));
	 * festival.setDorojuso(jsonobj.get("소재지도로명주소"));
	 * festival.setEndDate(jsonobj.get("축제종료일자"));
	 * festival.setFestivalName(jsonobj.get("축제명"));
	 * festival.setJibunjuso(jsonobj.get("소재지지번주소"));
	 * festival.setLocation(jsonobj.get("개최장소"));
	 * festival.setLongitude(jsonobj.get("경도"));
	 * festival.setPhone(jsonobj.get("연락처"));
	 * festival.setRegion(jsonobj.get("주최기관"));
	 * festival.setRelations(jsonobj.get("관련정보"));
	 * festival.setSponser(jsonobj.get("후원기관"));
	 * festival.setStartDate(jsonobj.get("축제시작일자"));
	 * festival.setWebSite(jsonobj.get("홈페이지주소"));
	 * 
	 * System.out.println("fe......" + festival);
	 * 
	 * if(jsonobj.get("위도")==null || jsonobj.get("경도")==null){
	 * 
	 * String text = null;
	 * 
	 * if(festival.getDorojuso()==null){ text =
	 * URLEncoder.encode(jsonobj.get("소재지지번주소").toString(), "UTF-8"); }else{
	 * text = URLEncoder.encode(jsonobj.get("소재지도로명주소").toString(), "UTF-8"); }
	 * 
	 * System.out.println("소재지..................." + text);
	 * 
	 * String daumOpenAPIURL =
	 * "https://dapi.kakao.com/v2/local/search/address?query="+text+
	 * "&page=1&size=1";
	 * 
	 * URL url2 = new URL(daumOpenAPIURL); HttpURLConnection con =
	 * (HttpURLConnection)url2.openConnection(); con.setRequestMethod("GET");
	 * con.setRequestProperty("Authorization",
	 * "KakaoAK a6419e542017d8fd315556f745f29fcf");
	 * 
	 * int responseCode = con.getResponseCode();
	 * 
	 * BufferedReader br2 = null;
	 * 
	 * if(responseCode==200) { br2 = new BufferedReader(new
	 * InputStreamReader(con.getInputStream(),"UTF-8")); } else { // ???? ???
	 * br2 = new BufferedReader(new
	 * InputStreamReader(con.getErrorStream(),"UTF-8")); }
	 * 
	 * String jsonData = br2.readLine();
	 * 
	 * JSONObject jsonobj2 = (JSONObject) JSONValue.parse(jsonData);
	 * 
	 * JSONArray jsonobj3 = (JSONArray)
	 * JSONValue.parse(jsonobj2.get("documents").toString());
	 * 
	 * for(int j =0; j<jsonobj3.size(); j++){ JSONObject jj = (JSONObject)
	 * jsonobj3.get(j);
	 * 
	 * festival.setLatitude(jj.get("x")); festival.setLongitude(jj.get("y")); }
	 * 
	 * festival.setContents(jsonobj.get("축제내용"));
	 * festival.setDetailRegion(jsonobj.get("주관기관"));
	 * festival.setDorojuso(jsonobj.get("소재지도로명주소"));
	 * festival.setEndDate(jsonobj.get("축제종료일자"));
	 * festival.setFestivalName(jsonobj.get("축제명"));
	 * festival.setJibunjuso(jsonobj.get("소재지지번주소"));
	 * festival.setLocation(jsonobj.get("개최장소"));
	 * festival.setPhone(jsonobj.get("연락처"));
	 * festival.setRegion(jsonobj.get("주최기관"));
	 * festival.setRelations(jsonobj.get("관련정보"));
	 * festival.setSponser(jsonobj.get("후원기관"));
	 * festival.setStartDate(jsonobj.get("축제시작일자"));
	 * festival.setWebSite(jsonobj.get("홈페이지주소"));
	 * 
	 * br2.close(); this.festival = festival;
	 * System.out.println("festiiiiiiiiiiii............ : " + festival);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return festival; } }
	 * 
	 */

	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	// StringBuilder urlBuilder = new
	// StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList");
	// /*URL*/
	// urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") +
	// "=hOlSrH9rpwUcpck4Zl2Wnewju3LzLtgYgAqtW%2FVCRaCJ4BMFUxYFO%2FkzQYu7hbohWd4Z8PWeG9gWgteLzsZqVQ%3D%3D&_type=json");
	// /*Service Key*/
	// urlBuilder.append("&"+ URLEncoder.encode("contentTypeId","UTF-8") + "=15"
	// );
	// urlBuilder.append("&"+ URLEncoder.encode("areadCode","UTF-8") + "=" );
	// urlBuilder.append("&"+ URLEncoder.encode("sigunguCode","UTF-8") + "=" );
	// urlBuilder.append("&"+ URLEncoder.encode("cat1","UTF-8") + "=" );
	// urlBuilder.append("&"+ URLEncoder.encode("cat2","UTF-8") + "=" );
	// urlBuilder.append("&"+ URLEncoder.encode("cat3","UTF-8") + "=" );
	// urlBuilder.append("&"+ URLEncoder.encode("listYN","UTF-8") + "=Y" );
	// urlBuilder.append("&"+ URLEncoder.encode("MobileOS","UTF-8") + "=ETC" );
	// urlBuilder.append("&"+ URLEncoder.encode("MobileApp","UTF-8") +
	// "=TourAPI3.0_Guide" );
	// urlBuilder.append("&"+ URLEncoder.encode("arrange","UTF-8") + "=A" );
	// urlBuilder.append("&"+ URLEncoder.encode("numOfRows","UTF-8") + "=12" );
	// urlBuilder.append("&"+ URLEncoder.encode("pageNo","UTF-8") + "=1" );

	// URL url = new URL(urlBuilder.toString());
	// HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	// conn.setRequestMethod("GET");
	// conn.setRequestProperty("Content-type", "application/json");
	// System.out.println("Response code: " + conn.getResponseCode());
	// BufferedReader rd;
	// if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	// rd = new BufferedReader(new
	// InputStreamReader(conn.getInputStream(),"UTF-8"));
	// } else {
	// rd = new BufferedReader(new
	// InputStreamReader(conn.getErrorStream(),"UTF-8"));
	// }
	// StringBuilder sb = new StringBuilder();
	// String line;
	// while ((line = rd.readLine()) != null) {
	// sb.append(line);
	// }
	// rd.close();
	// conn.disconnect();
	//
	//// System.out.println("sb.........." + sb);
	//
	// JSONArray jsonarray = (JSONArray) JSONValue.parse(line);
	//
	// System.out.println("jsonarray............. : " + jsonarray);
	//
	// return festival;

	// for (int i = 0; i < jsonarray.size(); i++) {
	// JSONObject jsonobj = (JSONObject) jsonarray.get(i);

	@Override
	public Festival getOpen() throws Exception {

/*		StringBuilder urlBuilder = new StringBuilder(
				"http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList");  URL 
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=hOlSrH9rpwUcpck4Zl2Wnewju3LzLtgYgAqtW%2FVCRaCJ4BMFUxYFO%2FkzQYu7hbohWd4Z8PWeG9gWgteLzsZqVQ%3D%3D&_type=json"); 
																																	 * Service
																																	 * Key
																																	 
		urlBuilder.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=15");
		urlBuilder.append("&" + URLEncoder.encode("areadCode", "UTF-8") + "=");
		urlBuilder.append("&" + URLEncoder.encode("sigunguCode", "UTF-8") + "=");
		urlBuilder.append("&" + URLEncoder.encode("cat1", "UTF-8") + "=");
		urlBuilder.append("&" + URLEncoder.encode("cat2", "UTF-8") + "=");
		urlBuilder.append("&" + URLEncoder.encode("cat3", "UTF-8") + "=");
		urlBuilder.append("&" + URLEncoder.encode("listYN", "UTF-8") + "=Y");
		urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=ETC");
		urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=TourAPI3.0_Guide");
		urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=A");
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=12");
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=1");

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();

		JSONObject jsonobj = (JSONObject) JSONValue.parse(sb.toString());

		JSONObject jsonobj2 = (JSONObject) jsonobj.get("response");

		JSONObject jsonobj3 = (JSONObject) jsonobj2.get("body");

		JSONObject jsonobj4 = (JSONObject) jsonobj3.get("items");

		JSONArray jsonarray = (JSONArray) jsonobj4.get("item");

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject jsonobj5 = (JSONObject) jsonarray.get(i);


		ObjectMapper objectMapper = new ObjectMapper();
		Festival festival = objectMapper.readValue(jsonobj5.toString(), Festival.class);
		
		this.festival = festival;
		
		}

		System.out.println("festival............" + festival);
		
		return festival;*/
		
		//////////////////////////////////////////////////////////////////////
		
		
			
			StringBuilder urlBuilder2 = new StringBuilder(
					"http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival"); /* URL */
			urlBuilder2.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
					+ "=hOlSrH9rpwUcpck4Zl2Wnewju3LzLtgYgAqtW%2FVCRaCJ4BMFUxYFO%2FkzQYu7hbohWd4Z8PWeG9gWgteLzsZqVQ%3D%3D&_type=json"); /*
																																		 */
			urlBuilder2.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=15");
			urlBuilder2.append("&" + URLEncoder.encode("areadCode", "UTF-8") + "=");
			urlBuilder2.append("&" + URLEncoder.encode("sigunguCode", "UTF-8") + "=");
			urlBuilder2.append("&" + URLEncoder.encode("eventStartDate", "UTF-8") + "=");
			urlBuilder2.append("&" + URLEncoder.encode("eventEndDate", "UTF-8") + "=");
			urlBuilder2.append("&" + URLEncoder.encode("listYN", "UTF-8") + "=Y");
			urlBuilder2.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=ETC");
			urlBuilder2.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=TourAPI3.0_Guide");
			urlBuilder2.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=A");
			urlBuilder2.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=12");
			urlBuilder2.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=1");

			URL url2 = new URL(urlBuilder2.toString());
			HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
			conn2.setRequestMethod("GET");
			conn2.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn2.getResponseCode());
			BufferedReader rd2;
			if (conn2.getResponseCode() >= 200 && conn2.getResponseCode() <= 300) {
				rd2 = new BufferedReader(new InputStreamReader(conn2.getInputStream(), "UTF-8"));
			} else {
				rd2 = new BufferedReader(new InputStreamReader(conn2.getErrorStream(), "UTF-8"));
			}
			StringBuilder sb2 = new StringBuilder();
			String line2;
			while ((line2 = rd2.readLine()) != null) {
				sb2.append(line2);
			}
			rd2.close();
			conn2.disconnect();
			
			JSONObject jsonobj = (JSONObject) JSONValue.parse(sb2.toString());

			JSONObject jsonobj2 = (JSONObject) jsonobj.get("response");

			JSONObject jsonobj3 = (JSONObject) jsonobj2.get("body");

			JSONObject jsonobj4 = (JSONObject) jsonobj3.get("items");

			JSONArray jsonarray = (JSONArray) jsonobj4.get("item");

			for (int i = 0; i < jsonarray.size(); i++) {

				JSONObject jsonobj5 = (JSONObject) jsonarray.get(i);
				
				System.out.println("json..................: " + jsonobj5);


			ObjectMapper objectMapper = new ObjectMapper();
			Festival festival = objectMapper.readValue(jsonobj5.toString(), Festival.class);
			
			this.festival = festival;
			
			System.out.println("festival....................."+festival);

			}
		
		return festival;

	}	
}
