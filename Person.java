package Odevler;

import java.time.LocalDateTime;

public class Person {
    private int id;
    private String ad;
    private String soyad;
    private String pozisyon;
    private double maas;
    private LocalDateTime kayitTarihi;

    public Person() {
    }

    public Person(String ad, String soyad, String pozisyon, double maas) {
        this.ad = ad;
        this.soyad = soyad;
        this.pozisyon = pozisyon;
        this.maas = maas;
    }

    public Person(int id, String ad, String soyad, String pozisyon, double maas) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.pozisyon = pozisyon;
        this.maas = maas;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }

    public String getSoyad() { return soyad; }
    public void setSoyad(String soyad) { this.soyad = soyad; }

    public String getPozisyon() { return pozisyon; }
    public void setPozisyon(String pozisyon) { this.pozisyon = pozisyon; }

    public double getMaas() { return maas; }
    public void setMaas(double maas) { this.maas = maas; }

    public LocalDateTime getKayitTarihi() { return kayitTarihi; }
    public void setKayitTarihi(LocalDateTime kayitTarihi) { this.kayitTarihi = kayitTarihi; }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", pozisyon='" + pozisyon + '\'' +
                ", maas=" + maas +
                ", kayitTarihi=" + kayitTarihi +
                '}';
    }
}
