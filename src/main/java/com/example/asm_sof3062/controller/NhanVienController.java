package com.example.asm_sof3062.controller;

import com.example.asm_sof3062.model.request.NhanVienRequest;
import com.example.asm_sof3062.model.response.NhanVienResponse;
import com.example.asm_sof3062.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nhanvien-management")
public class NhanVienController {

    @Autowired
    private NhanVienService service;

    @GetMapping
    public List<NhanVienResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public NhanVienResponse detail(@PathVariable Long id) {
        return service.detail(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@Valid @RequestBody NhanVienRequest req) {
        service.add(req);
        return ResponseEntity.ok("Thêm nhân viên thành công!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(
            @PathVariable Long id,
            @Valid @RequestBody NhanVienRequest req) {

        service.update(id, req);
        return ResponseEntity.ok("Cập nhật nhân viên thành công!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.remove(id);
        return ResponseEntity.ok("Đã xóa nhân viên ID: " + id);
    }

    @GetMapping("/paging")
    public List<NhanVienResponse> paging(
            @RequestParam Integer pageNo,
            @RequestParam Integer pageSize) {

        return service.phanTrang(pageNo, pageSize).getContent();
    }
}
