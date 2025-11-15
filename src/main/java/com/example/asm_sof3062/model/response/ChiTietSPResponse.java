package com.example.asm_sof3062.model.response;

import com.example.asm_sof3062.entity.ChiTietSP;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietSPResponse {
    private Long id;

    private Long idSanPham;
    private String tenSanPham;

    private Long idNsx;
    private String tenNsx;

    private Long idMauSac;
    private String tenMauSac;

    private Long idDongSP;
    private String tenDongSP;

    private Integer namBH;
    private String moTa;
    private Integer soLuongTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;

    public ChiTietSPResponse(ChiTietSP ct) {
        this.id = ct.getId();

        if (ct.getSanPham() != null) {
            this.idSanPham = ct.getSanPham().getId();
            this.tenSanPham = ct.getSanPham().getTen();
        }

        if (ct.getNsx() != null) {
            this.idNsx = ct.getNsx().getId();
            this.tenNsx = ct.getNsx().getTen();
        }

        if (ct.getMauSac() != null) {
            this.idMauSac = ct.getMauSac().getId();
            this.tenMauSac = ct.getMauSac().getTen();
        }

        if (ct.getDongSP() != null) {
            this.idDongSP = ct.getDongSP().getId();
            this.tenDongSP = ct.getDongSP().getTen();
        }

        this.namBH = ct.getNamBH();
        this.moTa = ct.getMoTa();
        this.soLuongTon = ct.getSoLuongTon();
        this.giaNhap = ct.getGiaNhap();
        this.giaBan = ct.getGiaBan();
    }
}
