package com.app.esd.esd.Modals.ApiModals;

/**
 * Created by ciqaz on 5/7/17.
 */

public class Pronunciations {
    private String phoneticSpelling;

    private String phoneticNotation;

    private String[] dialects;

    private String audioFile;

    public String getPhoneticSpelling() {
        return phoneticSpelling;
    }

    public void setPhoneticSpelling(String phoneticSpelling) {
        this.phoneticSpelling = phoneticSpelling;
    }

    public String getPhoneticNotation() {
        return phoneticNotation;
    }

    public void setPhoneticNotation(String phoneticNotation) {
        this.phoneticNotation = phoneticNotation;
    }

    public String[] getDialects() {
        return dialects;
    }

    public void setDialects(String[] dialects) {
        this.dialects = dialects;
    }

    public String getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(String audioFile) {
        this.audioFile = audioFile;
    }

    @Override
    public String toString() {
        return "ClassPojo [phoneticSpelling = " + phoneticSpelling + ", phoneticNotation = " + phoneticNotation + ", dialects = " + dialects + ", audioFile = " + audioFile + "]";
    }
}
