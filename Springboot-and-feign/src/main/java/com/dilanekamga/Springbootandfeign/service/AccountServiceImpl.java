package com.dilanekamga.Springbootandfeign.service;

import com.dilanekamga.Springbootandfeign.dao.RoleRepository;
import com.dilanekamga.Springbootandfeign.dao.UserRepository;
import com.dilanekamga.Springbootandfeign.entities.AppRole;
import com.dilanekamga.Springbootandfeign.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public AppUser saveUser(AppUser user) {
        String hashPW =bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPW);
        return userRepository.save(user);
    }
    @Override
    public AppRole saveRole(AppRole role) {
        return roleRepository.save(role);
    }
    @Override
    public void addRoleToUser(String username, String roleName) {
        AppRole role = roleRepository.findByRoleName(roleName);
        AppUser user =userRepository.findByUsername(username);
        user.getRoles().add(role);
    }
    @Override
    public AppUser findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
