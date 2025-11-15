package com.example.asm_sof3062.service;

import com.example.asm_sof3062.entity.GioHang;
import com.example.asm_sof3062.model.request.GioHangRequest;
import com.example.asm_sof3062.model.response.GioHangResponse;
import com.example.asm_sof3062.repository.GioHangChiTietRepository;
import com.example.asm_sof3062.repository.GioHangRepository;
import com.example.asm_sof3062.util.MapperUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GioHangService {

    @Autowired
    private GioHangRepository repo;

    @Autowired
    private GioHangChiTietRepository ctRepo;

    public List<GioHangResponse> getAll() {
        return repo.findAll().stream()
                .map(GioHangResponse::new)
                .toList();
    }

    public GioHangResponse detail(Long id) {
        GioHang gh = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giỏ hàng!"));

        return new GioHangResponse(gh);
    }

    public void add(@Valid GioHangRequest req) {
        GioHang gh = MapperUtil.map(req, GioHang.class);
        gh.setId(null);
        gh.setNgayTao(new Date());

        repo.save(gh);
    }

    public void update(Long id, @Valid GioHangRequest req) {

        GioHang gh = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giỏ hàng!"));

        gh.setMa(req.getMa());
        gh.setNgayThanhToan(req.getNgayThanhToan());
        gh.setTenNguoiNhan(req.getTenNguoiNhan());
        gh.setDiaChi(req.getDiaChi());
        gh.setSdt(req.getSdt());
        gh.setTinhTrang(req.getTinhTrang());

        repo.save(gh);
    }

    public void remove(Long id) {

        GioHang gh = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giỏ hàng để xóa!"));

        ctRepo.deleteAll(
                ctRepo.findByGioHang_Id(id)
        );

        repo.delete(gh);
    }

    public Page<GioHangResponse> phanTrang(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<GioHang> page = repo.findAll(pageable);

        return page.map(GioHangResponse::new);
    }
}
