package com.university.of.hull.eportal.extradata;

import java.util.ArrayList;
import java.util.List;

public enum TransactionStatus {
	
	InvalidOrIncomplete("0 - Invalid or incomplete"),
	CancelledByCustomer("1 - Cancelled by customer"),
	AuthorisationDeclined("2 - Authorisation declined"),
	Authorised("5 - Authorised"),
	AuthorisedAndCancelled("6 - Authorised and cancelled"),
	PaymentDeleted("7 - Payment deleted"),
	Refund("8 - Refund"),
	PaymentRequested("9 - Payment requested");
	
	private String name;

    private TransactionStatus(String val){
        name=val;
    }

    public String toString(){
        return name;
    }

    public static List<String> returnEnumList(){
        List<String> transactionStatus = new ArrayList<>();
        for (TransactionStatus e : TransactionStatus.values()){
        	transactionStatus.add(e.toString());
        }
        return transactionStatus;
    }

    public static String getEnumByString(String code){
        for(TransactionStatus e : TransactionStatus.values()){
            if(e.name.equals(code)) return e.name();
        }
        return "Transaction Status does not exist on eClub portal";
    }
}
