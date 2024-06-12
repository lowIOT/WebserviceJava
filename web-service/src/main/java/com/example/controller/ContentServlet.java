package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.example.dao.ContentDAO;
import com.example.model.Content;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private ContentDAO contentDAO;

    public void init() {
        contentDAO = new ContentDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("upload".equals(action)) {
            uploadContent(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listContent(request, response);
    }

    private void uploadContent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String description = request.getParameter("description");
        Content content = new Content(fileName, description, filePart.getInputStream());
        contentDAO.saveContent(content);
        response.sendRedirect("content.jsp");
    }

    private void listContent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Content> contents = contentDAO.getAllContents();
        request.setAttribute("contents", contents);
        request.getRequestDispatcher("content.jsp").forward(request, response);
    }
}
