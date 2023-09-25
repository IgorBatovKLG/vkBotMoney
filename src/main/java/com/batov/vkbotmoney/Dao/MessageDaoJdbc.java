package com.batov.vkbotmoney.Dao;

import com.batov.vkbotmoney.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDaoJdbc {


    public void createUser(int userId, int userReferral){
        Connection connection = DBConnection.connection;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "INSERT INTO public.user_vk (user_id, referral, number_of_messages, number_of_invitations) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, userReferral);
            preparedStatement.setInt(3, 1);
            preparedStatement.setInt(4, 0);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUserMessage(int userId){
        Connection connection = DBConnection.connection;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE public.user_vk SET number_of_messages = number_of_messages + 1 where user_id = " + userId;
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUserInvitations(int userId){
        Connection connection = DBConnection.connection;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE public.user_vk SET number_of_invitations = number_of_invitations + 1 where user_id = " + userId;
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void addReferralMessage(int userId){
        Connection connection = DBConnection.connection;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE public.user_vk SET number_of_messages = number_of_messages + 1 where referral = " + userId;
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void addReferralInvitations(int userId){
        Connection connection = DBConnection.connection;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE public.user_vk SET number_of_invitations = number_of_invitations + 1 where referral = " + userId;
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int getUserCount(int userId) {
        int count = 0;
        Connection connection = DBConnection.connection;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT COUNT(*) FROM public.user_vk WHERE user_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, userId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return count;
    }
}
