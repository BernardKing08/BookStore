package com.OnlineBookStore.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Roles extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    private String roleName;
}
