package com.batov.vkbotmoney.Service;

import com.batov.vkbotmoney.Dao.BalanceDaoJdbc;
import com.batov.vkbotmoney.Model.UserModel;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Map;

public class BalanceService {

    public void getBalance(int user_id){
        ApiVkService apiVk = new ApiVkService();
        BalanceDaoJdbc balanceDaoJdbc = new BalanceDaoJdbc();
        UserModel userStats = balanceDaoJdbc.getUserStats(user_id);
        UserModel userStatsPaid = balanceDaoJdbc.getUserStatsPaid(user_id);
        Map<String, Integer> courseNameToPriceMap = balanceDaoJdbc.getCourseNameToPriceMap();
        Double message = Double.valueOf(courseNameToPriceMap.get("message"))/1000;
        Double invitation = Double.valueOf(courseNameToPriceMap.get("invitation"))/1000;

        UserModel balance = new UserModel(
                user_id,
                userStats.getNumber_of_messages()-userStatsPaid.getNumber_of_messages(),
                userStats.getNumber_of_invitations()-userStatsPaid.getNumber_of_invitations()
        );
        Double balanceR = (message*balance.getNumber_of_messages()) + (invitation*balance.getNumber_of_invitations());
        DecimalFormat decimalFormat = new DecimalFormat("#.####");

                apiVk.vk("Баланс пользователя @id" + user_id + "\nСообщения - " + balance.getNumber_of_messages() + ".\nПриглашения - " + balance.getNumber_of_invitations() + ".\nЧто равняется " + balanceR + " рублей!");
    }

    public void priceCoin(){
        BalanceDaoJdbc balanceDaoJdbc = new BalanceDaoJdbc();
        ApiVkService apiVk = new ApiVkService();
        Map<String, Integer> courseNameToPriceMap = balanceDaoJdbc.getCourseNameToPriceMap();
        DecimalFormat decimalFormat = new DecimalFormat("#.####");

        Double message = Double.valueOf(courseNameToPriceMap.get("message"))/1000;
        Double invitation = Double.valueOf(courseNameToPriceMap.get("invitation"))/1000;

        String messageStr = decimalFormat.format(message);
        String invitationStr = decimalFormat.format(invitation);
        apiVk.vk("Курс валют \n " + "\uD83C\uDF4B" + " 1 сообщение = " + messageStr
                + " рублей\n " + "\uD83C\uDF4B" + "1 приглашение = " + invitationStr + " рублей");
    }
}
