package com.app.esd.esd.Modals.ApiModals;

/**
 * Created by ciqaz on 5/7/17.
 */

public class Results {
    private String id;

    private LexicalEntries[] lexicalEntries;

    private String word;

    private String language;

    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LexicalEntries[] getLexicalEntries() {
        return lexicalEntries;
    }

    public void setLexicalEntries(LexicalEntries[] lexicalEntries) {
        this.lexicalEntries = lexicalEntries;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", lexicalEntries = " + lexicalEntries + ", word = " + word + ", language = " + language + ", type = " + type + "]";
    }
}
