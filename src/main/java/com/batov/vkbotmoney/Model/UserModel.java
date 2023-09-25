package com.batov.vkbotmoney.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private int user_id;
    private int number_of_messages;
    private int number_of_invitations;
}
