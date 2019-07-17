package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Inputs;
@Repository
public interface DemoRepositry extends JpaRepository<Inputs,Integer>{


}