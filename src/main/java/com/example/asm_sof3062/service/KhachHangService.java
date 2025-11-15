package com.example.asm_sof3062.service;

import com.example.asm_sof3062.entity.KhachHang;
import com.example.asm_sof3062.model.request.KhachHangRequest;
import com.example.asm_sof3062.model.response.KhachHangResponse;
import com.example.asm_sof3062.repository.KhachHangRepository;
import com.example.asm_sof3062.util.MapperUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService {

    @Autowired
    private KhachHangRepository repo;

    public List<KhachHangResponse> getAll() {
        return repo.findAll()
                .stream()
                .map(KhachHangResponse::new)
                .toList();
    }

    public KhachHangResponse detail(Long id) {
        KhachHang kh = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng!"));

        return new KhachHangResponse(kh);
    }

    public void add(@Valid KhachHangRequest req) {
        KhachHang kh = MapperUtil.map(req, KhachHang.class);
        repo.save(kh);
    }

    public void update(Long id, @Valid KhachHangRequest req) {
        KhachHang kh = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng!"));

        kh.setMa(req.getMa());
        kh.setTen(req.getTen());
        kh.setTenDem(req.getTenDem());
        kh.setHo(req.getHo());
        kh.setNgaySinh(req.getNgaySinh());
        kh.setSdt(req.getSdt());
        kh.setDiaChi(req.getDiaChi());
        kh.setThanhPho(req.getThanhPho());
        kh.setQuocGia(req.getQuocGia());

        repo.save(kh);
    }

    public void remove(Long id) {
        KhachHang kh = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng để xóa!"));

        repo.delete(kh);
    }

    public Page<KhachHangResponse> phanTrang(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<KhachHang> page = repo.findAll(pageable);
        return page.map(KhachHangResponse::new);
    }
}
