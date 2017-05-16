package com.zrgk.generaror;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
// 自定义主键生成策略 //使用时class="包名.·类名"
public class MyGeneratorKey implements IdentifierGenerator{
	public Serializable generate(SessionImplementor arg0, Object arg1)
			throws HibernateException {
		String baseStr = "java1410";
		int i=0;
		baseStr+=i++;
		return baseStr;
	}
}
