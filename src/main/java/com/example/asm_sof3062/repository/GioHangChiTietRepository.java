package com.example.asm_sof3062.repository;

import com.example.asm_sof3062.entity.GioHangChiTiet;
import com.example.asm_sof3062.entity.GioHangChiTietId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, GioHangChiTietId> {
    List<GioHangChiTiet> findByGioHang_Id(Long idGioHang);

}
