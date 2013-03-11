package com.webfocus.git.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.jgit.api.Git;

public abstract class CommandService {

	protected Git git = null;

	public abstract void execute() throws Exception;

	public CommandService() {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CommandService(boolean isInit) {
		if (!isInit) {
			config();
		}
	}

	public void init() throws IOException {
		config();
		File root = new File(gitRespository);
		try {
			git = Git.open(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void config() {

		System.out.println("Datasource Config!");
		Properties prop = new Properties();
		try {
			// load a properties file
			prop.load(new FileInputStream("conf/git.properties"));
			setUserid(prop.getProperty("userid"));
			setPassword(prop.getProperty("password"));
			setGitRespository(prop.getProperty("gitRespository"));
			setUrl(prop.getProperty("url"));
			setMail(prop.getProperty("mail"));
			setInitDirectory(prop.getProperty("initDirectory"));
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private String userid;
	private String password;
	private String gitRespository;
	private String url;
	private String mail;
	private String initDirectory;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGitRespository() {
		return gitRespository;
	}

	public void setGitRespository(String gitRespository) {
		this.gitRespository = gitRespository;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getInitDirectory() {
		return initDirectory;
	}

	public void setInitDirectory(String initDirectory) {
		this.initDirectory = initDirectory;
	}

}
