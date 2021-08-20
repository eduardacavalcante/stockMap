package com.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
Domain that have the information about the entity. It contains the constructors,
attributes and methods to encapsulate the object
 */
@Entity
@Table
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String dateOfBirth;
    private String password;

    @OneToMany (mappedBy = "user")
    private List<Stock> walletList;

    public User(){

    }

    public User(String firstName, String lastName, String email, String dateOfBirth, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email; }

    public String getDateOfBirth() { return dateOfBirth;}

    public void setDateOfBirth(String dateOfBirth) {this.dateOfBirth = dateOfBirth; }

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public List<Stock> getWalletList() {
        return walletList;
    }

    public void setWalletList(List<Stock> walletList) {
        this.walletList = walletList;
    }
}
