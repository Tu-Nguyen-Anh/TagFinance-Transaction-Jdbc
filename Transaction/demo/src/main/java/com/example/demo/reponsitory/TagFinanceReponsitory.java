package com.example.demo.reponsitory;

import com.example.demo.data.entity.TagFinance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagFinanceReponsitory extends JpaRepository<TagFinance,Integer> {
}
