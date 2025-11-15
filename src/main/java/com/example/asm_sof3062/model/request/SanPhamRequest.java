package com.example.asm_sof3062.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamRequest {
    @NotBlank(message = "Mã sản phẩm không được để trống")
    private String ma;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String ten;
}
