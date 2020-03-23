package com.hp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.hp.dao.ItempDao;
import com.hp.dao.Temp;
import com.hp.utils.JDBCUtil;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import org.junit.Test;

import com.hp.Data.Datas;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.crypto.provider.RSACipher;
/**
 * @author Administrator
 *
 */
public class TempDaoImpl implements ItempDao {

	@Override
	public boolean insertTempDateBatch(List<String> data) {
		// TODO Auto-generated method stub
		JDBCUtil jdbcUtil = new JDBCUtil();
		
		try {
			jdbcUtil.update("delete from temp", null);
//			Connection conn = jdbcUtil.getConnection();
			//��һ�����������ӳغ��Ĺ�����
	         ComboPooledDataSource dataSource=new ComboPooledDataSource();
	         //�ڶ��������ӳأ�url���������˺ţ����룬��ʼ�����������������
	         dataSource.setJdbcUrl("jdbc:mysql:///test");//����url
	         dataSource.setDriverClass("com.mysql.jdbc.Driver");//��������
	         dataSource.setUser("root");//mysql���˺�
	         dataSource.setPassword("123456");//mysql������
	         dataSource.setInitialPoolSize(6);//��ʼ������������ʼ��6������
	         dataSource.setMaxPoolSize(50);//�������������������������50
	         dataSource.setMaxIdleTime(60);//������ʱ��
	         
	         //�������������ӳض����л�ȡ���ݿ�����
	         Connection conn=dataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into temp(id, date_time, max_temp, min_temp) values(?, ?, ?, ?)");
		//	System.out.println(data.size());
			for (int i = 0; i < data.size(); i++) {
				String[] split = data.get(i).split("##");
				pstmt.setString(1, split[0]);
				pstmt.setString(2, split[1]);
				pstmt.setString(3, split[2]);
				pstmt.setString(4, split[3]);
				pstmt.addBatch();
				if ((i != 0 && i % 100 == 0) ||i==data.size()-1) { 
					pstmt.executeBatch();
					conn.commit();
					pstmt.clearBatch();
				}
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			try {
				jdbcUtil.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	
	@Override
	public boolean insertTempDate(List<Object> data) {
		// TODO Auto-generated method stub
		JDBCUtil jdbcUtil = new JDBCUtil();
		try {
			boolean update = jdbcUtil.update("insert into temp(id, date_time, max_temp, min_temp) values(?, ?, ?, ?)", data);
			return update;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			try {
				jdbcUtil.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}


	@Override
	public Temp queryTemp() {
		// TODO Auto-generated method stub
		JDBCUtil jdbcUtil = new JDBCUtil();
		Temp temp=new Temp();
		try {//�ַ���ƴ��
			StringBuilder stringBuilder=new StringBuilder(); //�̲߳���ȫ  Ч�ʸ�
			stringBuilder.append("SELECT DATE_FORMAT(t.date_time, '%Y%m'),FORMAT(AVG(t.max_temp),2),FORMAT(AVG(t.min_temp),2)");
			stringBuilder.append("FROM temp t GROUP BY DATE_FORMAT(t.date_time, '%Y%m')");
			ResultSet rs=jdbcUtil.query(stringBuilder.toString(), null);
			while(rs.next()) {
				temp.getMaxList().add(rs.getString(2));
				temp.getMinList().add(rs.getString(3));
			}
					
			//			new StringBuffer();  //�̰߳�ȫ  Ч�ʽϵ�
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		
		} finally {
			try {
				jdbcUtil.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return temp;
	}

}