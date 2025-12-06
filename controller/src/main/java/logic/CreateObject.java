package logic;

import objek.Admin;
import objek.Anggota;
import repo.AdminRepository;
import repo.AnggotaRepository;

public class CreateObject {
    /**
     * 
     * @param id -> String id
     * @return null -> id == null atau id empty
     * @return null -> ga ketemu
     * @return Anggota(model) -> datanya ketemu returnnya Anggota model
     */
    public Anggota createAnggota(String id){
        if(id == null || id.isEmpty()) return null;
        AnggotaRepository anggotaRepo = new AnggotaRepository();
        return anggotaRepo.getAnggotaById(id);
    }

    /**
     * 
     * @param id -> String id
     * @return null -> id == null atau id empty
     * @return null -> ga ketemu
     * @return Admin(model) -> datanya ketemu returnnya Admin model
     */
    public Admin createAdmin(String id){
        if(id == null || id.isEmpty()) return null;
        AdminRepository adminRepo = new AdminRepository();
        return adminRepo.getAdminById(id);
    }
}
