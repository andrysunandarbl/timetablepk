package eu.paniw.timetable.domain.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.apache.wicket.authorization.strategies.role.Roles;
import eu.paniw.timetable.domain.app.UserAppRole;

@Entity
@Table(name = "userDb")
public class User implements Serializable {
	private static final long serialVersionUID = 3384314853843600347L;
	private Long id;
	private String userName;
	private String firstname;
	private String surname;
	private String password;
	private String description;
	private Boolean active = true;
	private UserAppRole userAppRole = UserAppRole.USER;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Enumerated
	public UserAppRole getUserAppRole() {
		return userAppRole;
	}

	public void setUserAppRole(UserAppRole userAppRole) {
		this.userAppRole = userAppRole;
	}

	@Transient
	public String getUnifyName() {
		return firstname + " " + surname + " (" + userName + ")";
	}
	
	@Transient
	private Roles roles;

	@Transient
	public Roles completeRoles() {
		roles = new Roles();
		roles.add(userAppRole.name());
		
		if(!userAppRole.equals(UserAppRole.USER)) {
			roles.add(UserAppRole.USER.name());
		}
		
		return roles;
	}

	@Transient
	public boolean hasRole(String role) {
		return this.roles.hasRole(role);
	}

	@Transient
	public boolean hasAnyRole(Roles roles) {
		return this.roles.hasAnyRole(roles);
	}
}
