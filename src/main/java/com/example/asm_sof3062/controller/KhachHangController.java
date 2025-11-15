package com.example.asm_sof3062.controller;

import com.example.asm_sof3062.model.request.KhachHangRequest;
import com.example.asm_sof3062.model.response.KhachHangResponse;
import com.example.asm_sof3062.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khachhang-management")
public class KhachHangController {

    @Autowired
    private KhachHangService service;

    @GetMapping
    public List<KhachHangResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public KhachHangResponse detail(@PathVariable("id") Long id) {
        return service.detail(id);
    }

    @PostMapping("/add")
    public void add(@Valid @RequestBody KhachHangRequest req) {
        service.add(req);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(
            @PathVariable("id") Long id,
            @Valid @RequestBody KhachHangRequest req) {

        service.update(id, req);
        return ResponseEntity.ok("Đã cập nhật khách hàng ID: " + id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> remove(@PathVariable("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok("Đã xóa khách hàng ID: " + id);
    }

    @GetMapping("/paging")
    public List<KhachHangResponse> paging(
            @RequestParam Integer pageNo,
            @RequestParam Integer pageSize) {

        return service.phanTrang(pageNo, pageSize).getContent();
    }
}
