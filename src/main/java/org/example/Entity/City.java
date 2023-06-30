package org.example.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class City implements Comparable<City>{
    public City(int index, String name, String region, String district, int population) {
        this.index = index;
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
    }

    private Integer index;
    private String name;
    private String region;
    private String district;
    private Integer population;
    private String foundation;

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation='" + foundation + '\'' +
                '}';
    }

    public int compareByName(City o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }
    public int compareByDistrict(City o){
        int comparison;
        if ((comparison = this.getDistrict().compareTo(o.getDistrict())) == 0)
            return this.getName().compareToIgnoreCase(o.getName());
        else
            return comparison;
    }
    public int compareByPopulation(City o) {
        return this.getPopulation().compareTo(o.getPopulation());
    }

    @Override
    public int compareTo(City o) {
        return 1;
    }
}
