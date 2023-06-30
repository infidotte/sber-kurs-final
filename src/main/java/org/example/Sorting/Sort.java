package org.example.Sorting;

import org.example.Entity.City;

import java.util.*;
import java.util.stream.Collectors;

public class Sort {
    public SortedSet<City> sortByName(SortedSet<City> cities){
        return cities.stream().sorted(City::compareByName).collect(Collectors.toCollection(TreeSet::new));
    }
    public SortedSet<City> sortByNameAndDistrict(SortedSet<City> cities){
        return cities.stream().sorted(City::compareByDistrict).collect(Collectors.toCollection(TreeSet::new));
    }
    public SortedSet<City> sortByPopulation(SortedSet<City> cities){
        return cities.stream().sorted(City::compareByPopulation).collect(Collectors.toCollection(TreeSet::new));
    }
    public HashMap<String, Integer> countByRegion(SortedSet<City> cities){
        HashMap<String, Integer> result = new HashMap<>();
        for (City i:
             cities) {
            String region = i.getRegion();
            if(result.containsKey(region)){
                result.put(region, result.get(region)+1);
            }else{
                result.put(region, 1);
            }
        }
        return result;
    }
}
