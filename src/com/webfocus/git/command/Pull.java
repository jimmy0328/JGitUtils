package com.webfocus.git.command;

import com.webfocus.git.core.CommandService;

public class Pull extends CommandService {

	@Override
	public void execute() throws Exception {
		git.add().addFilepattern(".+").call();
		git.pull();
	}

}
