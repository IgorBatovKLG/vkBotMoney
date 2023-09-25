
package com.batov.vkbotmoney.Model.message_new;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Object {

    @SerializedName("message")
    @Expose
    private Message message;
    @SerializedName("client_info")
    @Expose
    private ClientInfo clientInfo;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

}
