package com.webfocus.git;

public class RepositoryDataSource {

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
