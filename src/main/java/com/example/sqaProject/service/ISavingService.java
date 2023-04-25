package com.example.sqaProject.service;

import java.util.List;

import com.example.sqaProject.entity.Saving;

public interface ISavingService {
	List<Saving> findAll();
        List<Saving> findByToDate(String toDate);
}
