package com.blz.hotelreservationsystem;

public class HotelReservationSystem {
	private String hotelName;
	private int weekDayRates;
	private int weekEndDayRates;
	
	public HotelReservationSystem(String hotelName, int weekDayRates ,int weekEndDayRates) {
		this.hotelName = hotelName;
		this.weekDayRates = weekDayRates;
		this.weekEndDayRates = weekEndDayRates;
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
				+ ", weekEndDayRates=" + weekEndDayRates + "]";
	}
	
}
