package com.example.currencydatabaseserver.repository;

import com.example.currencydatabaseserver.model.Codes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CodesRepository extends JpaRepository<Codes, Integer> {
}
