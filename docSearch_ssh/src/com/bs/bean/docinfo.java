package com.bs.bean;

public class docinfo {
	private int docid;
	private String title;
	private String author;
	private String abstracts;
	private String journal;
	private String year;
	private String keywords;
	
	public int getDocid(){
		return docid;
	}
	
	public void setDocid(int docid){
		this.docid = docid;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public void setAuthor(String author){
		this.author = author;
	}
	
	public String getAbstracts(){
		return abstracts;
	}
	
	public void setAbstracts(String abstracts){
		this.abstracts = abstracts;
	}
	
	public String getJournal(){
		return journal;
	}
	
	public void setJournal(String journal){
		this.journal = journal;
	}
	
	public String getYear(){
		return year;
	}
	
	public void setYear(String year){
		this.year = year;
	}
	
	public String getKeywords(){
		return keywords;
	}
	
	public void setKeywords(String keywords){
		this.keywords = keywords;
	}
}
