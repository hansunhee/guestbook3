package com.sds.icto.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sds.icto.guestbook.dao.GuestBookDao;
import com.sds.icto.guestbook.vo.GuestBookVo;

@Controller
public class GuestBookController {
	
	@Autowired
	GuestBookDao guestBookDao;
	
	@RequestMapping("/index")
	public String index(Model model){
		List<GuestBookVo> list=guestBookDao.selectList();
		model.addAttribute("list", list);
		return "/views/index.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@RequestParam String name, @RequestParam String password, @RequestParam String message){
		GuestBookVo vo=new GuestBookVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMessage(message);
		guestBookDao.add(vo);
		return "redirect:/index";
	}
	
	/*@RequestMapping(value="deleteform", method=RequestMethod.GET)
	public String deleteform(@RequestParam String no, Model model){
		model.addAttribute("no", no);
		return "/views/deleteform.jsp";
	}
	
	@RequestMapping("/delete")
	public String delete(){
		return "redirect:/index";
	}*/
}
