package com.bilgeadam.example.js.login;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Kullanıcı client üzerinden bir istek'te bulunduğunda
 * nesne faces context içerisinde oluşturulur.Kullanıcıya sunulur ve
 * daha sonra nesne destroy edilir.(yok edilir)
 */
@ManagedBean
@RequestScoped
public class LoginView {

    private String kullaniciAdi;
    private String sifre;

    @ManagedProperty(value = "#{kullaniciBilgileri}")
    private KullaniciBilgileri kullaniciBilgileri;

    public void login(){

        FacesContext facesContext=FacesContext.getCurrentInstance();

        if (kullaniciAdi.equals("admin")&&sifre.equals("12345")){

            facesContext.getExternalContext().getSessionMap().put("kullanıcı",kullaniciAdi);
            kullaniciBilgileri.setKullaniciAdi(kullaniciAdi);

            try {
                facesContext.getExternalContext().redirect("index.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {

            facesContext.addMessage(null,new FacesMessage("Login olunamadı!Bilgilerinizi Kontrol Ediniz."));

        }

    }

    public void  logout(){

        FacesContext facesContext=FacesContext.getCurrentInstance();

        facesContext.getExternalContext().invalidateSession();

        try {
            facesContext.getExternalContext().redirect("login.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public KullaniciBilgileri getKullaniciBilgileri() {
        return kullaniciBilgileri;
    }

    public void setKullaniciBilgileri(KullaniciBilgileri kullaniciBilgileri) {
        this.kullaniciBilgileri = kullaniciBilgileri;
    }
}
