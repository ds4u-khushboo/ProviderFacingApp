package com.example.newproviderfacingapp.controller;

import com.example.newproviderfacingapp.dao.AppointmentDAO;
import com.example.newproviderfacingapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        modelAndView.setViewName("launch.html");
        return modelAndView;
//        return "/launch.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(@RequestParam String returnUrl, HttpServletRequest request, HttpServletResponse response) {
        loginService.login(request, response, returnUrl);
        return "logged in";
    }

    @RequestMapping(value = "/ptientList", method = RequestMethod.GET)
    public String getPatients() {
        ModelAndView mav = new ModelAndView("patient");
        mav.addObject("patients", appointmentDAO.getPatientDetails());
        return "logged in";
    }
}
