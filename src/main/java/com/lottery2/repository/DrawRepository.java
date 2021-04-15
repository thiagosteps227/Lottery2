package com.lottery2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lottery2.model.Draw;

public interface DrawRepository extends JpaRepository<Draw, Long> {

}