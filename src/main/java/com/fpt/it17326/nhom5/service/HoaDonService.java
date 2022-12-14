package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.HoaDon;
import com.fpt.it17326.nhom5.response.HoaDonResponse;
import java.util.List;

/**
 * AowVN_Nyaruko
 *
 */
public interface HoaDonService {

    List<HoaDonResponse> getAll();
    
    List<HoaDon> getAll2();

    HoaDon getOne(String MaHoaDon);

    String add(HoaDon hd);

    String update(HoaDon hd);

    String delete(HoaDon hd);

    public List<HoaDonResponse> getAll1();
}
