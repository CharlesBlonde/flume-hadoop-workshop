package fr.xebia.techevent.hadoop.job.error.model;

import org.apache.hadoop.io.Text;

/**
 * TODO
 *   - la classe doit impl�menter WritableComparable
 *   - il faut impl�menter les m�thodes obligatoires
 */

public class ErrorInfo {

    private Text error;

    private Text resources;

    private Text hour;

    public ErrorInfo() {
        this.error = new Text();
        this.resources = new Text();
        this.hour = new Text();
    }

    public Text getError() {
        return error;
    }

    public void setError(Text error) {
        this.error = error;
    }

    public Text getResources() {
        return resources;
    }

    public void setResources(Text resources) {
        this.resources = resources;
    }

    public Text getHour() {
        return hour;
    }

    public void setHour(Text hour) {
        this.hour = hour;
    }

}
