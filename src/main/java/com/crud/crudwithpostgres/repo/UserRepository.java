package com.crud.crudwithpostgres.repo;

import com.crud.crudwithpostgres.model.userDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<userDetails, String>{
}
