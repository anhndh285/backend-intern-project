package com.example.asm_sof3062.model.response;

import com.example.asm_sof3062.entity.HoaDonChiTiet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonChiTietResponse {
    private String tenSanPham;
    private String mauSac;
    private String dongSanPham;
    private Integer soLuong;
    private BigDecimal donGia;
    private BigDecimal thanhTien;

    public HoaDonChiTietResponse(HoaDonChiTiet ct) {
        this.tenSanPham = ct.getChiTietSP().getSanPham().getTen();
        this.mauSac = ct.getChiTietSP().getMauSac().getTen();
        this.dongSanPham = ct.getChiTietSP().getDongSP().getTen();
        this.soLuong = ct.getSoLuong();
        this.donGia = ct.getDonGia();
        this.thanhTien = ct.getDonGia().multiply(new BigDecimal(ct.getSoLuong()));
    }
}
