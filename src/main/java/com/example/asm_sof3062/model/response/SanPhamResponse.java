package com.example.asm_sof3062.model.response;

import com.example.asm_sof3062.entity.SanPham;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamResponse {
    private Long id;
    private String ma;
    private String ten;

    public SanPhamResponse(SanPham sp) {
        this.id = sp.getId();
        this.ma = sp.getMa();
        this.ten = sp.getTen();
    }
}
