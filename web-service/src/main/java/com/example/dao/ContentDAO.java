package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Content;
import com.example.util.DBConnection;

public class ContentDAO {

    private static final String INSERT_CONTENT_SQL = "INSERT INTO contents (filename, description, file) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_CONTENTS = "SELECT * FROM contents";

    public void saveContent(Content content) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTENT_SQL)) {
            preparedStatement.setString(1, content.getFileName());
            preparedStatement.setString(2, content.getDescription());
            preparedStatement.setBlob(3, content.getFile());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Content> getAllContents() {
        List<Content> contents = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTENTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String fileName = rs.getString("filename");
                String description = rs.getString("description");
                Content content = new Content(fileName, description, null);
                contents.add(content);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contents;
    }
}
