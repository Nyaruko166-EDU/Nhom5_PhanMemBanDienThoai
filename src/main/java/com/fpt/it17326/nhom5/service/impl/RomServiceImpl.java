/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.Rom;
import com.fpt.it17326.nhom5.repository.RomRepository;
import com.fpt.it17326.nhom5.response.RomResponse;
import com.fpt.it17326.nhom5.service.RomService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author youngboizseetinh
 */
@Service
public class RomServiceImpl implements RomService{

    private RomRepository romRepository = new RomRepository();
    
    @Override
    public List<RomResponse> getAll() {
        List<Rom> listRom = romRepository.getAll();
        List<RomResponse> lst = new ArrayList<>();
        for (Rom x : listRom) {
            RomResponse rom = new RomResponse(x);
            lst.add(rom);
        }
        return lst;
    }

    @Override
    public RomResponse getOne(String MaRom) {
        RomResponse rom = new RomResponse(romRepository.getOne(MaRom));
        return rom;
    }

    @Override
    public String add(Rom rom) {
        if (romRepository.add(rom)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(Rom rom) {
        if (romRepository.update(rom)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(Rom rom) {
        if (romRepository.delete(rom)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public List<Rom> getAllRom() {
        return romRepository.getAll();
    }

    @Override
    public List<Rom> getDeletedRom() {
        return romRepository.getAllDeleted();
    }

    @Async
    @Override
    public String restore(Rom rom) {
        rom.setDeleted(false);
        if (romRepository.update(rom)) {
            return "Khôi phục thành công";
        } else {
            return "Khôi phục thất bại";
        }
    }

    @Override
    public List<Rom> searchDeletedRom(String name) {
        return romRepository.searchDeleted(name);
    }
    
}
