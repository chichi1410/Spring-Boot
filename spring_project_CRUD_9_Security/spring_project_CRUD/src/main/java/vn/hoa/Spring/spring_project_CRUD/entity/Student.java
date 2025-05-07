package vn.hoa.Spring.spring_project_CRUD.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

@Entity
@Table(name = "sinhvien")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ho_dem" , length = 45)
    private String LastName;
    @Column(name = "ten" , length = 45)
    private String FirstName;
    @Column(name = "email" , length = 45)
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
