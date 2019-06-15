package com.example.currencydatabaseserver.repository;

import com.example.currencydatabaseserver.model.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;


@Repository
public interface RateRepository extends JpaRepository<Rate, Integer> {

   // List<Rate> getRatesByDate(String date);
}
