package com.example.sqaProject.service.impl;

import com.example.sqaProject.entity.Credit;
import com.example.sqaProject.repository.CreditRepository;
import com.example.sqaProject.service.ICreditService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditService implements ICreditService {
    @Autowired
    private CreditRepository creditRepository;
    @Override
    public List<Credit> findAll() {
        return creditRepository.findAll();
    }
    @Override
    public void saveAll(List<Credit> c) {
        creditRepository.saveAll(c);
    }
}
