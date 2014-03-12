package org.esgi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * This class manages the security roles of the applications
 * @author maxime
 *
 */
@Entity
public class Roles implements Serializable {

	// =========================================================================
	// ATTRIBUTES
	// =========================================================================

	private static final long serialVersionUID = 8496087166198616020L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * Role name (ex: ROLE_USER, ROLE_ADMIN)
	 */
	@Column(nullable = false, length = 32)
	private String authority;

	/**
	 * User who have this role
	 */
	@ManyToOne(optional = false)
	private Person person;

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

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
