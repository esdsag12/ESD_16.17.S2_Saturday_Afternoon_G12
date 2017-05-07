package com.app.esd.esd.Modals.ApiModals;

/**
 * Created by ciqaz on 5/7/17.
 */

public class Entries {
    private GrammaticalFeatures[] grammaticalFeatures;

    private Senses[] senses;

    private String homographNumber;

    public GrammaticalFeatures[] getGrammaticalFeatures() {
        return grammaticalFeatures;
    }

    public void setGrammaticalFeatures(GrammaticalFeatures[] grammaticalFeatures) {
        this.grammaticalFeatures = grammaticalFeatures;
    }

    public Senses[] getSenses() {
        return senses;
    }

    public void setSenses(Senses[] senses) {
        this.senses = senses;
    }

    public String getHomographNumber() {
        return homographNumber;
    }

    public void setHomographNumber(String homographNumber) {
        this.homographNumber = homographNumber;
    }

    @Override
    public String toString() {
        return "ClassPojo [grammaticalFeatures = " + grammaticalFeatures + ", senses = " + senses + ", homographNumber = " + homographNumber + "]";
    }
}
