package com.example.counter.anything;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController{
	@RequestMapping("")
	public String index(HttpSession session){
		if(session.getAttribute("count") == null){
			session.setAttribute("count",0);
		}else{
			session.setAttribute("count",(Integer) session.getAttribute("count")+1);
		}

		return "index.jsp";
	}

	@RequestMapping("/counter")
	public String counter(){
		return "_counter.jsp";
	}

	@RequestMapping("/countertwo")
	public String counterTwo(HttpSession session){
		if(session.getAttribute("count") == null){
			session.setAttribute("count",0);
		}else{
			session.setAttribute("count",(Integer) session.getAttribute("count")+2);
		}
		return "_counter2.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session){
		session.setAttribute("count",0);
		return "redirect:/counter";
	}
}