package com.example.demo.servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

public class SimpleStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/plain");
        var writer = resp.getWriter();
        writer.write("Supplier Diversity Tracker is running");
        writer.flush();
    }
}
