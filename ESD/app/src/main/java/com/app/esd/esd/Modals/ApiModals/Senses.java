package com.app.esd.esd.Modals.ApiModals;

/**
 * Created by ciqaz on 5/7/17.
 */

public class Senses {
    private String id;

    private String[] definitions;

    private Subsenses[] subsenses;

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

    public Subsenses[] getSubsenses() {
        return subsenses;
    }

    public void setSubsenses(Subsenses[] subsenses) {
        this.subsenses = subsenses;
    }

    public Examples[] getExamples() {
        return examples;
    }

    public void setExamples(Examples[] examples) {
        this.examples = examples;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", definitions = " + definitions + ", subsenses = " + subsenses + ", examples = " + examples + "]";
    }
}
