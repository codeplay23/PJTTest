package com.model2.mvc.service.festival;

import java.util.List;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Festival;

public interface FestivalDao {
	
	public Festival getOpen() throws Exception;
	
	public void addFestival(Festival festival) throws Exception ;

	public void getFestival(Festival festival);

	
}