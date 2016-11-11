package com.jdp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jdp.domain.UserVO;
import com.jdp.dto.LoginDTO;
import com.jdp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Inject
	private UserService service;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void longinGET(@ModelAttribute("dto") LoginDTO dto)
	{
		logger.info("longin.get...");
		
	}
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void longinPOST(LoginDTO dto, HttpSession session, Model model) throws Exception
	{
		UserVO vo=service.login(dto);
		if(vo==null)
			return;
		model.addAttribute("userVO", vo);
	}
}
