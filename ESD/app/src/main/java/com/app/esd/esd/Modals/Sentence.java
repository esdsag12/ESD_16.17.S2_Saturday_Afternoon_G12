package com.app.esd.esd.Modals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ciqaz on 5/9/17.
 */

public class Sentence {
    String text;
    String pronunciation;


    boolean isChoosed = false;

    int flag;
    List<String> answerList = new ArrayList<>();
    int posCorrect;

    int posChoose = -1;

    List<String> url = new ArrayList<>();


    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public boolean isChoosed() {
        return isChoosed;
    }

    public void setChoosed(boolean choosed) {
        isChoosed = choosed;
    }


    public int getPosChoose() {
        return posChoose;
    }

    public void setPosChoose(int posChoose) {
        this.posChoose = posChoose;
    }

    public List<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<String> answerList) {
        this.answerList = answerList;
    }

    public int getPosCorrect() {
        return posCorrect;
    }

    public void setPosCorrect(int posCorrect) {
        this.posCorrect = posCorrect;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public void addUrl(String url) {
        this.url.add(url);
    }


    public Sentence() {
    }

    public Sentence(String text, String pronunciation, int flag, List<String> url, List<String> answerList, int posCorrect) {
        this.text = text;
        this.pronunciation = pronunciation;
        this.flag = flag;
        this.url = url;
        this.answerList = answerList;
        this.posCorrect = posCorrect;
    }

    public Sentence(String text, String pronunciation, int flag, List<String> url) {
        this.text = text;
        this.pronunciation = pronunciation;
        this.flag = flag;
        this.url = url;
    }

    public Sentence(String text, int flag) {
        this.text = text;
        this.flag = flag;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }
}



