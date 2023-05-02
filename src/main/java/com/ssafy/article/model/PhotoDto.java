package com.ssafy.article.model;

public class PhotoDto {
	private int photoNo;
	private int articleNo;
	private String photoSaveFolder;
	private String photoOriginalName;
	private String photoSaveName;
	private String photoStatus;
	
	public int getPhotoNo() {
		return photoNo;
	}
	public void setPhotoNo(int photoNo) {
		this.photoNo = photoNo;
	}
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public String getPhotoSaveFolder() {
		return photoSaveFolder;
	}
	public void setPhotoSaveFolder(String photoSaveFolder) {
		this.photoSaveFolder = photoSaveFolder;
	}
	public String getPhotoOriginalName() {
		return photoOriginalName;
	}
	public void setPhotoOriginalName(String photoOriginalName) {
		this.photoOriginalName = photoOriginalName;
	}
	public String getPhotoSaveName() {
		return photoSaveName;
	}
	public void setPhotoSaveName(String photoSaveName) {
		this.photoSaveName = photoSaveName;
	}
	public String getPhotoStatus() {
		return photoStatus;
	}
	public void setPhotoStatus(String photoStatus) {
		this.photoStatus = photoStatus;
	}
	
	@Override
	public String toString() {
		return "PhotoDto [photoNo=" + photoNo + ", articleNo=" + articleNo + ", photoSaveFolder=" + photoSaveFolder
				+ ", photoOriginalName=" + photoOriginalName + ", photoSaveName=" + photoSaveName + ", photoStatus="
				+ photoStatus + "]";
	}
	

}
