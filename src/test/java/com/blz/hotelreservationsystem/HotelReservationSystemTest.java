package com.blz.hotelreservationsystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class HotelReservationSystemTest {

	@Test
	public void given3Hotels_WhenAddedToHotelWithWeekDayAndWeekEndDayRates_SizeOfMapIs3() {
		HotelReservationSystemMethods.addHotel("LakeWood", 110, 90);
		HotelReservationSystemMethods.addHotel("Bridgewood", 150, 50);
		HotelReservationSystemMethods.addHotel("Ridgewood", 220, 150);
		assertEquals(3, HotelReservationSystemMethods.countHotels());
	}
	@Test
	public void given2Dates_GetCheapestHotelByWeekAndWeekendDays() {
		String result = HotelReservationSystemMethods.getCheapestHotel("11Sep2020", "12Sep2020");
		System.out.print(result);
		assertEquals("LakeWood" + " Total Rate $: "+ "200", result);
	}

}
