package com.webfocus.git;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

public class GitCommander {

	private String action = "execute";

	public Object _attrObj;
	
	public Map _info;
	
	public Object setCommand(Object attr,Map info){
		this._info = info;
		return setCommand(attr);
	}

	public GitCommander() {
	}

	public Object setCommand(Object attr) {
		this._attrObj = attr;
		run();
		return this._attrObj;
	}

	public void run() {

		Class cls;
		try {
			cls = Class.forName(_attrObj.getClass().getName());

			Constructor[] cons = cls.getConstructors();
			Method[] methods = cls.getMethods();
			Method m = cls.getMethod(action, new Class[] { Map.class });
			m.invoke(_attrObj,_info);
			// _attrObj = m.invoke(cons[0].newInstance(null), null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
