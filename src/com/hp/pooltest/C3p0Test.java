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
	//使用编码方式实现c3p0数据库连接池
	     @Test
	     public void TestC3p0() throws PropertyVetoException, SQLException{
	         //第一步：创建连接池核心工具类
	         ComboPooledDataSource dataSource=new ComboPooledDataSource();
	         //第二步：连接池，url，驱动，账号，密码，初始连接数，最大连接数
	         dataSource.setJdbcUrl("jdbc:mysql:///test");//设置url
	         dataSource.setDriverClass("com.mysql.jdbc.Driver");//设置驱动
	         dataSource.setUser("root");//mysql的账号
	         dataSource.setPassword("123456");//mysql的密码
	         dataSource.setInitialPoolSize(6);//初始连接数，即初始化6个连接
	         dataSource.setMaxPoolSize(50);//最大连接数，即最大的连接数是50
	         dataSource.setMaxIdleTime(60);//最大空闲时间
	         
	         //第三步：从连接池对象中获取数据库连接
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
