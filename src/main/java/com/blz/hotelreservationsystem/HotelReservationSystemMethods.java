package com.blz.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class HotelReservationSystemMethods {

	private static ArrayList<HotelReservationSystem> hotelDetailsList = new ArrayList<>();
	public static ArrayList<String> strDays = new ArrayList<String>(
			Arrays.asList("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"));

	public static void addHotel(String hotelName, int weekDayRates, int weekEndDayRates) {
		HotelReservationSystem hotelReservationSystem = new HotelReservationSystem(hotelName, weekDayRates,
				weekEndDayRates);
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
	public static DayOfWeek getDays(LocalDate date) {
		DayOfWeek day = null;
		day = DayOfWeek.from(date);
		return day;
	}

	public static String getCheapestHotel(String input_1, String input_2) {
		LocalDate dateInput_1 = convertStringToDate(input_1);
		LocalDate dateInput_2 = convertStringToDate(input_2);
		DayOfWeek dayOfWeek_1 = getDays(dateInput_1);
		DayOfWeek dayOfWeek_2 = getDays(dateInput_2);

		hotelDetailsList.add(new HotelReservationSystem("LakeWood", 110, 90));
		hotelDetailsList.add(new HotelReservationSystem("BridgeWood", 150, 50));
		hotelDetailsList.add(new HotelReservationSystem("RidgeWood", 220, 150));
		int rent = 0;
		for (int i = 0; i < hotelDetailsList.size(); i++) {
			if (strDays.contains(dayOfWeek_1) || strDays.contains(dayOfWeek_2)) {
				rent = rent + hotelDetailsList.get(i).getWeekEndDayRates();
				System.out.println(rent);
				hotelDetailsList.get(i).setWeekEndDayRates(rent);

			} else {
				rent = rent + hotelDetailsList.get(i).getWeekDayRates();
				System.out.println(rent);
				hotelDetailsList.get(i).setWeekDayRates(rent);
			}

		}
		for (int i = 0; i < hotelDetailsList.size(); i++) {
			int temp = hotelDetailsList.get(i).getWeekDayRates() + hotelDetailsList.get(i).getWeekEndDayRates();
			hotelDetailsList.get(i).setWeekDayRates(temp);
		}
		String hotelName = hotelDetailsList.stream().min(Comparator.comparing(HotelReservationSystem::getWeekDayRates)).get()
				.getHotelName();
		int cheapestRate = hotelDetailsList.stream().min(Comparator.comparing(HotelReservationSystem::getWeekDayRates)).get()
				.getWeekDayRates();

		return hotelName + " Total Rate $: " + cheapestRate;
	}

	public static void main(String[] args) {
		// System.out.println("Welcome Message");
	}

}
