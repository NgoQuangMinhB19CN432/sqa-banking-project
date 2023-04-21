package com.example.sqaProject.service;

import com.example.sqaProject.entity.Saving;
import java.util.List;

public interface ISavingService {
	List<Saving> findAll();
        void saveAll(List<Saving> c);
}
