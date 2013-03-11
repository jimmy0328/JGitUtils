package com.webfocus.git.command;

import java.util.Iterator;

import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import com.webfocus.git.core.CommandService;

public class Push extends CommandService {

	@Override
	public void execute() throws Exception {
		// credentials
		CredentialsProvider cp = new UsernamePasswordCredentialsProvider(
				super.getUserid(), super.getPassword());
		PushCommand pc = git.push();
		pc.setCredentialsProvider(cp).setForce(true).setPushAll();
		try {
			Iterator<PushResult> it = pc.call().iterator();
			if (it.hasNext()) {
				System.out.println(it.next().toString());
			}
		} catch (InvalidRemoteException e) {
			e.printStackTrace();
		}
	}

}
