package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Shoe;

@Repository
public interface ShoeRepo extends JpaRepository<Shoe, Integer>{

}
