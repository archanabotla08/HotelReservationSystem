package com.blz.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HotelReservationSystemMethods {

	private static int cheapestRate;
	private static ArrayList<HotelReservationSystem> hotelDetailsList = new ArrayList<>();
	static Map<String, Integer> hotelMap = new HashMap<>();
	public static ArrayList<String> hotelList = new ArrayList<String>();
	public static HotelReservationSystem bestRatedHotelForCustomers = null;
	public static ArrayList<String> strDays = new ArrayList<String>(
			Arrays.asList("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"));

	public static void addHotel(String hotelName, int weekDayRates, int weekEndDayRates, int ratings,
			int rewardWeekDays, int rewardWeekendDays) {
		HotelReservationSystem hotelReservationSystem = new HotelReservationSystem(hotelName, weekDayRates,
				weekEndDayRates, ratings, rewardWeekDays, rewardWeekendDays);
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

	public static ArrayList<String> getCheapestHotel(String input_1, String input_2) {
		LocalDate dateInput_1 = convertStringToDate(input_1);
		LocalDate dateInput_2 = convertStringToDate(input_2);
		DayOfWeek dayOfWeek_1 = getDays(dateInput_1);
		DayOfWeek dayOfWeek_2 = getDays(dateInput_2);

		hotelDetailsList.add(new HotelReservationSystem("LakeWood", 110, 90, 3, 80, 80));
		hotelDetailsList.add(new HotelReservationSystem("BridgeWood", 150, 50, 4, 110, 50));
		hotelDetailsList.add(new HotelReservationSystem("RidgeWood", 220, 150, 5, 100, 40));
		int rent = 0;
		for (int i = 0; i < hotelDetailsList.size(); i++) {
			rent = 0;
			if (strDays.contains(dayOfWeek_1) || strDays.contains(dayOfWeek_2)) {
				rent = rent + hotelDetailsList.get(i).getWeekEndDayRates();
				hotelDetailsList.get(i).setWeekEndDayRates(rent);

			} else {
				rent = rent + hotelDetailsList.get(i).getWeekDayRates();
				hotelDetailsList.get(i).setWeekDayRates(rent);
			}
		}
		for (int i = 0; i < hotelDetailsList.size(); i++) {
			int temp = hotelDetailsList.get(i).getWeekDayRates() + hotelDetailsList.get(i).getWeekEndDayRates();
			hotelDetailsList.get(i).setWeekDayRates(temp);

		}
		cheapestRate = hotelDetailsList.stream().max(Comparator.comparing(HotelReservationSystem::getWeekDayRates))
				.get().getWeekDayRates();

		String hotelName = hotelDetailsList.stream().max(Comparator.comparing(HotelReservationSystem::getWeekDayRates))
				.get().getHotelName();

		for (HotelReservationSystem hotel : hotelDetailsList) {
			hotelList.add(hotel.getHotelName());
			hotelMap.put(hotel.getHotelName(), hotel.getRatings());
		}

		return hotelList;
	}

	public static String cheapestBestRatedHotel(String input_1, String input_2) {
		getCheapestHotel(input_1, input_2);
		Map.Entry<String, Integer> hotelRating = null;
		for (Map.Entry<String, Integer> entry : hotelMap.entrySet()) {
			if (hotelRating == null || entry.getValue().compareTo(hotelRating.getValue()) > 0) {
				hotelRating = entry;
			}
		}
		return hotelRating.getKey() + ", Rating: " + hotelRating.getValue() + " and Total Rates: $" + cheapestRate;
	}


	public static String getCheapestBestRatedForRewardCustomer(String input_1, String input_2,boolean reward) {

		LocalDate dateInput_1 = convertStringToDate(input_1);
		LocalDate dateInput_2 = convertStringToDate(input_2);
		DayOfWeek dayOfWeek_1 = getDays(dateInput_1);
		DayOfWeek dayOfWeek_2 = getDays(dateInput_2);
		hotelDetailsList.add(new HotelReservationSystem("LakeWood", 110, 90, 3, 80, 80));
		hotelDetailsList.add(new HotelReservationSystem("BridgeWood", 150, 50, 4, 110, 50));
		hotelDetailsList.add(new HotelReservationSystem("RidgeWood", 220, 150, 5, 100, 40));
		int rent = 0;
		int bestRatings = 0;

		for (int i = 0; i < hotelDetailsList.size(); i++) {
			rent = 0;
			if (strDays.contains(dayOfWeek_1) || strDays.contains(dayOfWeek_2)) {
				rent = rent + hotelDetailsList.get(i).getRewardWeekendDays();
				hotelDetailsList.get(i).setRewardWeekendDays(rent);

			} else {
				rent = rent + hotelDetailsList.get(i).getRewardWeekDays();
				hotelDetailsList.get(i).setRewardWeekDays(rent);
			}
		}
		for (int i = 0; i < hotelDetailsList.size(); i++) {
			int temp = hotelDetailsList.get(i).getRewardWeekDays() + hotelDetailsList.get(i).getRewardWeekendDays();
			hotelDetailsList.get(i).setRewardWeekDays(temp);

		}
		for (HotelReservationSystem hotelReservationSystem : hotelDetailsList) {
			if (hotelReservationSystem.getRatings() > bestRatings) {
				bestRatings = hotelReservationSystem.getRatings();
				bestRatedHotelForCustomers = hotelReservationSystem;
			}
		}
		int higestRatings = hotelDetailsList.stream()
								.max(Comparator.comparing(HotelReservationSystem::getRatings)).get().getRatings();
		int cheapestRate = hotelDetailsList.stream()
				.min(Comparator.comparing(HotelReservationSystem::getRewardWeekDays)).get().getRewardWeekDays();

		return bestRatedHotelForCustomers.getHotelName() + ", Ratings: " + higestRatings
				+ " and Total Rate: $ " + cheapestRate;

	}


	public static void main(String[] args) throws CusotmExceptionForInvalidEnteries {
		HotelReservationSystemMethods hotelReservationSystemMethods = new HotelReservationSystemMethods();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter start Date : ");
		String input_1 = sc.nextLine();
		System.out.println("Enter end Date : ");
		String input_2 = sc.nextLine();
		System.out.println("Are Reward Customers : true/false");
		boolean reward = sc.nextBoolean();
		System.out.println(
				"Enter choice \n1.FindCheapestHotelForRewardee \n3.Exit ");
		int entry = sc.nextInt();
			switch (entry) {
			case 1:
				hotelReservationSystemMethods.getCheapestBestRatedForRewardCustomer(input_1, input_2, reward);
				break;
			default:
				throw new CusotmExceptionForInvalidEnteries("Enteries are invalid");
			}
	}

	

}
