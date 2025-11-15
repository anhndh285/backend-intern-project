package com.example.asm_sof3062.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonRequest {
    @NotBlank(message = "Mã hóa đơn không được để trống")
    private String ma;

    private Long idKH;
    private Long idNV;

    private Date ngayTao;
    private Date ngayThanhToan;
    private Date ngayShip;
    private Date ngayNhan;

    private Integer tinhTrang;

    private String tenNguoiNhan;
    private String diaChi;
    private String sdt;
}
