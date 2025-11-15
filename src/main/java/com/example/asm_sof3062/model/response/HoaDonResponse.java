package com.example.asm_sof3062.model.response;

import com.example.asm_sof3062.entity.HoaDon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonResponse {
    private Long id;
    private String ma;

    private Long idKH;
    private String tenKH;

    private Long idNV;
    private String tenNV;

    private Date ngayTao;
    private Date ngayThanhToan;
    private Date ngayShip;
    private Date ngayNhan;

    private Integer tinhTrang;

    private String tenNguoiNhan;
    private String diaChi;
    private String sdt;

    private BigDecimal tongTien;

    public HoaDonResponse(HoaDon hd, BigDecimal tongTien) {
        this.id = hd.getId();
        this.ma = hd.getMa();

        if (hd.getKhachHang() != null) {
            this.idKH = hd.getKhachHang().getId();
            this.tenKH = hd.getKhachHang().getHo() + " "
                    + hd.getKhachHang().getTenDem() + " "
                    + hd.getKhachHang().getTen();
        }

        if (hd.getNhanVien() != null) {
            this.idNV = hd.getNhanVien().getId();
            this.tenNV = hd.getNhanVien().getHo() + " "
                    + hd.getNhanVien().getTenDem() + " "
                    + hd.getNhanVien().getTen();
        }

        this.ngayTao = hd.getNgayTao();
        this.ngayThanhToan = hd.getNgayThanhToan();
        this.ngayShip = hd.getNgayShip();
        this.ngayNhan = hd.getNgayNhan();
        this.tinhTrang = hd.getTinhTrang();
        this.tenNguoiNhan = hd.getTenNguoiNhan();
        this.diaChi = hd.getDiaChi();
        this.sdt = hd.getSdt();
        this.tongTien = tongTien;
    }
}
