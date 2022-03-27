package com.university.of.hull.eportal.restcontroller;


import java.util.List;

import com.university.of.hull.eportal.extradata.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.of.hull.eportal.extradata.Country;
import com.university.of.hull.eportal.extradata.Roles;


@RestController
@RequestMapping(value = "/e-portal")
public class DataController {

    private Country country;
    private Roles roles;
    private Status status;

    @GetMapping(value = "/countrylist")
    public List<String> countryList(){
        return country.returnEnumList();
    }

    @GetMapping(value = "/eclubroles")
    public List<String> rolesList() throws Exception {
        return roles.returnEnumList();
    }


}
