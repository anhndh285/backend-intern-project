package com.example.asm_sof3062.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@IdClass(HoaDonChiTietId.class)
@Table(name = "HoaDonChiTiet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonChiTiet {

    @Id
    @Column(name = "IdHoaDon")
    private Long idHoaDon;

    @Id
    @Column(name = "IdChiTietSP")
    private Long idChiTietSP;

    @ManyToOne
    @JoinColumn(name = "IdHoaDon", insertable = false, updatable = false)
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "IdChiTietSP", insertable = false, updatable = false)
    private ChiTietSP chiTietSP;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;
}
