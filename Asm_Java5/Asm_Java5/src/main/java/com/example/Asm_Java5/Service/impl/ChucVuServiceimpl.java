package com.example.Asm_Java5.Service.impl;

import com.example.Asm_Java5.Entity.ChucVu;
import com.example.Asm_Java5.Repository.ChucVuRepository;
import com.example.Asm_Java5.Service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChucVuServiceimpl implements ChucVuService {

    @Autowired
    ChucVuRepository chucVuRepository;

    @Override
    public ChucVu getById(Integer id) {
        return chucVuRepository.findById(id).get();
    }
}
