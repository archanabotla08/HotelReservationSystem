package com.blz.hotelreservationsystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class HotelReservationSystemTest {

	// Test UC:1
	@Test
	public void given3Hotels_WhenAddedToHotelMap_SizeOfMapIs3() {
		assertEquals(3, HotelReservationSystemMethods.countHotels());
	}

	// Test UC:1
	@Test
	public void givenHotels_GetCheapestHotel() {
		String result = HotelReservationSystemMethods.getCheapestHotel("10Sep2020", "11Sep2020");
		assertEquals("LakeWood 220", result);
	}

}
