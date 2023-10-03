package com.example.newproviderfacingapp.controller;

import com.example.newproviderfacingapp.dao.AppointmentDAO;
import com.example.newproviderfacingapp.details.Appointment;
import com.example.newproviderfacingapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private AppointmentDAO appointmentDAO;

    @RequestMapping("/hello")
    public String getHello() {
        return "Hello world";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("launch");
        return modelAndView;
//        return "/launch.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(HttpServletRequest request, HttpServletResponse response) {
        loginService.login(request, response);
        return "logged in";
    }

    @RequestMapping(value = "/patientList", method = RequestMethod.GET)
    public ModelAndView  getPatients() {
        ModelAndView mav = new ModelAndView("patient");
      List<Appointment> data=  appointmentDAO.getPatientDetails();
        mav.addObject("patients", data);
        return  mav;
    }
}
