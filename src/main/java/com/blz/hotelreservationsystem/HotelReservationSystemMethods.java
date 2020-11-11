package com.blz.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;


public class HotelReservationSystemMethods {

	private static ArrayList<HotelReservationSystem> hotelDetailsList = new ArrayList<>();

	
	public static void addHotel(String hotelName, int weekDayRates,int weekEndDayRates) {
		HotelReservationSystem hotelReservationSystem = new HotelReservationSystem(hotelName, weekDayRates,weekEndDayRates);
		hotelDetailsList.add(hotelReservationSystem);
	}

	public static int countHotels() {
		return hotelDetailsList.size();
	}

	
	public static LocalDate convertStringToDate(String dateString) {
		LocalDate date = null;
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("ddMMMyyyy");
		date = LocalDate.parse(dateString, dateTimeFormat);
		return date;
	}
	
	public static String getCheapestHotel(String input_1, String input_2) {
		LocalDate dateInput_1 = convertStringToDate(input_1);
		LocalDate dateInput_2 = convertStringToDate(input_2);
		int bookingDays = 0;
		bookingDays = (int) ChronoUnit.DAYS.between(dateInput_1, dateInput_2) + 1;
		hotelDetailsList.add(new HotelReservationSystem("LakeWood", 110,90));
		hotelDetailsList.add(new HotelReservationSystem("BridgeWood", 150,50));
		hotelDetailsList.add(new HotelReservationSystem("RidgeWood", 220,150));
		for (int i = 0; i < hotelDetailsList.size(); i++) {
			int value = hotelDetailsList.get(i).getWeekDayRates()* (bookingDays);
			hotelDetailsList.get(i).setWeekDayRates(value);
		}
		String hotelName = hotelDetailsList.stream().min(Comparator.comparing(HotelReservationSystem::getWeekDayRates)).get()
				.getHotelName();
		int cheapestRate = hotelDetailsList.stream().min(Comparator.comparing(HotelReservationSystem::getWeekDayRates)).get()
				.getWeekDayRates();

		return hotelName + " " + cheapestRate;
	}
	public static void main(String[] args) {
		// System.out.println("Welcome Message");
	}

}
