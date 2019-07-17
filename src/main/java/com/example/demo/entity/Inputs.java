package com.example.demo.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Inputs {
	@Id
	private int  version;
	private String basepath;
	private String title;
	private String host;
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getBasepath() {
		return basepath;
	}
	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	@Override
	public String toString() {
		return "Inputs [version=" + version + ", basepath=" + basepath + ", title=" + title + ", host=" + host + "]";
	}
	
	
	
	
	

}
