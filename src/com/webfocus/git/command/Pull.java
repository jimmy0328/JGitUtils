package com.webfocus.git.command;

import java.util.Map;

import com.webfocus.git.core.CommandService;

public class Pull extends CommandService {

	@Override
	public void execute(Map info) throws Exception {
		git.add().addFilepattern(".+").call();
		git.pull();
	}

}
