/*
 * BaseMessage.java
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 12/23/2016
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.domain.backend.json;

import com.google.gson.annotations.SerializedName;

public class BaseMessage<T> {
    @SerializedName("type")
    private String messageType;
    @SerializedName("data")
    private T messageData;
    @SerializedName("ack")
    private String ackId;

    public BaseMessage() {
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public T getMessageData() {
        return messageData;
    }

    public void setMessageData(T messageData) {
        this.messageData = messageData;
    }

    public String getAckId() {
        return ackId;
    }

    public void setAckId(String ackId) {
        this.ackId = ackId;
    }
}
