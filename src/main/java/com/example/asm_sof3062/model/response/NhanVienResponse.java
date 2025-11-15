package com.example.asm_sof3062.model.response;

import com.example.asm_sof3062.entity.NhanVien;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienResponse {
    private Long id;
    private String ma;
    private String hoTen;
    private String gioiTinh;
    private String sdt;
    private String diaChi;
    private Integer trangThai;

    private Long idCuaHang;
    private String tenCuaHang;

    private Long idChucVu;
    private String tenChucVu;

    public NhanVienResponse(NhanVien nv) {
        this.id = nv.getId();
        this.ma = nv.getMa();
        this.hoTen = nv.getHo() + " " + nv.getTenDem() + " " + nv.getTen();
        this.gioiTinh = nv.getGioiTinh();
        this.sdt = nv.getSdt();
        this.diaChi = nv.getDiaChi();
        this.trangThai = nv.getTrangThai();

        if (nv.getCuaHang() != null) {
            this.idCuaHang = nv.getCuaHang().getId();
            this.tenCuaHang = nv.getCuaHang().getTen();
        }

        if (nv.getChucVu() != null) {
            this.idChucVu = nv.getChucVu().getId();
            this.tenChucVu = nv.getChucVu().getTen();
        }
    }
}
