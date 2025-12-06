package logic;

import java.util.Collections;
import java.util.List;

import DTO.PinjamDTO;
import objek.Anggota;
import objek.Buku;
import repo.AnggotaRepository;
import repo.BukuRepository;
import repo.PinjamRepository;
import repo.UsersRepository;

public class FiturAdmin {

    /**
     * 
     * @param nama -> String
     * @param password -> String
     * @return false -> ga berhasil nambahin anggota
     * @return true -> berhasil nambahin anggota
     */
    public boolean createAnggota(String nama,String password){
        if(nama == null || password == null || nama.isEmpty() || password.isEmpty()) return false;
        UsersRepository userRepo = new UsersRepository();
        boolean isCreateUser = false;
        boolean isCreateAnggota = false;
        AnggotaRepository anggotaRepo = new AnggotaRepository();
        if(userRepo.createUser(password,"anggota")){
            isCreateUser = true;
            if(anggotaRepo.createAnggota(nama)){
                isCreateAnggota = true;
            }
        }
        return isCreateUser && isCreateAnggota;
    }
    
    /**
     * 
     * @return -> list kosong -> ga ketemu anggota sama sekalui
     * @return -> list tipe data Anggota -> ketemu anggota
     */
    public List<Anggota> getAllAnggota(){
        AnggotaRepository anggotaRepo = new AnggotaRepository();
        List<Anggota> listAnggota = anggotaRepo.getAllAnggota();
        if(listAnggota.isEmpty()){
            return Collections.emptyList();
        }
        return listAnggota;
    }

    /**
     * 
     * @param id -> String
     * @param password -> String
     * @return -> true -> kalo password keganti
     * @return -> false -> kalo password gagal keganti
     */
    public boolean updatePassword(String id,String password){
        if(id == null || password == null || id.isEmpty() || password.isEmpty()) return false;
        AnggotaRepository anggotaRepo = new AnggotaRepository();
        return anggotaRepo.changePassword(id, password);
    }

    /**
     * 
     * @param id -> String
     * @return -> true -> kalo anggota berhasil ganti status ke inactive
     * @return -> false -> kalo anggota statusnya ga berhasil keganti
     */
    public boolean deleteAnggota(String id){
        AnggotaRepository anggotaRepo = new AnggotaRepository();
        return anggotaRepo.deleteAnggota(id);
    }

    /**
     * 
     * @param penulis -> String -> di trim dlu bang sebelum ke controller
     * @param nama_buku -> String -> di trim dlu
     * @param stok -> int
     * @param tanggalTerbit -> convert dlu bang dari date jadi String -> di verif dlu ya bang biar format datenya sama
     * -> formatnya yyyy-MM-dd -> kalo 1 di jadiin 01 jangan 1
     * 
     * Ga usah pake id bang inputnya nanti otomatis tak bikinin
     * 
     * @return int == 400 -> input salah
     * @return int == 200 -> penulis dan nama_buku sama + berhasil update stok ke db / berhasil tambah buku ke db
     * @return int == 500 -> gagal tambah buku ke db
     */
    public int createBuku(String penulis,String nama_buku,int stok,String tanggalTerbit){
        if(stok < 0) return 400;
        if(penulis == null || nama_buku == null || tanggalTerbit == null || nama_buku.isEmpty() || tanggalTerbit.isEmpty()) return 400;
        if(penulis.isEmpty()) penulis = "Anonim";
        if(cekAdaBuku(penulis, nama_buku, stok)){
            return 200;
        }
        BukuRepository bukuRepo = new BukuRepository();
        if(bukuRepo.createBuku(penulis, nama_buku, stok, tanggalTerbit)){
            return 200;
        }
        return 500;
    }

    /**
     * Ga usah dipake di view tak verif di controller aja
     * @param penulis -> String
     * @param nama_buku -> String
     * @param stok -> int
     * @return -> true -> kalo ada buku dan berhasil ke update stok buku
     * @return -> false -> kalo ga ada buku yang sama & gagal update
     */
    public boolean cekAdaBuku(String penulis,String nama_buku,int stok){
        BukuRepository bukuRepo = new BukuRepository();
        List<Buku> listBuku = bukuRepo.getAllBuku();
        for(Buku buku : listBuku){
            if(buku.getPenulis().toLowerCase().equals(penulis.toLowerCase()) && buku.getNama_buku().toLowerCase().equals(nama_buku.toLowerCase())){
                return bukuRepo.changeStock(buku.getId_buku(), stok + buku.getStok());   
            }
        }
        return false;
    }

    /**
     * 
     * @return list kosong -> kalo buku ga ada sama sekali di db
     * @return list<Buku> -> buku ketemu
     */
    public List<Buku> getAllBuku(){
        BukuRepository bukuRepo = new BukuRepository();
        List<Buku> listBuku = bukuRepo.getAllBuku();
        if(listBuku.isEmpty() || listBuku == null){
            return Collections.emptyList();
        }
        return listBuku;
    }

    /**
     * 
     * @param id -> String -> di trim dlu bang
     * @param penulis -> String -> di trim dlu bang sebelum ke controller
     * @param nama_buku -> String -> di trim dlu
     * @param stok -> int
     * @param tanggalTerbit -> convert dlu bang dari date jadi String -> di verif dlu ya bang biar format datenya sama
     * -> formatnya yyyy-MM-dd -> kalo 1 di jadiin 01 jangan 1
     * 
     * @return int == 400 -> input salah
     * @return int == 200 -> berhasil udpate buku
     * @return int == 500 -> gagal tambah buku ke db
     */
    public int updateBuku(String id,String penulis,String nama_buku,int stok,String tanggalTerbit){
        if(stok < 0) return 400;
        if(penulis == null || nama_buku == null || tanggalTerbit == null || id == null || id.isEmpty() || nama_buku.isEmpty() || tanggalTerbit.isEmpty()) return 400;
        if(penulis.isEmpty()) penulis = "Anonim";

        BukuRepository bukuRepo = new BukuRepository();

        if(bukuRepo.updateBuku(id, penulis, nama_buku, stok, tanggalTerbit)){
            return 200;
        }
        return 500;
    }

    /**
     * 
     * @param id -> String
     * @return 400 -> salah input id
     * @return 200 -> Berhasil delete buku
     * @return 500 -> gagal delete antara kesalahan db (buku ga ketemu) atau buku lagi ada yang pinjem
     */
    public int deleteBuku(String id){
        if(id == null || id.isEmpty()) return 400;
        BukuRepository bukuRepo = new BukuRepository();
        if(bukuRepo.deleteBuku(id)){
            return 200;
        }
        return 500;
    }

    /**
     * 
     * @return -> list kosong -> kalo ga ada list pinjam sama sekali
     * @return -> List<PinjamDTO> -> kalo ada list
     */
    public List<PinjamDTO> getAllPinjam(){
        PinjamRepository pinjamRepo = new PinjamRepository();
        List<PinjamDTO> listPinjam = pinjamRepo.getAllPinjam();
        if(listPinjam == null || listPinjam.isEmpty()){
            return Collections.emptyList();
        }
        return listPinjam;
    }
}