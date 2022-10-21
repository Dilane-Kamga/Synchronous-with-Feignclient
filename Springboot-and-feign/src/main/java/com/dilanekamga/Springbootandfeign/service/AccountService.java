package com.dilanekamga.Springbootandfeign.service;

import com.dilanekamga.Springbootandfeign.entities.AppRole;
import com.dilanekamga.Springbootandfeign.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole role);
    public void addRoleToUser(String username,String roleName);
    public AppUser findUserByUsername(String username);
}