package DTO;

public class PinjamDTO {
    private int id_pinjam;
    private String id_anggota;
    private String id_buku;
    private String nama_anggota;
    private String nama_buku;
    private int jumlah_buku;
    private String tanggal_pinjam;
    private String tanggal_kembali;
    private String deadline;
    private String status;

    public PinjamDTO(int id_pinjam, String id_anggota, String id_buku, String nama_anggota, String nama_buku, int jumlah_buku, String tanggal_pinjam, String deadline, String tanggal_kembali, String status) {
        this.id_pinjam = id_pinjam;
        this.id_anggota = id_anggota;
        this.id_buku = id_buku;
        this.nama_anggota = nama_anggota;
        this.nama_buku = nama_buku;
        this.jumlah_buku = jumlah_buku;
        this.tanggal_pinjam = tanggal_pinjam;
        this.deadline = deadline;
        this.tanggal_kembali = tanggal_kembali;
        this.status = status;
    }

    public int getId_pinjam() { return id_pinjam; }
    public String getId_buku() { return id_buku; }
    public String getId_anggota() { return id_anggota; }
    public String getNama_anggota() { return nama_anggota; }
    public String getNama_buku() { return nama_buku; }
    public int getJumlah_buku() { return jumlah_buku; }
    public String getTanggal_pinjam() { return tanggal_pinjam; }
    public String getTanggal_kembali() { return tanggal_kembali; }
    public String getDeadline() { return deadline; }
    public String getStatus() { return status; }

    public String getNama() { return nama_anggota; }
}