package com.batov.vkbotmoney.Service;

import com.batov.vkbotmoney.Dao.MessageDaoJdbc;
import com.batov.vkbotmoney.Model.message_new.MessageModel;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RequestsService {

    public void initialVerification(String request){
        //
        Gson gson = new Gson();
        MessageDaoJdbc messageDaoJdbc = new MessageDaoJdbc();
        MessageModel messageModel = gson.fromJson(request, MessageModel.class);
        BalanceService balanceService = new BalanceService();
        //todo В ОТДЕЛЬНЫЕ МЕТОДЫ РАЗНЕСТИ ВСЕ
        if (messageModel.getType().equals("message_new")) {
            try {
                if (messageModel.getObject().getMessage().getAction().getType().equals("chat_invite_user")) {
                    int userCount = messageDaoJdbc.getUserCount(messageModel.getObject().getMessage().getAction().getMemberId());
                    if(userCount==0) {
                        messageDaoJdbc.createUser(messageModel.getObject().getMessage().getAction().getMemberId(), messageModel.getObject().getMessage().getFromId());
                        messageDaoJdbc.addUserInvitations(messageModel.getObject().getMessage().getFromId());
                    }

                }
            } catch (NullPointerException e) {
            } catch (Exception e) {
                log.error(e.getMessage());
            }
            try {
                if (messageModel.getObject().getMessage().getText().length() > 0) {
                    if (messageDaoJdbc.getUserCount(messageModel.getObject().getMessage().getFromId()) == 0) {
                        messageDaoJdbc.createUser(messageModel.getObject().getMessage().getFromId(), 0);
                    } else {
                        messageDaoJdbc.addUserMessage(messageModel.getObject().getMessage().getFromId());
                        int userIdByReferral = messageDaoJdbc.getUserIdByReferral(messageModel.getObject().getMessage().getFromId());
                        if (userIdByReferral > 0) {
                            messageDaoJdbc.addUserMessage(userIdByReferral);
                        }
                    }

                    if (messageModel.getObject().getMessage().getText().toLowerCase().equals("баланс")){
                        balanceService.getBalance(messageModel.getObject().getMessage().getFromId());
                    }
                    if (messageModel.getObject().getMessage().getText().toLowerCase().equals("курс")){
                        balanceService.priceCoin();
                    }

                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }



        }
    }
}
