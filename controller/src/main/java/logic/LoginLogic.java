package logic;

import repo.UsersRepository;

public class LoginLogic {

    /**
     * 
     * @param id -> String id user buat login
     * @return -> null -> kalo id/password == null atau id empty return null
     * @return -> null -> user ga ketemu
     * @return -> String role (anggota/admin) -> user ketemu
     */
    public String getRole(String id,String password){
        if(id == null || password == null || id.isEmpty()) return null;
        UsersRepository userRepo = new UsersRepository();
        return userRepo.getUserRoleById(id,password);
    }
}