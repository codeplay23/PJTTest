package com.model2.mvc.service.domain;

public class Festival {

	String response;
	String header;
	String resultCode;
	String resultMsg;
	String body;
	String pageNo;
	String totalCount;
	String items;
	String item;
	String readcount;
	String addr2;
	String addr1;
	String contentid;
	String firstimage2;
	String title;
	String areacode;
	String createdtime;
	String mapy;
	String contenttypeid;
	String mapx;
	String zipcode;
	String cat2;
	String cat3;
	String modifiedtime;
	String cat1;
	String mlevel;
	String sigungucode;
	String tel;
	String firstimage;
	String eventstartdate;
	String eventenddate;
	
	
	public Festival() {

	}

	public Festival(String readcount, String addr2, String addr1, String contentid, String firstimage2, String title,
			String areacode, String createdtime, String mapy, String contenttypeid, String mapx, String zipcode,
			String cat2, String cat3, String modifiedtime, String cat1, String mlevel, String sigungucode, String tel,
			String firstimage) {
		super();
		this.readcount = readcount;
		this.addr2 = addr2;
		this.addr1 = addr1;
		this.contentid = contentid;
		this.firstimage2 = firstimage2;
		this.title = title;
		this.areacode = areacode;
		this.createdtime = createdtime;
		this.mapy = mapy;
		this.contenttypeid = contenttypeid;
		this.mapx = mapx;
		this.zipcode = zipcode;
		this.cat2 = cat2;
		this.cat3 = cat3;
		this.modifiedtime = modifiedtime;
		this.cat1 = cat1;
		this.mlevel = mlevel;
		this.sigungucode = sigungucode;
		this.tel = tel;
		this.firstimage = firstimage;
	}
	
	


	public String getEventstartdate() {
		return eventstartdate;
	}

	public void setEventStartDate(String eventstartdate) {
		this.eventstartdate = eventstartdate;
	}

	public String getEventenddate() {
		return eventenddate;
	}

	public void setEventenddate(String eventenddate) {
		this.eventenddate = eventenddate;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	public String getReadcount() {
		return readcount;
	}

	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getContentid() {
		return contentid;
	}

	public void setContentid(String contentid) {
		this.contentid = contentid;
	}

	public String getFirstimage2() {
		return firstimage2;
	}

	public void setFirstimage2(String firstimage2) {
		this.firstimage2 = firstimage2;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}

	public String getMapy() {
		return mapy;
	}

	public void setMapy(String mapy) {
		this.mapy = mapy;
	}

	public String getContenttypeid() {
		return contenttypeid;
	}

	public void setContenttypeid(String contenttypeid) {
		this.contenttypeid = contenttypeid;
	}

	public String getMapx() {
		return mapx;
	}

	public void setMapx(String mapx) {
		this.mapx = mapx;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCat2() {
		return cat2;
	}

	public void setCat2(String cat2) {
		this.cat2 = cat2;
	}

	public String getCat3() {
		return cat3;
	}

	public void setCat3(String cat3) {
		this.cat3 = cat3;
	}

	public String getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	public String getCat1() {
		return cat1;
	}

	public void setCat1(String cat1) {
		this.cat1 = cat1;
	}

	public String getMlevel() {
		return mlevel;
	}

	public void setMlevel(String mlevel) {
		this.mlevel = mlevel;
	}

	public String getSigungucode() {
		return sigungucode;
	}

	public void setSigungucode(String siguguncode) {
		this.sigungucode = siguguncode;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFirstimage() {
		return firstimage;
	}

	public void setFirstimage(String firstimage) {
		this.firstimage = firstimage;
	}

	@Override
	public String toString() {
		return "Festival [response=" + response + ", header=" + header + ", resultCode=" + resultCode + ", resultMsg="
				+ resultMsg + ", body=" + body + ", pageNo=" + pageNo + ", totalCount=" + totalCount + ", items="
				+ items + ", item=" + item + ", readcount=" + readcount + ", addr2=" + addr2 + ", addr1=" + addr1
				+ ", contentid=" + contentid + ", firstimage2=" + firstimage2 + ", title=" + title + ", areacode="
				+ areacode + ", createdtime=" + createdtime + ", mapy=" + mapy + ", contenttypeid=" + contenttypeid
				+ ", mapx=" + mapx + ", zipcode=" + zipcode + ", cat2=" + cat2 + ", cat3=" + cat3 + ", modifiedtime="
				+ modifiedtime + ", cat1=" + cat1 + ", mlevel=" + mlevel + ", sigungucode=" + sigungucode + ", tel="
				+ tel + ", firstimage=" + firstimage + ", eventstartdate=" + eventstartdate + ", eventenddate="
				+ eventenddate + "]";
	}

	

}
