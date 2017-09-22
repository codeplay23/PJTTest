package com.model2.mvc.web.festival;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model2.mvc.service.domain.Festival;
import com.model2.mvc.service.festival.FestivalService;


@Controller
@RequestMapping("/festival/*")
public class FestivalController {
	
	@Autowired
	@Qualifier("festivalServiceImpl")
	private FestivalService festivalService;
		
	public FestivalController(){
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
//	@RequestMapping( value="getFestival", method=RequestMethod.GET )
//	public ModelAndView getFestivalList( @ModelAttribute("festival") Festival festival) throws Exception {
//		
//		//open API 소스 삽입 란..
//
//		festivalService.getFestivalList(festival);
//		
//		ModelAndView md = new ModelAndView();
//		md.addObject(festival);
//		md.setViewName("forward:/festival/getFestival.jsp");
//		 
//		return md;
//	}
	
//	@RequestMapping( value="addFestival", method=RequestMethod.GET )
//	public String addFestival( @ModelAttribute("festival") Festival festival ) throws Exception {
//
//		festivalService.addFestival(festival);
//		
//		return "forward:/festival/addFestival.jsp";
//	}
	
	@RequestMapping( value="getOpen", method=RequestMethod.GET )
	public ModelAndView getOpen(@ModelAttribute ("festival") Festival festival) throws Exception { 

		festival = festivalService.getOpen();
		
		ModelAndView md = new ModelAndView();
		
		md.addObject(festival);
		md.setViewName("forward:/festival/getFestival.jsp");
		
		return md;
		
	}

}