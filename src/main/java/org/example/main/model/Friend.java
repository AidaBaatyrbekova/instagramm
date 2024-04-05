package org.example.main.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// TODO: 27.06.2023 Здесь тебе достаточно добавить одно поле userId;
//  Знаешь почему?
//  Потому что Я наследовал этот класс от User; P.S. помогает наследование!
@Getter
@Setter
@ToString

public class Friend extends User {
    private int userId;

    public Friend(int userId) {
        this.userId = userId;
    }

    public Friend( String name, String last_Name, String email, int age, String address,int friend_id, int userId) {
        super( name, last_Name, email, age, address,friend_id);
        this.userId = userId;

    }
}
