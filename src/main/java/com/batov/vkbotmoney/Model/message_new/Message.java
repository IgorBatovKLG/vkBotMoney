
package com.batov.vkbotmoney.Model.message_new;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Message {

    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("from_id")
    @Expose
    private Integer fromId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("out")
    @Expose
    private Integer out;
    @SerializedName("action")
    @Expose
    private Action action;
    @SerializedName("attachments")
    @Expose
    private List<Object> attachments;
    @SerializedName("conversation_message_id")
    @Expose
    private Integer conversationMessageId;
    @SerializedName("fwd_messages")
    @Expose
    private List<Object> fwdMessages;
    @SerializedName("important")
    @Expose
    private Boolean important;
    @SerializedName("is_hidden")
    @Expose
    private Boolean isHidden;
    @SerializedName("peer_id")
    @Expose
    private Integer peerId;
    @SerializedName("random_id")
    @Expose
    private Integer randomId;
    @SerializedName("text")
    @Expose
    private String text;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOut() {
        return out;
    }

    public void setOut(Integer out) {
        this.out = out;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public Integer getConversationMessageId() {
        return conversationMessageId;
    }

    public void setConversationMessageId(Integer conversationMessageId) {
        this.conversationMessageId = conversationMessageId;
    }

    public List<Object> getFwdMessages() {
        return fwdMessages;
    }

    public void setFwdMessages(List<Object> fwdMessages) {
        this.fwdMessages = fwdMessages;
    }

    public Boolean getImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public Integer getPeerId() {
        return peerId;
    }

    public void setPeerId(Integer peerId) {
        this.peerId = peerId;
    }

    public Integer getRandomId() {
        return randomId;
    }

    public void setRandomId(Integer randomId) {
        this.randomId = randomId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
