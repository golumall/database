package com.datbaseconnection.database.service;

import com.datbaseconnection.database.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

}
