package objek;

public class Anggota {
    private String id_anggota, nama;
    private boolean status;

    public Anggota(String id_anggota, String nama, boolean status) {
        this.id_anggota = id_anggota;
        this.nama = nama;
        this.status = status;
    }

    public String getId_anggota() {
        return id_anggota;
    }

    public void setId_anggota(String id_anggota) {
        this.id_anggota = id_anggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
