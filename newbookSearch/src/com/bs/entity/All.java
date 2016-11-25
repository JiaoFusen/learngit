package com.bs.entity;

public class All {
	//数据库字段
	private String title;
	private String author;
	private String summary;
	private String journary;
	private String age;
	private String keyword;
	
	//getter setter
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
	
	public String getSummary(){
		return summary;
	}
	public void setSummary(String summary){
		this.summary = summary;
	}
	
	public String getJournary(){
		return journary;
	}
	public void setJournary(String journary){
		this.journary = journary;
	}
	
	public String getAge(){
		return age;
	}
	public void setAge(String age){
		this.age = age;
	}
	
	public String getKeyword(){
		return keyword;
	}
	public void setKeyword(String keyword){
		this.keyword = keyword;
	}
	
	//构造方法
	public All(String title,String author,String summary,String journary, String age,String keyword){
		super();
		this.title = title;
		this.author = author;
		this.summary = summary;
		this.journary = journary;;
		this.age = age;
		this.keyword = keyword;
	}
}
