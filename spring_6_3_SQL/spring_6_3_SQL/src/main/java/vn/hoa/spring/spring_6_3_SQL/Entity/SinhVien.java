package vn.hoa.spring.spring_6_3_SQL.Entity;

import jakarta.persistence.*;
import org.hibernate.sql.results.graph.embeddable.AggregateEmbeddableResultGraphNode;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "sinhvien")
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ho_dem" , length = 45)
    private String hoDem;
    @Column(name = "ten" , length = 45)
    private String ten;
    @Column(name = "email" , length = 45)
    private String email;

    public SinhVien(String email, String ten, String hoDem) {
        this.hoDem = hoDem;
        this.ten = ten;
        this.email = email;
    }

    public SinhVien() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoDem() {
        return hoDem;
    }

    public void setHoDem(String hoDem) {
        this.hoDem = hoDem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String  toString() {
        return "SinhVien{" +
                "id=" + id +
                ", hoDem='" + hoDem + '\'' +
                ", ten='" + ten + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
