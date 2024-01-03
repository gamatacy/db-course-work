package com.coffeeshop.api.service;

import com.coffeeshop.api.model.AllergenEntity;
import com.coffeeshop.api.repository.AllergenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AllergenService {

    private final AllergenRepository allergenRepository;

    public List<AllergenEntity> getMilkAllergens(Long milkId) {
        return allergenRepository.getMilkAllergens(Math.toIntExact(milkId));
    }

    public List<AllergenEntity> getSyrupAllergens(Long syrupId) {
        return allergenRepository.getSyrupAllergens(Math.toIntExact(syrupId));
    }

    public List<AllergenEntity> getFillingAllergens(Long fillingId) {
        return allergenRepository.getFillingAllergens(Math.toIntExact(fillingId));
    }

}
