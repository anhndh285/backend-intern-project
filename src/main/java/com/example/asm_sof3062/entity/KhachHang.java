package com.example.asm_sof3062.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ma;

    private String ten;

    private String tenDem;

    private String ho;

    private Date ngaySinh;

    private String sdt;

    private String diaChi;

    private String thanhPho;

    private String quocGia;

    private String matKhau;
}
