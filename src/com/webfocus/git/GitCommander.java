package com.webfocus.git;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class GitCommander {

	private String action = "execute";

	public Object _attrObj;

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
			Method m = cls.getMethod(action, null);
			System.out.println("========== start "
					+ _attrObj.getClass().getSimpleName() + " ========");
			m.invoke(_attrObj, null);
			// _attrObj = m.invoke(cons[0].newInstance(null), null);
			System.out.println("========== finish do ==========");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
