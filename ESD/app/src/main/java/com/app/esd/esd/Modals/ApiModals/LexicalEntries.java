package com.app.esd.esd.Modals.ApiModals;

/**
 * Created by ciqaz on 5/7/17.
 */

public class LexicalEntries {
    private Pronunciations[] pronunciations;

    private String text;

    private Entries[] entries;

    private String language;

    private String lexicalCategory;

    public Pronunciations[] getPronunciations() {
        return pronunciations;
    }

    public void setPronunciations(Pronunciations[] pronunciations) {
        this.pronunciations = pronunciations;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Entries[] getEntries() {
        return entries;
    }

    public void setEntries(Entries[] entries) {
        this.entries = entries;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLexicalCategory() {
        return lexicalCategory;
    }

    public void setLexicalCategory(String lexicalCategory) {
        this.lexicalCategory = lexicalCategory;
    }

    @Override
    public String toString() {
        return "ClassPojo [pronunciations = " + pronunciations + ", text = " + text + ", entries = " + entries + ", language = " + language + ", lexicalCategory = " + lexicalCategory + "]";
    }
}
