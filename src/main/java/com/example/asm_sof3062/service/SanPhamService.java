package com.example.asm_sof3062.service;

import com.example.asm_sof3062.entity.SanPham;
import com.example.asm_sof3062.model.request.SanPhamRequest;
import com.example.asm_sof3062.model.response.SanPhamResponse;
import com.example.asm_sof3062.repository.SanPhamRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository repo;

    public List<SanPhamResponse> getAll() {
        return repo.findAll().stream()
                .map(SanPhamResponse::new)
                .toList();
    }

    public SanPhamResponse detail(Long id) {
        SanPham sp = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm!"));
        return new SanPhamResponse(sp);
    }

    public void add(@Valid SanPhamRequest req) {
        SanPham sp = new SanPham();
        sp.setMa(req.getMa());
        sp.setTen(req.getTen());
        repo.save(sp);
    }

    public void update(Long id, @Valid SanPhamRequest req) {
        SanPham sp = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm!"));

        sp.setMa(req.getMa());
        sp.setTen(req.getTen());

        repo.save(sp);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Không tồn tại sản phẩm ID: " + id);
        }
        repo.deleteById(id);
    }

    public Page<SanPhamResponse> phanTrang(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<SanPham> pageSP = repo.findAll(pageable);

        return pageSP.map(SanPhamResponse::new);
    }
}
