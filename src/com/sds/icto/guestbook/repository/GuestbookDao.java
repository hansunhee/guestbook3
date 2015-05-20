package com.sds.icto.guestbook.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.guestbook.domain.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public void add(GuestbookVo vo){
		sqlMapClientTemplate.insert("guestbook.insert", vo);
	}
	public void delete(Long no){
		sqlMapClientTemplate.delete("guestbook.delete", no);
	}
	public GuestbookVo selectOne(Long no){
		GuestbookVo vo=(GuestbookVo)sqlMapClientTemplate.queryForObject("guestbook.selectOne", no);
		return vo;
	}
	@SuppressWarnings("unchecked")
	public List<GuestbookVo> selectList(){
		List<GuestbookVo> list=sqlMapClientTemplate.queryForList("guestbook.selectList");
		return list;
	}
}
