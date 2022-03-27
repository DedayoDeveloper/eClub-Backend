package com.university.of.hull.eportal.extradata;

import java.util.ArrayList;
import java.util.List;

public enum Roles {

    SystemAdmin("SystemAdmin"),
    Club("Club"),
    Member("Member");

    private String name;

    private Roles(String val){
        name=val;
    }

    public String toString(){
        return name;
    }

    public static List<String> returnEnumList(){
        List<String> roles = new ArrayList<>();
        for (Roles e : Roles.values()){
            roles.add(e.toString());
        }
        return roles;
    }

    public static String getEnumByString(String code){
        for(Roles e : Roles.values()){
            if(e.name.equals(code)) return e.name();
        }
        return "User-Role does not exist on eClub portal";
    }
}
