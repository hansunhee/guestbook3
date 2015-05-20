package com.sds.icto.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sds.icto.guestbook.domain.GuestbookVo;
import com.sds.icto.guestbook.service.GuestbookService;

@Controller
public class GuestbookController {
	
	@Autowired
	GuestbookService guestbookService;
	
	@RequestMapping("/index")
	public String index(Model model){
		List<GuestbookVo> list=guestbookService.selectList();
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute GuestbookVo vo){
		guestbookService.add(vo);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteform(@RequestParam String no, Model model){
		model.addAttribute("no", no);
		return "deleteform";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam Long no, @RequestParam String password, Model model){
		GuestbookVo vo=guestbookService.selectOne(no);
		System.out.println(vo);
		System.out.println(password);
		System.out.println(no);
		if(!vo.getPassword().equals(password)){
			model.addAttribute("msg", "비밀번호가 틀렸습니다.");
			model.addAttribute("no", no);
			return "deleteform";
		}
		guestbookService.delete(no);			
		return "redirect:/index";
	}
}
