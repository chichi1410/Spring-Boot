package vn.hoa.spring.spring_6_3_SQL.dao;

import vn.hoa.spring.spring_6_3_SQL.Entity.SinhVien;

import java.util.List;

public interface SinhVienDAO {
    public void save(SinhVien sinhVien);

    public SinhVien getById(int x);

    public List<SinhVien> getAllSinhVien();

    public List<SinhVien> getByName(String name);

}
