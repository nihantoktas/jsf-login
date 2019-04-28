package com.bilgeadam.example.js.login;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Application scoped nesneler uygulama ayağa kalktığında faces context içerisinde oluşturulur.
 * Appliction scoped yazılmasa dahi nesneler application scoped gibi oluşur/davranır.
 */
@ManagedBean(name = "kullaniciBilgileri")
@ApplicationScoped
public class KullaniciBilgileri {

    private String kullaniciAdi;

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }
}
