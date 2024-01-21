package com.coffeeshop.api.service;

import com.coffeeshop.api.model.CatEntity;
import com.coffeeshop.api.model.ShopEntity;
import com.coffeeshop.api.repository.CatRepository;
import com.coffeeshop.api.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final CatRepository catRepository;
    private final ShopRepository shopRepository;

    public List<CatEntity> getCatsByShopId(Long shopId) {
        var cats = catRepository.getCatsByShopId(Math.toIntExact(shopId));
        System.out.println(cats);
        return cats;
    }

    public List<ShopEntity> getShops() {
        return shopRepository.getShops();
    }

}
