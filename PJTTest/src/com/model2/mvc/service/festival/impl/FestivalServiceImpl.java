package com.model2.mvc.service.festival.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Festival;
import com.model2.mvc.service.festival.FestivalDao;
import com.model2.mvc.service.festival.FestivalService;


@Service("festivalServiceImpl")
public class FestivalServiceImpl implements FestivalService{
	
	///Field
	@Autowired
	@Qualifier("festivalDaoImpl")
	private FestivalDao festivalDao;
	
	
	public void setFestivalDao(FestivalDao festivalDao) {
		this.festivalDao = festivalDao;
	}
	
	///Constructor
	public FestivalServiceImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public void addFestival(Festival festival) throws Exception {
		// TODO Auto-generated method stub
		
		festivalDao.addFestival(festival);
		
	}

	@Override
	public Festival getOpen() throws Exception {
		// TODO Auto-generated method stub
		
		return festivalDao.getOpen();
		
	}

	@Override
	public Map<String, Object> getFestivalList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}