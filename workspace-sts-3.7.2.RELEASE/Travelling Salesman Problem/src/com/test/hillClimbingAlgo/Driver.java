package com.test.hillClimbingAlgo;

import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
	private ArrayList<City> initialCities = new ArrayList<City>(Arrays.asList(
			new City("Boston", 42.3601, -71.0589),
			new City("Houston", 29.7604, -95.3698),
			new City("Austin", 30.2672, -97.7431),
			new City("Denver", 39.7392, -104.9903),
			new City("Los Angeles", 34.0522, -118.2437),
			new City("Chicago", 41.8781, -87.6298),
			new City("New York", 40.7128, 70.0059),
			new City("Dallas", 32.7767, -96.7970),
			new City("Seattle", 47.6062, -122.3321)
			));

	public static void main(String[] args) {
		Driver driver = new Driver();
		Route route = new Route(driver.initialCities);
		printHeading(route);
		System.out.print(route + " |		" + route.getTotalDistance());
		new HillClimbing().findShortestRoute(route);
	}
	
	public static void printHeading(Route route){
		String headingColumn1 = "Route";
		String remainingHeadingColumns = "Distance (in miles) | Compare adjacent to current route";
		int cityNamesLength = 0;
		for( int i = 0 ; i < route.getCities().size() ; i++){
			cityNamesLength += route.getCities().get(i).getName().length();
		}
		
		int arrayLength = cityNamesLength + (route.getCities().size()*2);
		int partialLength = (arrayLength - headingColumn1.length())/2;
		for( int i = 0 ; i < partialLength ; i++){
			System.out.print(" ");
		}
		System.out.print(headingColumn1);
		for( int i = 0 ; i < partialLength ; i++){
			System.out.print(" ");
		}
		if((arrayLength % 2) == 0)System.out.print(" ");
		System.out.println(" | " + remainingHeadingColumns);
		cityNamesLength += remainingHeadingColumns.length() + 3;
		for( int i = 0 ; i < cityNamesLength + (route.getCities().size()*2) ; i++){
			System.out.print("-");
		}
		System.out.println("");
	}

}
