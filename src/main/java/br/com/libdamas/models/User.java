package br.com.libdamas.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS_TB")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250)
    private String name;

    @Column(length = 10)
    private String phoneNumber;

    @Column(length = 12)
    private String enrollment;

    @Column()
    private String passsword;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Loan> loans;

    // O Hibernate deve ser capaz de criar uma coluna com o nome "type" como
    // descrito no "@DiscriminatorColumn"
    // @Column(length = 50)
    // private String type;

    public User() {
    }

    public User(String name, String phoneNumber, String enrollment, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.enrollment = enrollment;
        this.passsword = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    // O uso de Strings e getters and setters neste caso é proposital para facilitar o uso.
    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", phoneNumber=" + phoneNumber + ", enrollment=" + enrollment + "]";
    }

}
