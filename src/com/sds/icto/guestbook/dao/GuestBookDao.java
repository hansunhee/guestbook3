package com.sds.icto.guestbook.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sds.icto.guestbook.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn=DriverManager.getConnection(url, "webdb", "webdb");
		return conn;
	}
	public void add(GuestBookVo vo){
		try {
			Connection conn=getConnection();
			String sql="INSERT INTO GUESTBOOK VALUES(GUESTBOOK_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getMessage());
			stmt.executeUpdate();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(Long no){
		try {
			Connection conn=getConnection();
			String sql="DELETE FROM GUESTBOOK WHERE NO = ?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setLong(1, no);
			stmt.executeUpdate();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public GuestBookVo selectOne(Long no){
		GuestBookVo vo=new GuestBookVo();
		try {
			Connection conn=getConnection();
			String sql="SELECT * FROM GUESTBOOK WHERE NO = ?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setLong(1, no);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				String name=rs.getString(2);
				String password=rs.getString(3);
				String message=rs.getString(4);
				Date date=rs.getDate(5);
				vo=new GuestBookVo(no, name, password, message, date);
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	public List<GuestBookVo> selectList(){
		List<GuestBookVo> list=new ArrayList<GuestBookVo>();
		try {
			Connection conn=getConnection();
			String sql="SELECT * FROM GUESTBOOK";
			PreparedStatement stmt=conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				Long no=rs.getLong(1);
				String name=rs.getString(2);
				String password=rs.getString(3);
				String message=rs.getString(4);
				Date date=rs.getDate(5);
				list.add(new GuestBookVo(no, name, password, message, date));
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
