package vn.hoa.spring.spring_6_3_SQL.command;

import org.hibernate.internal.util.collections.ArrayHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.hoa.spring.spring_6_3_SQL.Entity.SinhVien;
import vn.hoa.spring.spring_6_3_SQL.dao.SinhVienDAO_IMPL;

import java.util.List;
import java.util.Scanner;

@Configuration
public class MyConfiguration {
    private final SinhVienDAO_IMPL sinhVienDAO_IMPL;
    Scanner sc = new Scanner(System.in);

    public MyConfiguration(SinhVienDAO_IMPL sinhVienDAO_IMPL) {
        this.sinhVienDAO_IMPL = sinhVienDAO_IMPL;
    }

    @Bean
    public CommandLineRunner getRunner(SinhVienDAO_IMPL sVD) {

        return runner -> {

           while(true){

               printMenu();
               int luaChon = sc.nextInt();
               sc.nextLine();
               if(luaChon == 1){
                    addStudent(sVD);

               }else if(luaChon == 2){
                   timSinhVien(sVD);
               }else if(luaChon == 3){
                   timSinhVienBanngTen(sVD);
               }else if(luaChon == 4){
                   getALLSinhVien(sVD);
               }
           }

        };
    }

    public void printMenu(){
        System.out.println("-------------------MENU----------------");
        System.out.println("1. ADD STUDENT");
        System.out.println("2. FIND STUDENT BY ID");
        System.out.println("3. FIND STUDENT BY NAME");
        System.out.println("4. SELECT ALL STUDENT");
        System.out.println("0. EXIT");
    }

    public void addStudent(SinhVienDAO_IMPL sVD){
        System.out.println("nhap ho dem : ");
        String hoDem = sc.nextLine();
        System.out.println("nhap ten : ");
        String ten = sc.nextLine();
        System.out.println("nhap email : ");
        String email = sc.nextLine();
        SinhVien sv = new SinhVien(hoDem, ten, email);
        sVD.save(sv);

    }

    public void timSinhVien(SinhVienDAO_IMPL sVD){
        System.out.println("nhap ma sinh vien can tim : ");
        int id = sc.nextInt();
        SinhVien sv = sinhVienDAO_IMPL.getById(id);
        if(sv == null){
            System.out.println("ko tim thay");
        }else{
            System.out.println(sv.toString());
        }


    }

    public void timSinhVienBanngTen(SinhVienDAO_IMPL sVD){
        System.out.println("nhap ten sinh vien can tim : ");
        String name = sc.nextLine();
        List<SinhVien> sv1 = sVD.getByName(name);
        if(sv1 == null){
            System.out.println("ko tim thay");
        }else{
//            for(SinhVien sv1 : sv){
//                System.out.println(sv1.toString());
//            }
            sv1.forEach(
                    sv->{
                        System.out.println(sv.toString());
                    }
            );
        }
    }

    public void getALLSinhVien(SinhVienDAO_IMPL sVD){
        List<SinhVien> sv = sVD.getAllSinhVien();
        sv.forEach(
                sv1->{
                    System.out.println(sv1.toString());
        }
        );
    }
}
