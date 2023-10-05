package com.example.newproviderfacingapp.controller;

import com.example.newproviderfacingapp.service.PatientRetrieve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FhirController {

    @Autowired
    PatientRetrieve patientRetrieve;

    @RequestMapping(value = "/fetch", method = RequestMethod.GET)
    public void fetchData() {
        patientRetrieve.fetch();
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public void read() {
        patientRetrieve.readData();
    }
}