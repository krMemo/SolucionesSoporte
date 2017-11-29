package ynk.supports;

import ynk.supports.FormErrorWarningMobile;

public class FormMobile {

    private String title;
    private FormErrorWarningMobile[] errors;
    private FormErrorWarningMobile[] warnings;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setErrors(FormErrorWarningMobile[] errors) {
        this.errors = errors;
    }

    public FormErrorWarningMobile[] getErrors() {
        return errors;
    }

    public void setWarnings(FormErrorWarningMobile[] warnings) {
        this.warnings = warnings;
    }

    public FormErrorWarningMobile[] getWarnings() {
        return warnings;
    }
}