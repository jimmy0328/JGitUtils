package com.webfocus.git.command;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import com.webfocus.git.core.CommandService;

public class Clone extends CommandService {

	public Clone() {
		super(false);
	}

	@Override
	public void execute() throws Exception {
		UsernamePasswordCredentialsProvider user = new UsernamePasswordCredentialsProvider(
				super.getUserid(), super.getPassword());
		File rootPath = new File(super.getGitRespository());
		if (!rootPath.exists()) {
			rootPath.mkdir();
		}
		Git.cloneRepository().setDirectory(rootPath).setURI(super.getUrl())
				.setCredentialsProvider(user).call();
	}

}
