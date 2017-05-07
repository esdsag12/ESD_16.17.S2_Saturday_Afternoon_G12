package com.app.esd.esd.Modals.ApiModals;

/**
 * Created by ciqaz on 5/7/17.
 */

public class Subsenses {
    private String id;

    private String[] definitions;

    private Examples[] examples;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getDefinitions() {
        return definitions;
    }

    public void setDefinitions(String[] definitions) {
        this.definitions = definitions;
    }

    public Examples[] getExamples() {
        return examples;
    }

    public void setExamples(Examples[] examples) {
        this.examples = examples;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", definitions = " + definitions + ", examples = " + examples + "]";
    }
}
