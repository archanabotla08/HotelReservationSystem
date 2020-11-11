package com.blz.hotelreservationsystem;

import java.util.ArrayList;



public class HotelReservationSystemMethods {
	
	private static ArrayList<HotelReservationSystem> hotelDetailsList = new ArrayList<>();
	
	// UseCase: 1
		public static void addHotel(String hotelName, int regularRates) {
			HotelReservationSystem hotelReservationSystem = new HotelReservationSystem(hotelName, regularRates);
			hotelDetailsList.add(hotelReservationSystem);
		}

		public static int countHotels() {
			return hotelDetailsList.size();
		}
	public static void main(String[] args) {
		//System.out.println("Welcome Message");
	}

}
