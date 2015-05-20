package com.sds.icto.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.icto.guestbook.domain.GuestbookVo;
import com.sds.icto.guestbook.repository.GuestbookDao;

@Service
public class GuestbookService {
	
	@Autowired
	GuestbookDao guestbookDao;
	
	public void add(GuestbookVo vo){
		guestbookDao.add(vo);
	}
	
	public void delete(Long no){
		guestbookDao.delete(no);
	}
	
	public GuestbookVo selectOne(Long no){
		return guestbookDao.selectOne(no);		
	}
	
	public List<GuestbookVo> selectList(){
		return guestbookDao.selectList();
	}
}
