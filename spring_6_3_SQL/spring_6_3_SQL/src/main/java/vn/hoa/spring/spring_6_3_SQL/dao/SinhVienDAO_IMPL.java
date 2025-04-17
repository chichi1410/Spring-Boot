package vn.hoa.spring.spring_6_3_SQL.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.hoa.spring.spring_6_3_SQL.Entity.SinhVien;
import java.util.List;

@Repository
@Transactional // them cai nay de cap nhat tren database
public class SinhVienDAO_IMPL implements SinhVienDAO{

    private EntityManager em;
    @Autowired
    public SinhVienDAO_IMPL(EntityManager em) {
        this.em = em;
    }
    @Override
    public void save(SinhVien sinhVien) {
        em.persist(sinhVien);
    }

    @Override
    public SinhVien getById(int x) {
        return em.find(SinhVien.class, x);
    }


    @Override
    public List<SinhVien> getByName(String ten) {
        String jpql = "select s from SinhVien s where s.ten=:t" ;
       TypedQuery<SinhVien> query = this.em.createQuery(jpql, SinhVien.class);
       query.setParameter("t", ten);
       return query.getResultList();

    }

    @Override
    public List<SinhVien> getAllSinhVien(){
        String jpql = "select s from SinhVien s " ;
        return em.createQuery(jpql, SinhVien.class).getResultList();
    }

}
