package org.example;

import org.example.main.model.User;
import org.example.main.service.impl.UserService;

import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    /**
     * Я В ТЕБЕ ВЕРЮ, У ТЕБЯ ВСЕ ПОЛУЧИТСЯ!!!
     */
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.createTable();
        userService.save(new User("Мубина", "Каримова", "Mubina@.com",
                13, "Кызыл-Кыя", 1));
        userService.save(new User("Асылзат", "Каримова", "Asyl@.com",
                11, "Кызыл-Кыя", 1));
        userService.findById(1);
        userService.update(3, new User("Мухаммет", "Замир уулу", "Muhammet@.com",
                4, "Кызыл-кыя", 1));
        List<User> userList = userService.getAll();
        userList.forEach(System.out::println);
        userService.deleteById(5);
        for (int i = 0; i < 6; i++) {
            userService.deleteById(i);
        }
    }
}
