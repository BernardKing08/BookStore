package com.OnlineBookStore.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OnlineBookStore.Model.Roles;

@Repository
public interface RolesRepository extends CrudRepository<Roles, Integer>{
	Roles getByRoleName(String roleName);
}
