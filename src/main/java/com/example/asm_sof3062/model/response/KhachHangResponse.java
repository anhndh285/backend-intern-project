package com.example.asm_sof3062.model.response;

import com.example.asm_sof3062.entity.KhachHang;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHangResponse {
    private Long id;
    private String ma;
    private String hoTen;
    private String sdt;
    private String diaChi;
    private String thanhPho;
    private String quocGia;

    public KhachHangResponse(KhachHang kh) {
        this.id = kh.getId();
        this.ma = kh.getMa();
        this.hoTen = kh.getHo() + " " + kh.getTenDem() + " " + kh.getTen();
        this.sdt = kh.getSdt();
        this.diaChi = kh.getDiaChi();
        this.thanhPho = kh.getThanhPho();
        this.quocGia = kh.getQuocGia();
    }
}
