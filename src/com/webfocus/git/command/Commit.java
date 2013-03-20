package com.webfocus.git.command;

import java.util.Map;

import com.webfocus.git.core.CommandService;

public class Commit extends CommandService {

	private String msg = "";

	public Commit() {
	}

	public void setMessage(String commitMsg) {
		this.msg = commitMsg;
	}

	@Override
	public void execute(Map info) throws Exception {
		git.commit().setCommitter(datasource.getUserid(), datasource.getMail())
				.setMessage(msg).call();
	}

}
