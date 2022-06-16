package com.chiku.dist.dmsrest.role;

import javax.persistence.*;

@Entity
@Table
public class Role {
	@javax.persistence.Id
	@SequenceGenerator(name = "role_sequence", sequenceName = "role_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "role_sequence")
	private Long Id;
	private String roleName;

	public Role() {
		super();
	}

	public Role(Long id, String roleName) {
		Id = id;
		this.roleName = roleName;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role{" +
				"Id=" + Id +
				", roleName='" + roleName + '\'' +
				'}';
	}
}
