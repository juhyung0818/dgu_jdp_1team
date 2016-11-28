package com.jdp.dto;
/**
 * 
 * @author kwon
 * 2016.11.18.Fri
 */
public class LoginDTO {
	private String uid;
	private String upw;
	private boolean useCookie;
	
	/* getter, setter, toString methods */
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	@Override
	public String toString() {
		return "LoginDTO [uid=" + uid + ", upw=" + upw + ", useCookie=" + useCookie + "]";
	}
}
