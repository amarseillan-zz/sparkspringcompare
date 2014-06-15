package ar.edu.itba.it.amarseillan.ab.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.itba.it.amarseillan.ab.domain.dao.PostRepository;
import ar.edu.itba.it.amarseillan.ab.domain.model.Post;

@Controller
public class IndexController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		
		List<Post> posts = PostRepository.getInstance().getAll();
		mav.addObject("posts", posts);
		
		return mav;
		
	}
}
