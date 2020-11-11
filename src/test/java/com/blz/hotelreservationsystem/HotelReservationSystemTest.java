package com.blz.hotelreservationsystem;

import static org.junit.Assert.*;

import org.junit.Test;


public class HotelReservationSystemTest {

	@Test
	public void given3Hotels_WhenAddedToHotelWithRatings_SizeOfMapIs3() {
		HotelReservationSystemMethods.addHotel("LakeWood", 110, 90,3);
		HotelReservationSystemMethods.addHotel("Bridgewood", 150, 50,4);
		HotelReservationSystemMethods.addHotel("RidgeWood", 220, 150,5);
		assertEquals(3, HotelReservationSystemMethods.countHotels());
	}
	@Test
	public void given2Dates_GetCheapestHotelByRatings() {
		String result = HotelReservationSystemMethods.cheapestBestRatedHotel("11Sep2020", "12Sep2020");
		assertEquals("RidgeWood" + ", Rating: " + 5 + " and Total Rates: $370", result);
	}

}
