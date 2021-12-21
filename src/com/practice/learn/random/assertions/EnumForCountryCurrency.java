package com.practice.learn.random.assertions;

import java.util.Arrays;
import java.util.Optional;

enum Currency{
    GB("GB","GBP"),
    IE("IE","EUR");

    private final String country;
    private final String currency;

    Currency(String country, String currency){
        this.country = country;
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCountry() {
        return country;
    }
}

public class EnumForCountryCurrency {
    public Optional<Currency> getCurrencyFromCountry(String country) {
        /*Currency[] values = Currency.values();
        for(Currency c:values){
            System.out.println(c.getCountry());
            System.out.println(c.getCurrency());
            if(c.getCountry().equalsIgnoreCase(country)){
                return c.getCurrency();
            }
        }
        return "";*/

        return Arrays.stream(Currency.values())
                .filter(currency1 -> currency1.getCountry().equalsIgnoreCase(country)).
                findFirst();
    }

    public static void main(String[] args) {
        EnumForCountryCurrency e = new EnumForCountryCurrency();
        System.out.println(e.getCurrencyFromCountry("GB").isPresent() ? e.getCurrencyFromCountry("GB").get().getCurrency() : "");
        System.out.println(e.getCurrencyFromCountry("IE").isPresent() ? e.getCurrencyFromCountry("IE").get().getCurrency() : "");
        System.out.println(e.getCurrencyFromCountry("IEE").isPresent() ? e.getCurrencyFromCountry("IEE").get().getCurrency() : "");
    }
}
