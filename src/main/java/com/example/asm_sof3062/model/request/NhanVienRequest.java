package com.example.asm_sof3062.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class NhanVienRequest {
    @NotBlank(message = "Mã nhân viên không được để trống")
    private String ma;

    @NotBlank(message = "Tên không được để trống")
    private String ten;

    private String tenDem;
    private String ho;

    @NotBlank(message = "Giới tính không được để trống")
    private String gioiTinh;

    private Date ngaySinh;

    private String diaChi;

    private String sdt;

    private String matKhau;

    private Long idCH;
    private Long idCV;
    private Long idGuiBC;

    private Integer trangThai;
}
