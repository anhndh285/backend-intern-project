package com.example.asm_sof3062.model.response;

import com.example.asm_sof3062.entity.GioHang;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GioHangResponse {
    private Long id;
    private String ma;

    private Long idKH;
    private String tenKH;

    private Long idNV;
    private String tenNV;

    private Date ngayTao;
    private Date ngayThanhToan;

    private String tenNguoiNhan;
    private String diaChi;
    private String sdt;
    private Integer tinhTrang;

    public GioHangResponse(GioHang gh) {
        this.id = gh.getId();
        this.ma = gh.getMa();

        if (gh.getKhachHang() != null) {
            this.idKH = gh.getKhachHang().getId();
            this.tenKH = gh.getKhachHang().getHo() + " "
                    + gh.getKhachHang().getTenDem() + " "
                    + gh.getKhachHang().getTen();
        }

        if (gh.getNhanVien() != null) {
            this.idNV = gh.getNhanVien().getId();
            this.tenNV = gh.getNhanVien().getHo() + " "
                    + gh.getNhanVien().getTenDem() + " "
                    + gh.getNhanVien().getTen();
        }

        this.ngayTao = gh.getNgayTao();
        this.ngayThanhToan = gh.getNgayThanhToan();
        this.tenNguoiNhan = gh.getTenNguoiNhan();
        this.diaChi = gh.getDiaChi();
        this.sdt = gh.getSdt();
        this.tinhTrang = gh.getTinhTrang();
    }
}
