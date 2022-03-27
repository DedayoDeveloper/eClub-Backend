package com.university.of.hull.eportal.extradata;

import java.util.ArrayList;
import java.util.List;

public enum PaymentStatus {
    Paid("Paid"),
    Unpaid("Unpaid");

    private String name;

    private PaymentStatus(String val){
        name=val;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<String> returnEnumList(){
        List<String> paymentStatus = new ArrayList<>();
        for (PaymentStatus e : PaymentStatus.values()){
            paymentStatus.add(e.toString());
        }
        return paymentStatus;
    }

    public static String getEnumByString(String code){
        for(PaymentStatus e : PaymentStatus.values()){
            if(e.name.equals(code)) return e.name();
        }
        return "User-Role does not exist on eClub portal";
    }
}
