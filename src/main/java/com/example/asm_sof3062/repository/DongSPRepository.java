package com.example.asm_sof3062.repository;

import com.example.asm_sof3062.entity.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DongSPRepository extends JpaRepository<DongSP, Long> {
}
