package com.example.asm_sof3062.controller;

import com.example.asm_sof3062.model.request.SanPhamRequest;
import com.example.asm_sof3062.model.response.SanPhamResponse;
import com.example.asm_sof3062.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sanpham-management")
public class SanPhamController {

    @Autowired
    private SanPhamService service;

    @GetMapping
    public List<SanPhamResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SanPhamResponse detail(@PathVariable("id") Long id) {
        return service.detail(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@Valid @RequestBody SanPhamRequest req) {
        service.add(req);
        return ResponseEntity.ok("Đã thêm sản phẩm thành công!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(
            @PathVariable("id") Long id,
            @Valid @RequestBody SanPhamRequest req) {

        service.update(id, req);
        return ResponseEntity.ok("Đã cập nhật sản phẩm ID: " + id);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> remove(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Đã xóa sản phẩm ID: " + id);
    }

    @GetMapping("/paging")
    public List<SanPhamResponse> paging(
            @RequestParam Integer pageNo,
            @RequestParam Integer pageSize) {

        return service.phanTrang(pageNo, pageSize).getContent();
    }
}