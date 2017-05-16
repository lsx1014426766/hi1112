package com.zrgk.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import oracle.jdbc.OracleTypes;

import org.hibernate.Query;
import org.hibernate.Session;

import com.zrgk.entity.Emp;
import com.zrgk.util.HibernateUtil1;

//命名sql调用存储过程
public class TestProcedure {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		Session session = HibernateUtil1.getSession();
		Query query = session.getNamedQuery("getListProc");
		// 给问号设置值
		query.setInteger(0, 10);
		//query.setParameter(i, list.get(i));
		//query.executeUpdate();  //增删改

		
// 通过CallableStatement调用存储过程
//		Connection conn = session.connection();
//		String sql ="{call xxxx(?,?)}";
//		CallableStatement call = conn.prepareCall(sql);
//		call.setObject(1,xxxx);
//		call.registerOutParameter(1, Types.INTEGER);
//		call.registerOutParameter(2, OracleTypes.CURSOR);
		
		
		List<Emp> list = query.list();
		for(Emp e:list){
			System.out.println(e.getEname());
		}
		session.close();
	}

}
