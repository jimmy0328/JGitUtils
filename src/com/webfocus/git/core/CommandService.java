package com.webfocus.git.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.eclipse.jgit.api.Git;

import com.webfocus.git.RepositoryDataSource;

public abstract class CommandService {

	protected Git git = null;

	public static RepositoryDataSource datasource = null;

	public abstract void execute(Map info) throws Exception;

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
		if(datasource==null){
			config();
		}
		File root = new File(datasource.getGitRespository());
		try {
			git = Git.open(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	/**
	 * read git properties from git.properties
	 */
	private void config() {
		datasource = new RepositoryDataSource();
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("conf/git.properties"));
			datasource.setUserid(prop.getProperty("userid"));
			datasource.setPassword(prop.getProperty("password"));
			datasource.setGitRespository(prop.getProperty("gitRespository"));
			datasource.setUrl(prop.getProperty("url"));
			datasource.setMail(prop.getProperty("mail"));
			datasource.setInitDirectory(prop.getProperty("initDirectory"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// private String userid;
	// private String password;
	// private String gitRespository;
	// private String url;
	// private String mail;
	// private String initDirectory;
	//
	// public String getMail() {
	// return mail;
	// }
	//
	// public void setMail(String mail) {
	// this.mail = mail;
	// }
	//
	// public String getUserid() {
	// return userid;
	// }
	//
	// public void setUserid(String userid) {
	// this.userid = userid;
	// }
	//
	// public String getPassword() {
	// return password;
	// }
	//
	// public void setPassword(String password) {
	// this.password = password;
	// }
	//
	// public String getGitRespository() {
	// return gitRespository;
	// }
	//
	// public void setGitRespository(String gitRespository) {
	// this.gitRespository = gitRespository;
	// }
	//
	// public String getUrl() {
	// return url;
	// }
	//
	// public void setUrl(String url) {
	// this.url = url;
	// }
	//
	// public String getInitDirectory() {
	// return initDirectory;
	// }
	//
	// public void setInitDirectory(String initDirectory) {
	// this.initDirectory = initDirectory;
	// }

}
