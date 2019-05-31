package com.example.domain;

/**
 * ホテル情報のドメイン.
 * 
 * @author ryuheisugita
 */
public class HotelInfo {
	
	/** ホテル名 */
	private String hotelName;
	/** 最寄り駅 */
	private String nearestStation;
	/** 価格*/
	private Integer price;
	
	@Override
	public String toString() {
		return "HotelInfo [hotelName=" + hotelName + ", nearestStation=" + nearestStation + ", price=" + price + "]";
	}
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getNearestStation() {
		return nearestStation;
	}
	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

}
