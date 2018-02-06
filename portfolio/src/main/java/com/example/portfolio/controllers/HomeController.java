package com.example.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
        @RequestMapping("/")
        public String index(Model model) {
            model.addAttribute("dojoName", "Burbank");
            return "index.jsp";
        }
        
        @RequestMapping("/date")
        public String date(Model model) {
            model.addAttribute("date", "Sunday, the 21 of May, 2017");
       	 return "date.jsp";
        }
        
        @RequestMapping("/time")
        public String time(Model model) {
            model.addAttribute("time", "11:30 PM");
       	 return "time.jsp";
        }
}
