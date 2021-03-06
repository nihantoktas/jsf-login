package com.bilgeadam.example.js.login;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 * ViewScoped kullanıcı sayfayı açtıktan sonra nesneyi oluşturur.
 * Kullanıcı sayfayı kapttıktan sonra nesne destroy(yok edilir) edilir.
 */
@ManagedBean
@ViewScoped
public class PageOne {

    private String text;
    private String outputText;

    public void degistirText() {
        outputText = text;
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(outputText));
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOutputText() {
        return outputText;
    }

    public void setOutputText(String outputText) {
        this.outputText = outputText;
    }
}
