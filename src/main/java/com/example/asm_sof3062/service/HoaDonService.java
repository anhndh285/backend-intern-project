package com.example.asm_sof3062.service;

import com.example.asm_sof3062.entity.HoaDon;
import com.example.asm_sof3062.model.request.HoaDonRequest;
import com.example.asm_sof3062.model.response.HoaDonResponse;
import com.example.asm_sof3062.repository.HoaDonChiTietRepository;
import com.example.asm_sof3062.repository.HoaDonRepository;
import com.example.asm_sof3062.util.MapperUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepo;

    @Autowired
    private HoaDonChiTietRepository ctRepo;

    public List<HoaDonResponse> getAll() {
        return hoaDonRepo.findAll().stream()
                .map(hd -> new HoaDonResponse(hd, tinhTongTien(hd.getId())))
                .toList();
    }

    public HoaDonResponse detail(Long id) {
        HoaDon hd = hoaDonRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hóa đơn!"));

        BigDecimal tongTien = tinhTongTien(id);

        return new HoaDonResponse(hd, tongTien);
    }

    public void add(@Valid HoaDonRequest req) {
        HoaDon hd = MapperUtil.map(req, HoaDon.class);
        hd.setId(null);                 // auto increment
        hd.setNgayTao(new Date());      // tự set ngày tạo
        hoaDonRepo.save(hd);
    }

    public void update(Long id, @Valid HoaDonRequest req) {
        HoaDon hd = hoaDonRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hóa đơn!"));

        hd.setMa(req.getMa());
        hd.setNgayNhan(req.getNgayNhan());
        hd.setNgayShip(req.getNgayShip());
        hd.setNgayThanhToan(req.getNgayThanhToan());
        hd.setTinhTrang(req.getTinhTrang());
        hd.setTenNguoiNhan(req.getTenNguoiNhan());
        hd.setDiaChi(req.getDiaChi());
        hd.setSdt(req.getSdt());

        hoaDonRepo.save(hd);
    }

    public void remove(Long id) {
        ctRepo.deleteAll(ctRepo.findByHoaDon_Id(id));
        hoaDonRepo.deleteById(id);
    }

    public BigDecimal tinhTongTien(Long idHoaDon) {
        return ctRepo.findByHoaDon_Id(idHoaDon)
                .stream()
                .map(ct -> ct.getDonGia()
                        .multiply(BigDecimal.valueOf(ct.getSoLuong())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Page<HoaDonResponse> phanTrang(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<HoaDon> pageHD = hoaDonRepo.findAll(pageable);

        return pageHD.map(hd -> new HoaDonResponse(hd, tinhTongTien(hd.getId())));
    }
}
