package org.hall.tasklist.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
  @RequestMapping("/")
  public String home(Model model) {
    String user = SecurityContextHolder.getContext().getAuthentication().getName();
    return "taskLists/search/findByOwner_Login?login=" + user;
  }
}