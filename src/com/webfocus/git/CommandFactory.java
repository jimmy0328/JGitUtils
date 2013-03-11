package com.webfocus.git;

import com.webfocus.git.command.Add;
import com.webfocus.git.command.Clone;
import com.webfocus.git.command.Commit;
import com.webfocus.git.command.Init;
import com.webfocus.git.command.Log;
import com.webfocus.git.command.Pull;
import com.webfocus.git.command.Push;

public class CommandFactory {

	static GitCommander commander = new GitCommander();

	public static void cloneProject() {
		Clone clone = new Clone();
		try {
			clone.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void log() {
		Log log = (Log) commander.setCommand(new Log());
	}

	public static void pull() {
		commander.setCommand(new Pull());
	}
	
	public static void add() {
		commander.setCommand(new Add());
	}
	
	public static void gitInit(){
		commander.setCommand(new Init());
	}
	
	public static void push(){
		commander.setCommand(new Push());
	}

	public static void commit(String msg) {
		Commit commit = new Commit();
		commit.setMessage(msg);
		commander.setCommand(commit);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		CommandFactory.gitInit();
		CommandFactory.push();
		CommandFactory.log();
//		CommandFactory.add();
//		CommandFactory.commit("add mongo datasource!!");
//		CommandFactory.log();
	
	}

}
