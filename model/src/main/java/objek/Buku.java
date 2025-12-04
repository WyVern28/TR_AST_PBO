package objek;

import java.util.Date;

public class Buku {
    private String id_buku, penulis, nama_buku;
    private int stok;
    private Date tanggal_terbit;

    public Buku(String id_buku, String penulis, String nama_buku, int stok, Date tanggal_terbit) {
        this.id_buku = id_buku;
        this.penulis = penulis;
        this.nama_buku = nama_buku;
        this.stok = stok;
        this.tanggal_terbit = tanggal_terbit;
    }

    public String getId_buku() {
        return id_buku;
    }

    public void setId_buku(String id_buku) {
        this.id_buku = id_buku;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getNama_buku() {
        return nama_buku;
    }

    public void setNama_buku(String nama_buku) {
        this.nama_buku = nama_buku;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public Date getTanggal_terbit() {
        return tanggal_terbit;
    }

    public void setTanggal_terbit(Date tanggal_terbit) {
        this.tanggal_terbit = tanggal_terbit;
    }
}
