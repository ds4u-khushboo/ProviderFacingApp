package com.example.newproviderfacingapp.service;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Encounter;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.hl7.fhir.r4.model.MolecularSequence.PATIENT;

@Service
public class PatientRetrieve {
    public void fetch() {

        FhirContext ctx = FhirContext.forR4();
        IGenericClient client = ctx.newRestfulGenericClient("https://epic.fhir.com");
        String patientId = "123";
        Bundle response = client.search()
                .forResource(Encounter.class)
                .where(PATIENT.hasId(patientId))
                .include(Patient.INCLUDE_ALL.asRecursive())
                .returnBundle(Bundle.class).execute();

        List<Patient> listPatients = new ArrayList<Patient>();
        for (BundleEntryComponent entryComponent : response.getEntry()) {
            response.getEntry().forEach(entry -> {
                if (entry.getResource() instanceof Patient) {
                    listPatients.add((Patient) entry.getResource());
                }
            });
        }
    }

    @Read
    public void readData() {
        FhirContext ctx = FhirContext.forR4();

        // Create a client
        IGenericClient client = ctx.newRestfulGenericClient("https://hapi.fhir.org/baseR4");

        // Read a patient with the given ID
        Patient patient = (Patient) client
                .read()
                .resource(Patient.class)
                .withId("123")
                .execute();

        // Print the patient's name
        String string = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(patient);
        System.out.println(string);

    }
}
//    Patient patient = new Patient();
//
//        patient.setId("1");
//        patient.addIdentifier().setSystem("http://optum.com/MRNs").setValue("007");
//        patient.addName().setFamily("Chakravarty").addGiven("Mithun").addGiven("A");
//        patient.addAddress().addLine("Address Line 1");
//        patient.addAddress().setCity("Mumbai");
//        patient.addAddress().setCountry("India");
//        patient.addTelecom().setValue("111-111-1111");
//        this.patientMap.put("1", patient);
