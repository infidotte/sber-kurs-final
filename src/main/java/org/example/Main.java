package org.example;

import org.example.Entity.City;
import org.example.Utils.CSVReader;
import org.example.Sorting.Sort;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;

public class Main {
    public static void main(String[] args) {
        CSVReader reader = new CSVReader("src/main/resources/Cities.csv");
        SortedSet<City> cities = reader.readCities();
        Sort sort = new Sort();
        //default sort
        int count = 0;
        for (City i :
                cities) {
            System.out.println(i);
            count++;
            if(count==100)
                break;
        }

        //sorted by name
        count=0;
        System.out.println("Sort by name:");
        for (City i:
             sort.sortByName(cities)) {
            System.out.println(i);
            count++;
            if(count==100)
                break;
        }

        //sorted by district and name
        count=0;
        System.out.println("Sort by district and name:");
        for (City i:
                sort.sortByNameAndDistrict(cities)) {
            System.out.println(i);
            count++;
            if(count==100)
                break;
        }

        //biggest population
        City city = sort.sortByPopulation(cities).last();
        System.out.println("\n" + "Biggest population:" +"\n" + "[" + city.getIndex() + "] - " + city.getPopulation());

        //count by region
        System.out.println("\n" + "Count by region:");
        for (Map.Entry entry:
             sort.countByRegion(cities).entrySet()) {
            System.out.println(entry);
        }
    }
}