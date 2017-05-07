package com.app.esd.esd.Modals.ApiModals;

/**
 * Created by ciqaz on 5/7/17.
 */

public class OxfordObject {
    private Results[] results;

    private Metadata metadata;

    public Results[] getResults() {
        return results;
    }

    public void setResults(Results[] results) {
        this.results = results;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "ClassPojo [results = " + results + ", metadata = " + metadata + "]";
    }
}
