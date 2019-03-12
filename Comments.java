package com.jdbc.jdbcprograms.jdbc;

public class Comments {
	private int cid;
	private String cmtbody;

	public Comments() {
		super();
	}

	public Comments(int cid, String body) {
		this.cid = cid;
		this.cmtbody = body;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCmtBody() {

		return cmtbody;
	}

	public void setBody(String body) {
		this.cmtbody = body;
	}

	public String toString() {
		return "Post [Cid=" + cid + ", body=" + cmtbody + "]";
	}

}
