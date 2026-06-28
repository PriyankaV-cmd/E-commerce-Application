package com.ecommerce;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet; // Import the annotation

// Map this servlet to the root URL or a specific path like "/home"
@WebServlet("/home")
public class App extends HttpServlet { // Capitalized class name

    @Override // Good practice to include this when overriding doGet
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Welcome to E-Commerce App!</h1>");
    }
} // Added the missing closing brace