/**
 * 
 */
/**
 * @author hqlip
 *
 */
package com.imooc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;

public class MessageDao {
	
	public List<Message> queryMessage2 (String command, String description) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = dbAccess.getSqlSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return null;
	}
	public static void main(String[] args) {
		MessageDao messageDao = new MessageDao();
		messageDao.queryMessage2("", "");
	}
	
	public List<Message> queryMessage (String command, String description) {
		List<Message> messageList = new ArrayList<Message>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_message", "root", "root");
			//String sql = "select ID,COMMAND,DESCRIPTION,CONTENT from MESSAGE";
			StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1 = 1");
			List<String> paramList = new ArrayList<String>();
			if (command != null && !"".equals(command.trim())) {
				sql.append(" and COMMAND=?");
				paramList.add(command);
			}
			if (description != null && !"".equals(description.trim())) {
				sql.append(" and description=?");
				paramList.add(description);
			}
			PreparedStatement statement = conn.prepareStatement(sql.toString());
			for (int i = 0; i < paramList.size(); i++) {
				statement.setString(i + 1, paramList.get(i));
			}
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				Message message = new Message();
				messageList.add(message);
				message.setId(rs.getString("ID"));
				message.setCommand(rs.getString("COMMAND"));
				message.setDescription(rs.getString("DESCRIPTION"));
				message.setContent(rs.getString("CONTENT"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageList;
	}
	
}