package com.university.of.hull.eportal.extradata;

import java.util.ArrayList;
import java.util.List;

public enum Status {

	Active("Active"),
    Suspended("Suspended"),
    Deactivated("Deactive"),
    Pending("Pending");

	
	private String name;

    private Status(String stringVal) {
        name=stringVal;
    }
    public String toString(){
        return name;
    }

    public static List<String> returnEnumList(){
        List<String> status = new ArrayList<>();
        for (Status eStatus : Status.values()){
        	status.add(eStatus.toString());
        }
        return status;
    }

    public static String getEnumByString(String code){
        for(Status eStatus : Status.values()){
            if(eStatus.name.equals(code)) return eStatus.name();
        }
        return "Status does not exist on eClub portal";
    }
}
