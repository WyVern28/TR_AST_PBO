package objek;

import java.sql.Date;

public class Pinjam {
    private String idPinjam;
    private String idAnggota;
    private String idBuku;
    private int jumlah;
    private Date tanggalPinjam;
    private Date deadline;
    private Date tanggalKembali;
    private StatusPinjam status;

    public Pinjam() {}

    public Pinjam(String idPinjam, String idAnggota, String idBuku, int jumlah,
                  Date tanggalPinjam, Date deadline, Date tanggalKembali, StatusPinjam status) {
        this.idPinjam = idPinjam;
        this.idAnggota = idAnggota;
        this.idBuku = idBuku;
        this.jumlah = jumlah;
        this.tanggalPinjam = tanggalPinjam;
        this.deadline = deadline;
        this.tanggalKembali = tanggalKembali;
        this.status = status;
    }

    public String getIdPinjam() {
        return idPinjam;
    }

    public void setIdPinjam(String idPinjam) {
        this.idPinjam = idPinjam;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(String idAnggota) {
        this.idAnggota = idAnggota;
    }

    public String getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(Date tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(Date tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public StatusPinjam getStatus() {
        return status;
    }

    public void setStatus(StatusPinjam status) {
        this.status = status;
    }
}