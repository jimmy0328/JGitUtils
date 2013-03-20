package com.webfocus.git.command;

import java.io.File;
import java.util.Map;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import com.webfocus.git.core.CommandService;

public class Clone extends CommandService {

	public Clone() {
		super(false);
	}

	@Override
	public void execute(Map info) throws Exception {
		UsernamePasswordCredentialsProvider user = new UsernamePasswordCredentialsProvider(
				datasource.getUserid(), datasource.getPassword());
		File rootPath = new File(datasource.getGitRespository());
		if (!rootPath.exists()) {
			rootPath.mkdir();
		}
		Git.cloneRepository().setDirectory(rootPath).setURI(datasource.getUrl())
				.setCredentialsProvider(user).call();
	}

}
