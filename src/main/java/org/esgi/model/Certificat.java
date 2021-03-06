package org.esgi.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Certificat implements Serializable
{
    private static final long serialVersionUID = 8496087166198616020L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 64, unique = true)
    private String compagny;

    @Column(nullable = false)
    private String countryName;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String section;

    @Column(nullable = false)
    private String commonName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private String startValidity;

    @Column(nullable = true)
    private String endValidity;

    @Column(nullable = false)
    private Boolean revocate = false;

    @Column(nullable = false, unique = true)
    private String certName;

    @Column(nullable = true)
    private String content;

    @ManyToOne(optional = false)
    private Person person;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompagny() {
        return compagny;
    }

    public void setCompagny(String compagny) {
        this.compagny = compagny;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStartValidity() {
        return startValidity;
    }

    public void setStartValidity(String startValidity) {
        this.startValidity = startValidity;
    }

    public String getEndValidity() {
        return endValidity;
    }

    public void setEndValidity(String endValidity) {
        this.endValidity = endValidity;
    }

    public Boolean getRevocate() {
        return revocate;
    }

    public void setRevocate(Boolean revocate) {
        this.revocate = revocate;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
