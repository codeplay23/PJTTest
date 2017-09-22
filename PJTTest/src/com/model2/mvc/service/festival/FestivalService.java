package com.model2.mvc.service.festival;

import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Festival;

public interface FestivalService {
	
	public Festival getOpen() throws Exception;  // openAPI get
	
	public void addFestival(Festival festival) throws Exception; // db 구축 add
	
	public Map<String,Object> getFestivalList(Search search) throws Exception; // list 뽑기용.

	
}