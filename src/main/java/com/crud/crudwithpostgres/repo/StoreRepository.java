package com.crud.crudwithpostgres.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.crudwithpostgres.model.StoreName;

public interface StoreRepository extends JpaRepository<StoreName, String>{
}
