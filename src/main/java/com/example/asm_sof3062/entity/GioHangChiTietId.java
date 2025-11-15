package com.example.asm_sof3062.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GioHangChiTietId implements Serializable {

    private Long idGioHang;
    private Long idChiTietSP;
}
