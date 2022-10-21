package com.dilanekamga.Springbootandfeign.dao;

import com.dilanekamga.Springbootandfeign.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole,Long>{
    public AppRole findByRoleName(String roleName);
}
