package logic;

import java.util.Collections;
import java.util.List;

import objek.Anggota;
import repo.AnggotaRepository;
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
}
