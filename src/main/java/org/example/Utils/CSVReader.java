package org.example.Utils;

import org.example.Entity.City;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.SortedSet;
import java.util.TreeSet;

public class CSVReader {
    private String path;

    public CSVReader(String path) {
        this.path = path;
    }

    public SortedSet<City> readCities() {
        SortedSet<City> cities = new TreeSet<City>((n1, n2) -> n1.getIndex() - n2.getIndex());
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                cities.add(convert(values));
            }
        } catch (Exception e) {
            System.out.println("Read exception: " + e.getMessage());
        }
        return cities;
    }

    private City convert(String[] val) {
        try {
            City city = new City(Integer.parseInt(val[0]), val[1], val[2], val[3], Integer.parseInt(val[4]));
            if (val.length == 6)
                city.setFoundation(val[5]);
            return city;
        } catch (Exception e) {
            System.out.println("Convert exception: " + e.getMessage());
        }
        return null;
    }
}
