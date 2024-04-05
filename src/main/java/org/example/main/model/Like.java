package org.example.main.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

// TODO: 27.06.2023 ID,
//  LIKED(время когда было поставлено лайк),
//  int postId,
//  int friendId(кто поставил этот лайк).
//  P.s. Не забудь геттеры и сеттеры во всех классах!!!
@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString

public class Like {
    int liked;
    int postId;
    int friendId;
}
