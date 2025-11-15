package com.example.asm_sof3062.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@IdClass(GioHangChiTietId.class)
@Table(name = "GioHangChiTiet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GioHangChiTiet {

    @Id
    @Column(name = "IdGioHang")
    private Long idGioHang;

    @Id
    @Column(name = "IdChiTietSP")
    private Long idChiTietSP;

    @ManyToOne
    @JoinColumn(name = "IdGioHang", insertable = false, updatable = false)
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name = "IdChiTietSP", insertable = false, updatable = false)
    private ChiTietSP chiTietSP;

    private Integer soLuong;
    private BigDecimal donGia;
    private BigDecimal donGiaKhiGiam;
}
