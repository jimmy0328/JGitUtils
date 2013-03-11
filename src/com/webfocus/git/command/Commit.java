package com.webfocus.git.command;

import com.webfocus.git.core.CommandService;

public class Commit extends CommandService {

	private String msg = "";

	public Commit() {
	}

	public void setMessage(String commitMsg) {
		this.msg = commitMsg;
	}

	@Override
	public void execute() throws Exception {
		git.commit().setCommitter(super.getUserid(), super.getMail())
				.setMessage(msg).call();
	}

}
