package com.example.asm_sof3062.controller;

import com.example.asm_sof3062.model.request.HoaDonRequest;
import com.example.asm_sof3062.model.response.HoaDonResponse;
import com.example.asm_sof3062.service.HoaDonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoadon-management")
public class HoaDonController {

    @Autowired
    private HoaDonService service;

    @GetMapping
    public List<HoaDonResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public HoaDonResponse detail(@PathVariable("id") Long id) {
        return service.detail(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@Valid @RequestBody HoaDonRequest req) {
        service.add(req);
        return ResponseEntity.ok("Thêm hóa đơn thành công!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(
            @PathVariable("id") Long id,
            @Valid @RequestBody HoaDonRequest req) {

        service.update(id, req);
        return ResponseEntity.ok("Đã cập nhật hóa đơn ID: " + id);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> remove(@PathVariable("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok("Đã xóa hóa đơn ID: " + id);
    }

    @GetMapping("/paging")
    public List<HoaDonResponse> paging(
            @RequestParam Integer pageNo,
            @RequestParam Integer pageSize) {
        return service.phanTrang(pageNo, pageSize).getContent();
    }
}
