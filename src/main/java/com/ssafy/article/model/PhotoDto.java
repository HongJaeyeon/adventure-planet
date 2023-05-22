package com.ssafy.article.model;

public class PhotoDto {
	private int photoNo;
	private int articleNo;
	private int planNo;
	private String photoOriginalName;
	private String photoSaveName;
	private int photoStatus;
	private String photoAddTime;
	
	public PhotoDto() {	}

	public PhotoDto(int photoNo, int articleNo, int planNo, String photoOriginalName, String photoSaveName,
			int photoStatus, String photoAddTime) {
		super();
		this.photoNo = photoNo;
		this.articleNo = articleNo;
		this.planNo = planNo;
		this.photoOriginalName = photoOriginalName;
		this.photoSaveName = photoSaveName;
		this.photoStatus = photoStatus;
		this.photoAddTime = photoAddTime;
	}

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

	public int getPlanNo() {
		return planNo;
	}

	public void setPlanNo(int planNo) {
		this.planNo = planNo;
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

	public int getPhotoStatus() {
		return photoStatus;
	}

	public void setPhotoStatus(int photoStatus) {
		this.photoStatus = photoStatus;
	}

	public String getPhotoAddTime() {
		return photoAddTime;
	}

	public void setPhotoAddTime(String photoAddTime) {
		this.photoAddTime = photoAddTime;
	}

	@Override
	public String toString() {
		return "PhotoDto [photoNo=" + photoNo + ", articleNo=" + articleNo + ", planNo=" + planNo
				+ ", photoOriginalName=" + photoOriginalName + ", photoSaveName=" + photoSaveName + ", photoStatus="
				+ photoStatus + ", photoAddTime=" + photoAddTime + "]";
	}
	
	

}
