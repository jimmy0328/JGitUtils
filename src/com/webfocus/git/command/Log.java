package com.webfocus.git.command;

import java.util.Date;

import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.revwalk.RevCommit;

import com.webfocus.git.core.CommandService;

public class Log extends CommandService {

	public Log() {
		super();
	}
	
	private int count = 10;
	
	@Override
	public void execute() throws Exception {

		for (RevCommit revCommit : git.log().setMaxCount(5).call()) {
			System.out.println(revCommit.getFullMessage());
			System.out.println(revCommit.getCommitterIdent().getName() + " "
					+ revCommit.getCommitterIdent().getEmailAddress());
			System.out.println(revCommit.getCommitTime());
			PersonIdent authorIdent = revCommit.getAuthorIdent();
			Date authorDate = authorIdent.getWhen();
			System.out.println(revCommit.getAuthorIdent());
			System.out.println(authorDate);
		}
	}

//	public static void main(String[] arg) {
//
//		try {
//			new logAttr().run();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

}
