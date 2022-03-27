package com.university.of.hull.eportal.extradata;

import java.util.ArrayList;
import java.util.List;

public enum Country {

    Argentina("Argentina"),
    Brazil("Brazil"),
    Belgium("Belgium"),
    Canada("Canada"),
    Russia("Russia"),
    Sweden("Sweden"),
    Germany("Germany"),
    France("France"),
    Spain("Spain"),
    India("India"),
    Poland("Poland"),
    Romania("Romania"),
    Greece("Greece"),
    Portugal("Portugal"),
    Mexico("Mexico"),
    UnitedKingdom("UnitedKingdom"),
    UnitedStates("UnitedStates");


    private String name;

    private Country(String stringVal) {
        name=stringVal;
    }
    public String toString(){
        return name;
    }

    public static List<String> returnEnumList(){
        List<String> country = new ArrayList<>();
        for (Country e : Country.values()){
            country.add(e.toString());
        }
        return country;
    }

    public static String getEnumByString(String code){
        for(Country e : Country.values()){
            if(e.name.equals(code)) return e.name();
        }
        return "Country does not exist on eClub portal";
    }
}
