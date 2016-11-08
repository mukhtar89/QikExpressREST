package com.rest.qikexpress.objects;

public class Grocery {
	
	private Integer brandId, photoWidth;

	private String placeId, photoReference, profileImage;
	
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getPhotoReference() {
		return photoReference;
	}
	public void setPhotoReference(String photoReference) {
		this.photoReference = photoReference;
	}
	public Integer getPhotoWidth() {
		return photoWidth;
	}
	public void setPhotoWidth(Integer photoWidth) {
		this.photoWidth = photoWidth;
	}
	
}
