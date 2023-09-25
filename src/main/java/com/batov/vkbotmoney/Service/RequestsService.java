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
        Gson gson = new Gson();
        MessageDaoJdbc messageDaoJdbc = new MessageDaoJdbc();
        MessageModel messageModel = gson.fromJson(request, MessageModel.class);
        try {
            if (messageModel.getObject().getMessage().getAction().getType().equals("chat_invite_user")) {

                messageDaoJdbc.createUser(messageModel.getObject().getMessage().getAction().getMemberId(), messageModel.getObject().getMessage().getFromId());
                messageDaoJdbc.addUserInvitations(messageModel.getObject().getMessage().getFromId());
                log.info("Приглашение");


            }
        }catch (NullPointerException e){
        } catch (Exception e){
            log.error(e.getMessage());
        }

        try {
            if (messageModel.getObject().getMessage().getText().length()>0){


                if (messageDaoJdbc.getUserCount(messageModel.getObject().getMessage().getFromId()) == 0) {
                    messageDaoJdbc.createUser(messageModel.getObject().getMessage().getFromId(), 0);
                    log.info("Первое сообщение");
                } else {
                    messageDaoJdbc.addUserMessage(messageModel.getObject().getMessage().getFromId());
                    messageDaoJdbc.addReferralMessage(messageModel.getObject().getMessage().getFromId());
                    log.info("увеличили сообщения");
                }

            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
