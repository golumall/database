package com.datbaseconnection.database.model;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class Users {

    @Id
    @GeneratedValue
    @Column(name = "contact_id")
    private int contact_id;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "first_name")
    private String first_name;

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
