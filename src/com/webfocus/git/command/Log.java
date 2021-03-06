package com.webfocus.git.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.revwalk.RevCommit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webfocus.git.core.CommandService;

public class Log extends CommandService {

	public Log() {
		super();
	}

	private int count = 10;

	private String log = "";

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	@Override
	public void execute(Map info) throws Exception {
		if (info.size() > 0) {
			count = Integer.parseInt("" + info.get("count"));
		}
		ArrayList logs = new ArrayList();
		System.out.println("count:" + count);
		for (RevCommit revCommit : git.log().setMaxCount(count).call()) {
			PersonIdent authorIdent = revCommit.getAuthorIdent();
			Date authorDate = authorIdent.getWhen();
			Map logMap = new HashMap();
			logMap.put("fullMessage", revCommit.getFullMessage());
			logMap.put("name", revCommit.getCommitterIdent().getName());
			logMap.put("email", revCommit.getCommitterIdent().getEmailAddress());
			logMap.put("commitTime", revCommit.getCommitTime());
			logMap.put("authorDate", authorDate);
			logs.add(logMap);
		}
		String log = new ObjectMapper().writeValueAsString(logs);
		this.setLog(log);
	}
}
