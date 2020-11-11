package com.blz.hotelreservationsystem;

import static org.junit.Assert.*;

import org.junit.Test;


public class HotelReservationSystemTest {

	@Test
	public void given3Hotels_WhenAddedToHotelWithRewardForCustomers_SizeOfMapIs3() {
		HotelReservationSystemMethods.addHotel("LakeWood", 110, 90,3,80,80);
		HotelReservationSystemMethods.addHotel("Bridgewood", 150, 50,4,110,50);
		HotelReservationSystemMethods.addHotel("RidgeWood", 220, 150,5,100,40);
		assertEquals(3, HotelReservationSystemMethods.countHotels());
	}
	
	
}
