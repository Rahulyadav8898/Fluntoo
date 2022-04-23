package com.fluntoo.zenberry.Model;

public class OnReceiverEvent {
    private String mFilePath;

    public OnReceiverEvent(String filePath) {
        this.mFilePath = filePath;
    }

    public String getFilePath() {
        return mFilePath;
    }
}
