package com.webfocus.git;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
			clone.execute(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void log(int count) {
		Map info = new HashMap();
		info.put("count", count);
		Log log = (Log) commander.setCommand(new Log(), info);
		String logs = log.getLog();
		System.out.println("logs::"+logs);
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<Map> logList = mapper.readValue(logs,
					new TypeReference<List<Map>>() {
					});
			for (Map l : logList) {
				System.out.println(l);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void log() {
		log(5);
	}

	public static void pull() {
		commander.setCommand(new Pull());
	}

	public static void add() {
		commander.setCommand(new Add());
	}

	public static void gitInit() {
		commander.setCommand(new Init());
	}

	public static void push() {
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
		// CommandFactory.cloneProject();
		// CommandFactory.gitInit();
		CommandFactory.push();
	    CommandFactory.log(2);
		// CommandFactory.add();
	    CommandFactory.commit("refactor datasource!!");
		// CommandFactory.log();

	}

}
