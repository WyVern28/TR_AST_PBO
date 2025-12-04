package objek;

public class Admin {
    private String id_admin, nama;

    public Admin(String id_admin, String nama) {
        this.id_admin = id_admin;
        this.nama = nama;
    }

    public String getId_admin() {
        return id_admin;
    }

    public void setId_admin(String id_admin) {
        this.id_admin = id_admin;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
