package com.jdp.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.jdp.domain.UserVO;
import com.jdp.dto.LoginDTO;
import com.jdp.service.UserService;
/**
 * user login
 * @author kwon
 * update date : 2016-11-11
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Inject
	private UserService service;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	/**
	 * user login
	 * @param dto user id, pw, cookie
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void longinGET(@ModelAttribute("dto") LoginDTO dto)
	{
		logger.info("longin.get...");
		
	}
	/**
	 * user login/auto login
	 * @param dto : user id, pw, cookie
	 * @param session
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void longinPOST(LoginDTO dto, HttpSession session, Model model) throws Exception
	{
		UserVO vo=service.login(dto);
		if(vo==null)
			return;
		model.addAttribute("userVO", vo);
		
		if(dto.isUseCookie())
		{
			int amount=60*60*24*7;
			Date sessionLimit=new Date(System.currentTimeMillis()+1000*amount);
			service.keepLogin(vo.getUid(), session.getId(), sessionLimit);
		}
	}
	/**
	 * user logout
	 * @param request
	 * @param response
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String longout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception
	{
		Object studentObj, teacherObj;

		studentObj=session.getAttribute("student");
		teacherObj=session.getAttribute("teacher");
		
		if(studentObj!=null)
		{
			UserVO student=(UserVO) studentObj;
			
			session.removeAttribute("student");
			session.invalidate();
			
			Cookie studentCookie = WebUtils.getCookie(request, "studentCookie");
			
			if(studentCookie !=null)
			{
				studentCookie.setPath("/");
				studentCookie.setMaxAge(0);
				response.addCookie(studentCookie);
				service.keepLogin(student.getUid(), session.getId(), new Date());
			}
		}
		
		if(teacherObj!=null)
		{
			UserVO teacher=(UserVO) teacherObj;
			
			session.removeAttribute("teacher");
			session.invalidate();
			
			Cookie teacherCookie = WebUtils.getCookie(request, "teacherCookie");
			
			if(teacherCookie !=null)
			{
				teacherCookie.setPath("/");
				teacherCookie.setMaxAge(0);
				response.addCookie(teacherCookie);
				service.keepLogin(teacher.getUid(), session.getId(), new Date());
			}
		}
		return "redirect:/user/login";
	}

}
