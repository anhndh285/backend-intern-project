package com.example.asm_sof3062.repository;

import com.example.asm_sof3062.entity.HoaDonChiTiet;
import com.example.asm_sof3062.entity.HoaDonChiTietId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, HoaDonChiTietId> {
    List<HoaDonChiTiet> findByHoaDon_Id(Long idHoaDon);
}
