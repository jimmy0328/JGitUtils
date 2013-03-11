package com.webfocus.git.command;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import com.webfocus.git.core.CommandService;

public class Init extends CommandService {

	public Init(){
	}
	
	@Override
	public void execute() throws Exception {
		File root = new File(getInitDirectory());
		if(!root.exists()){
			root.mkdir();
		}
		File gitF = new File(getInitDirectory()+"/.git");
		if(!gitF.exists()){
			try {
				Git.init().setDirectory(root).call();
			} catch (GitAPIException e) {
				e.printStackTrace();
			}
		}
		
	}



}
