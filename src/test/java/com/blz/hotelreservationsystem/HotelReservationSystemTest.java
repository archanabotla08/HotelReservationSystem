package com.blz.hotelreservationsystem;

import static org.junit.Assert.*;

import org.junit.Test;


public class HotelReservationSystemTest {

	// Test UC:1
		@Test
		public void given3Hotels_WhenAddedToHotelMap_SizeOfMapIs3() {
			HotelReservationSystemMethods.addHotel("LakeWood", 110);
			HotelReservationSystemMethods.addHotel("Bridgewood", 150);
			HotelReservationSystemMethods.addHotel("Ridgewood", 220);
			assertEquals(3, HotelReservationSystemMethods.countHotels());
		}

}
