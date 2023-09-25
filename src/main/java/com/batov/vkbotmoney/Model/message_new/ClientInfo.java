
package com.batov.vkbotmoney.Model.message_new;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ClientInfo {

    @SerializedName("button_actions")
    @Expose
    private List<String> buttonActions;
    @SerializedName("keyboard")
    @Expose
    private Boolean keyboard;
    @SerializedName("inline_keyboard")
    @Expose
    private Boolean inlineKeyboard;
    @SerializedName("carousel")
    @Expose
    private Boolean carousel;
    @SerializedName("lang_id")
    @Expose
    private Integer langId;

    public List<String> getButtonActions() {
        return buttonActions;
    }

    public void setButtonActions(List<String> buttonActions) {
        this.buttonActions = buttonActions;
    }

    public Boolean getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Boolean keyboard) {
        this.keyboard = keyboard;
    }

    public Boolean getInlineKeyboard() {
        return inlineKeyboard;
    }

    public void setInlineKeyboard(Boolean inlineKeyboard) {
        this.inlineKeyboard = inlineKeyboard;
    }

    public Boolean getCarousel() {
        return carousel;
    }

    public void setCarousel(Boolean carousel) {
        this.carousel = carousel;
    }

    public Integer getLangId() {
        return langId;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

}
