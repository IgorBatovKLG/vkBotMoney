package com.batov.vkbotmoney;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://195.58.51.111:5432/test_db"; // Замените на свой URL
            String username = "info_comp"; // Замените на свой логин
            String password = "123456"; // Замените на свой пароль

            // Устанавливаем соединение
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Проблемы с подключением к базе данных");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
