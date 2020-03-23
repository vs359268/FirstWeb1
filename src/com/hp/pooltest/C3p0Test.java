package com.hp.pooltest;
import java.beans.PropertyVetoException;
 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
 
import com.hp.Data.Datas;
import com.mchange.v2.c3p0.ComboPooledDataSource;
public class C3p0Test {
	//ʹ�ñ��뷽ʽʵ��c3p0���ݿ����ӳ�
	     @Test
	     public void TestC3p0() throws PropertyVetoException, SQLException{
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
	         Connection con=dataSource.getConnection();
	         String sql="select * from temp";
	         PreparedStatement ps=con.prepareStatement(sql);
	         ResultSet rs=ps.executeQuery();
	         
	         List<Datas> list=new ArrayList<Datas>();
	         while(rs.next()){
	        	 Datas user=new Datas();
	        	 user.setId(rs.getString("id"));
	        	 user.setDate_time(rs.getString("date_time"));
	        	 user.setMax_temp(rs.getString("max_temp"));
	        	 user.setMin_temp(rs.getString("min_temp"));
	             list.add(user);
	         }
	         
	         System.out.println(list);
	     }
	 
}
