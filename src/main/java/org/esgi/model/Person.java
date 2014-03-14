package org.esgi.model;

import org.hibernate.mapping.Set;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * this class design standard user of the applications
 * @author maxime
 *
 */
@Entity
public class Person implements Serializable {

	// =========================================================================
	// ATTRIBUTES
	// =========================================================================

	private static final long serialVersionUID = 8496087166198616020L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * username is used for user connection
	 */
	@Column(nullable = false, length = 64, unique = true)
	private String username;

	/**
	 * not crypted now
	 */
	@Column(nullable = false, length = 64)
	private String password;

	/**
	 * user email address
	 */
	@Column(nullable = false, length = 128, unique = true)
	private String mail;

	/**
	 * if user can connect to the application
	 */
	private boolean enabled;

	@Column(nullable = false, length = 64)
	private String firstname;

	@Column(nullable = false, length = 64)
	private String lastname;

	@Column(length = 32)
	private String mobilePhone;

    @OneToMany(mappedBy = "person")
    private List<Certificat> certificats;


	// =========================================================================
	// CONSTRUCTORS
	// =========================================================================

	// =========================================================================
	// METHODS
	// =========================================================================

	// =========================================================================
	// OVERRIDES
	// =========================================================================

	// =========================================================================
	// GETTERS & SETTERS
	// =========================================================================

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

    public List<Certificat> getCertificats() {
        return certificats;
    }

    public void setCertificats(List<Certificat> certificats) {
        this.certificats = certificats;
    }
}
