package com.example.asm_sof3062.service;

import com.example.asm_sof3062.entity.NhanVien;
import com.example.asm_sof3062.model.request.NhanVienRequest;
import com.example.asm_sof3062.model.response.NhanVienResponse;
import com.example.asm_sof3062.repository.NhanVienRepository;
import com.example.asm_sof3062.util.MapperUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository repo;

    public List<NhanVienResponse> getAll() {
        return repo.findAll().stream()
                .map(NhanVienResponse::new)
                .toList();
    }

    public NhanVienResponse detail(Long id) {
        NhanVien nv = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên!"));
        return new NhanVienResponse(nv);
    }

    public void add(@Valid NhanVienRequest req) {
        NhanVien nv = MapperUtil.map(req, NhanVien.class);
        nv.setId(null);   // IDENTITY do DB sinh
        repo.save(nv);
    }

    public void update(Long id, @Valid NhanVienRequest req) {

        NhanVien nv = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên!"));

        nv.setMa(req.getMa());
        nv.setTen(req.getTen());
        nv.setTenDem(req.getTenDem());
        nv.setHo(req.getHo());
        nv.setGioiTinh(req.getGioiTinh());
        nv.setNgaySinh(req.getNgaySinh());
        nv.setDiaChi(req.getDiaChi());
        nv.setSdt(req.getSdt());
        nv.setMatKhau(req.getMatKhau());
        nv.setTrangThai(req.getTrangThai());

        repo.save(nv);
    }

    public void remove(Long id) {
        NhanVien nv = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên để xóa!"));
        repo.delete(nv);
    }

    public Page<NhanVienResponse> phanTrang(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<NhanVien> page = repo.findAll(pageable);
        return page.map(NhanVienResponse::new);
    }
}