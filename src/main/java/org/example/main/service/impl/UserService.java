package org.example.main.service.impl;

import org.example.main.config.DataBaseConfig;
import org.example.main.config.DataBaseConfig;
import org.example.main.model.Friend;
import org.example.main.model.Post;
import org.example.main.model.User;
import org.example.main.service.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


// TODO: 27.06.2023

//  Здесь ты должен реализовать весь CRUD
//  (create -save,
//  read - findById || getAll,
//  update - update,
//  delete - delete) и дополнительные методы!!!
public class UserService implements Service<User> {

    public User followYou(int friendId) {
        return null;
    }

    public List<Friend> getAllFriends() {
        return null;
    }

    public Post sendLike(int postId) {
        return null;
    }

    public List<Post> getNewPosts() {
        return null;
    }

    public Post getPopularPost() {
        return null;
    }

    @Override
    public void createTable() {
        String query = """
                CREATE TABLE IF NOT EXISTS users(
                id SERIAL PRIMARY KEY,
                name VARCHAR ,
                last_Name VARCHAR ,
                email VARCHAR ,
                age INT ,
                address VARCHAR ,
                friend_id INT);
                     """;
        try(Connection connection = DataBaseConfig.getConnection()){
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void save(User user) {
        String query = """
                    
                INSERT INTO users(name, last_Name,email,age,address,friend_id)
                    VALUES (?, ?,?,?,?,?);
                    """;
        try (Connection connection = DataBaseConfig.getConnection(
        )) {
            PreparedStatement preparedStatement = connection.
                    prepareStatement(query);
            preparedStatement
                    .setString(1, user.getName());
            preparedStatement.setString(2, user.getLast_Name());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setInt(6, user.getFriend_id()
            );
            preparedStatement.execute();
            System.out.println(
                    "Your user successfully saved!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User findById(int id) {
            String query = """
                SELECT * FROM users WHERE id = ?;
                """;
            User user = new User();

            try (Connection connection = DataBaseConfig.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    user.setName(resultSet.getString("name"));
                    user.setLast_Name(resultSet.getString("last_name"));
                    user.setAddress(resultSet.getString("address"));
                    user.setEmail(resultSet.getString("email"));
                    user.setFriend_id(resultSet.getInt("friend_Id"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return user;
    }


    @Override
    public List<User> getAll() {
        String query = "SELECT * FROM users";
        List<User> userList = new ArrayList<>();

        try (Connection connection = DataBaseConfig.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLast_Name(resultSet.getString("last_name"));
                user.setAddress(resultSet.getString("address"));
                user.setEmail(resultSet.getString("email"));
                user.setFriend_id(resultSet.getInt("friend_Id"));
                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    @Override
    public void deleteById(int id) {
        String query = "DELETE FROM users WHERE id = ?";

        try (Connection connection = DataBaseConfig.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            System.out.println("user with id:" + id + " successfully deleted!!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }@Override
    public void update(int id, User user) {
        String query = """
                 UPDATE users SET name = ?, last_name = ? WHERE id = ?, email=?,address=?,friend_Id=?/s
                WERE id=?;
                             """;
        try (Connection connection = DataBaseConfig.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLast_Name());
            preparedStatement.setInt(3, user.getId());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setInt(6, user.getFriend_id());
            preparedStatement.execute();
            System.out.println("User with id:" + id + " successfully updated!!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
