/**
 * Created by Madhav on 3/8/2018.
 */
package com.madsum.shopcite;

public class ShopDetails {

    private String rank;
    private String country;
    private String population;
    private int flag;

    public ShopDetails(String rank, String country, String population,
                           int flag) {
        this.rank = rank;
        this.country = country;
        this.population = population;
        this.flag = flag;
    }

    public String getRank() {
        return this.rank;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPopulation() {
        return this.population;
    }

    public int getFlag() {
        return this.flag;
    }
}
