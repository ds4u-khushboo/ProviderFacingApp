package com.example.newproviderfacingapp.dao;

import com.example.newproviderfacingapp.details.Appointment;
import com.example.newproviderfacingapp.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentDAO {

    @Autowired
    AppointmentRepo appointmentRepo;

    public List<Appointment> getPatientDetails() {

        List<Appointment> appointment=appointmentRepo.findAll();
        System.out.println("appointment"+appointment);
        return appointment;
    }
}
//                appointment.setId(resultSet.getInt(1));// appoint id
//                appointment.setUserId(resultSet.getInt(2));// userId
//                appointment.setfullname(resultSet.getString(3));
//                appointment.setGender(resultSet.getString(4));
//                appointment.setAge(resultSet.getString(5));
//                appointment.setAppointmentdate(resultSet.getString(6));
//                appointment.setEmail(resultSet.getString(7));
//                appointment.setPhone(resultSet.getString(8));
//                appointment.setDiseases(resultSet.getString(9));
//                appointment.setDoctorid(resultSet.getInt(10));
//                appointment.setAddress(resultSet.getString(11));
//                appointment.setStatus(resultSet.getString(12));
//                appList.add(appointment);


