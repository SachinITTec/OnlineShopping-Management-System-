package org.shop.model;

public class catmodel {
	private int cid;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	private String catname;
	public catmodel()
	{
		
	}
	public catmodel(int cid,String catname)
	{
		this.cid=cid;
		this.catname=catname;
	}
	
}
