
package com.batov.vkbotmoney.Model.message_new;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MessageModel {

    @SerializedName("group_id")
    @Expose
    private Integer groupId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("event_id")
    @Expose
    private String eventId;
    @SerializedName("v")
    @Expose
    private String v;
    @SerializedName("object")
    @Expose
    private Object object;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
