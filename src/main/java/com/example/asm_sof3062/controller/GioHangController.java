package com.example.asm_sof3062.controller;

import com.example.asm_sof3062.model.request.GioHangRequest;
import com.example.asm_sof3062.model.response.GioHangResponse;
import com.example.asm_sof3062.service.GioHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/giohang-management")
public class GioHangController {

    @Autowired
    private GioHangService service;

    @GetMapping
    public List<GioHangResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GioHangResponse detail(@PathVariable("id") Long id) {
        return service.detail(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@Valid @RequestBody GioHangRequest req) {
        service.add(req);
        return ResponseEntity.ok("Thêm giỏ hàng thành công!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> remove(@PathVariable("id") Long id) {
        service.remove(id);
        return ResponseEntity.ok("Đã xóa giỏ hàng ID: " + id);
    }

    @GetMapping("/paging")
    public List<GioHangResponse> paging(@RequestParam Integer pageNo,
                                        @RequestParam Integer pageSize) {
        return service.phanTrang(pageNo, pageSize).getContent();
    }
}
