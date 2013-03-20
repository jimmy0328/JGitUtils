package com.webfocus.git.command;

import java.util.Map;

import com.webfocus.git.core.CommandService;


//http://download.eclipse.org/jgit/docs/jgit-2.0.0.201206130900-r/apidocs/org/eclipse/jgit/revwalk/RevCommit.html#getAuthorIdent%28%29

public class Add extends CommandService {

	@Override
	public void execute(Map info) throws Exception {
		//TODO
		//default add all update files
		git.add().addFilepattern(".+").call();
	}
}