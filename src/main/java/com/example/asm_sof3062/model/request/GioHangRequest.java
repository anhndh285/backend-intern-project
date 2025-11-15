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
public class GioHangRequest {
    @NotBlank(message = "Mã giỏ hàng không được để trống")
    private String ma;

    private Long idKH; // khách hàng
    private Long idNV; // nhân viên

    private Date ngayTao;
    private Date ngayThanhToan;

    private String tenNguoiNhan;
    private String diaChi;
    private String sdt;

    private Integer tinhTrang;
}
