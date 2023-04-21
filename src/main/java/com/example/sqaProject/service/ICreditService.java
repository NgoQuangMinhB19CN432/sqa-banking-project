package com.example.sqaProject.service;

import com.example.sqaProject.entity.Credit;
import java.util.List;

public interface ICreditService {
    List<Credit> findAll();
    void saveAll(List<Credit> s);
}
