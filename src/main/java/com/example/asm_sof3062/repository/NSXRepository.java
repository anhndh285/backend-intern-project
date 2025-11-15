package com.example.asm_sof3062.repository;

import com.example.asm_sof3062.entity.NSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NSXRepository extends JpaRepository<NSX, Long> {
}
