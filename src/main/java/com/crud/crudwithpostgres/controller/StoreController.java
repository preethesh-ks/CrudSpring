package com.crud.crudwithpostgres.controller;


import com.crud.crudwithpostgres.model.StoreName;
import com.crud.crudwithpostgres.repo.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreRepository storeRepository;

    @PostMapping("/addstore")
    public String addStore(@RequestBody StoreName store){
        storeRepository.save(store);
        return "Store added successfully";
    }

    @GetMapping("/stores")
    public List<StoreName> getAllStores(){
        return storeRepository.findAll();
    }

    @GetMapping("/store/{id}")
    public StoreName getStore(@PathVariable String id){
        return storeRepository.findById(id).orElse(null);
    }

    @PutMapping("/updateStore/{id}")
    public String updateStore(@PathVariable String id, @RequestBody StoreName store){
        StoreName existingStore = storeRepository.findById(id).orElse(null);
        if(existingStore != null){
            existingStore.setStoreName(store.getStoreName());
            existingStore.setStoreAddress(store.getStoreAddress());
            existingStore.setStoreCity(store.getStoreCity());
            existingStore.setStoreState(store.getStoreState());
            existingStore.setStoreCountry(store.getStoreCountry());
            existingStore.setStorePincode(store.getStorePincode());
            storeRepository.save(existingStore);
            return "Store updated successfully";
        } else {
            return "Store not found";
        }
    }

    @DeleteMapping("/deleteStore/{id}")
    public String deleteStore(@PathVariable String id){
        storeRepository.deleteById(id);
        return "Store deleted successfully";
    }





}
