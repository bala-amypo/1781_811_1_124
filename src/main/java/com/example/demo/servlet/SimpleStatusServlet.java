package com.example.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/status")
public class SimpleStatusServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res) throws IOException {

        res.setStatus(HttpServletResponse.SC_OK);
        res.setContentType("text/plain");

        PrintWriter writer = res.getWriter();

        try {
            writer.write("Supplier Diversity Tracker is running");
        } catch (Exception ignored) {}

        try {
            writer.flush();
        } catch (Exception ignored) {}
    }
}
