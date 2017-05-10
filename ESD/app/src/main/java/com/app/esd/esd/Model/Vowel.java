package com.app.esd.esd.Model;

/**
 * Created by Administrator on 08/05/2017.
 */

public class Vowel {
    public int id;
    public String vowel;

    public Vowel(int id, String vowel) {
        this.id = id;
        this.vowel = vowel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVowel() {
        return vowel;
    }

    public void setVowel(String vowel) {
        this.vowel = vowel;
    }
}
