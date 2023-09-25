package com.batov.vkbotmoney.Dao;

import com.batov.vkbotmoney.DBConnection;
import com.batov.vkbotmoney.Model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BalanceDaoJdbc {


    public UserModel getUserStats(int userId) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.connection;
        ResultSet resultSet = null;
        UserModel userModel = new UserModel(1,1,1);

        try {
            String sql = "SELECT number_of_messages, number_of_invitations FROM public.user_vk WHERE user_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int numberOfMessages = resultSet.getInt("number_of_messages");
                int numberOfInvitations = resultSet.getInt("number_of_invitations");
                userModel = new UserModel(userId, numberOfMessages, numberOfInvitations);
            } else {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userModel;
    }

    public UserModel getUserStatsPaid(int userId) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.connection;
        ResultSet resultSet = null;
        UserModel userModel = new UserModel(userId,0,0);

        try {
            String sql = "SELECT number_of_messages, number_of_invitations FROM public.user_paid WHERE user_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int numberOfMessages = resultSet.getInt("number_of_messages");
                int numberOfInvitations = resultSet.getInt("number_of_invitations");
                userModel = new UserModel(userId, numberOfMessages, numberOfInvitations);
            } else {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userModel;
    }

    public Map<String, Integer> getCourseNameToPriceMap() {
        Map<String, Integer> nameToPriceMap = new HashMap<>();
        Connection connection = DBConnection.connection;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT name, price FROM public.courses";
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                nameToPriceMap.put(name, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nameToPriceMap;
    }

}
