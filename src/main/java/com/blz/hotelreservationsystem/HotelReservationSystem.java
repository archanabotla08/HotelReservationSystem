package com.blz.hotelreservationsystem;

public class HotelReservationSystem {
	private String hotelName;
	private int weekDayRates;
	private int weekEndDayRates;
	private int ratings;
	private int rewardWeekDays;
	private int rewardWeekendDays;
	
	public HotelReservationSystem(String hotelName, int weekDayRates ,int weekEndDayRates,int ratings,int rewardWeekDays,int rewardWeekendDays) {
		this.hotelName = hotelName;
		this.weekDayRates = weekDayRates;
		this.weekEndDayRates = weekEndDayRates;
		this.ratings = ratings;
		this.rewardWeekDays = rewardWeekDays;
		this.rewardWeekendDays = rewardWeekendDays;
	}
	public int getRewardWeekDays() {
		return rewardWeekDays;
	}
	public void setRewardWeekDays(int rewardWeekDays) {
		this.rewardWeekDays = rewardWeekDays;
	}
	public int getRewardWeekendDays() {
		return rewardWeekendDays;
	}
	public void setRewardWeekendDays(int rewardWeekendDays) {
		this.rewardWeekendDays = rewardWeekendDays;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getWeekDayRates() {
		return weekDayRates;
	}
	public void setWeekDayRates(int weekDayRates) {
		this.weekDayRates = weekDayRates;
	}
	public int getWeekEndDayRates() {
		return weekEndDayRates;
	}
	public void setWeekEndDayRates(int weekEndDayRates) {
		this.weekEndDayRates = weekEndDayRates;
	}
	@Override
	public String toString() {
		return "HotelReservationSystem [hotelName=" + hotelName + ", weekDayRates=" + weekDayRates
				+ ", weekEndDayRates=" + weekEndDayRates + ", ratings=" + ratings + ", rewardWeekDays=" + rewardWeekDays
				+ ", rewardWeekendDays=" + rewardWeekendDays + "]";
	}
	
	
}
