package org.example.main.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@FieldDefaults (level = AccessLevel.PRIVATE)
// TODO: 27.06.2023 ID, NAME, LAST_NAME, EMAIL, AGE, ADDRESS, FRIEND_ID;
public class User {
    int id;
    String name;
    String last_Name;
    String email;
    int age;
    String address;
    int friend_id;

    public User(String name, String last_Name, String email, int age, String address,int friend_id) {
        this.name = name;
        this.last_Name = last_Name;
        this.email = email;
        this.age = age;
        this.address = address;
        this.friend_id = friend_id;
    }
}
