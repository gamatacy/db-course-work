package com.coffeeshop.api.service;

import com.coffeeshop.api.model.FillingEntity;
import com.coffeeshop.api.model.PieEntity;
import com.coffeeshop.api.model.PieSizeEntity;
import com.coffeeshop.api.repository.FillingRepository;
import com.coffeeshop.api.repository.PieRepository;
import com.coffeeshop.api.repository.PieSizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PieService {

    private final PieRepository pieRepository;
    private final FillingRepository fillingRepository;
    private final PieSizeRepository pieSizeRepository;

    public void createPie(Long fillingId, Long pieSizeId) {
        pieRepository.createPie(Math.toIntExact(fillingId), Math.toIntExact(pieSizeId));
    }

    public List<FillingEntity> getFillings() {
        return fillingRepository.getFillings();
    }

    public List<PieSizeEntity> getPieSizes() {
        return pieSizeRepository.getPieSizes();
    }

    public List<PieEntity> getPiesWithSale() {
        return pieRepository.getPiesWithSale();
    }

}
