package com.example.newproviderfacingapp.service;

import com.example.newproviderfacingapp.details.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    public void login(HttpServletRequest req, HttpServletResponse resp,String returnUrl) {

        try {

            //create one static Admin for this project
            String email = req.getParameter("UserName");
            String password = req.getParameter("Password");

            HttpSession session = req.getSession();

            //logic for a static Admin
            if ("khushboo_DS4U".equals(email) && "Fhir@ds4u1".equals(password)) {

                session.setAttribute("adminObj", new User());

                resp.sendRedirect("https://fhir.epic.com/");
            } else {
                session.setAttribute("errorMsg", "Invalid Username or Password.");
                resp.sendRedirect("https://signin.epic.com/adfs/ls/?wa=wsignin1.0&wtrealm=https%3a%2f%2ffhir.epic.com%2f&wctx=rm%3d0%26id%3dpassive%26ru%3d%252fAccount%252fSignIn%253freturnUrl%253d&wct=2023-09-23T12%3a34%3a09Z&wreply=https%3a%2f%2ffhir.epic.com%2f");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
