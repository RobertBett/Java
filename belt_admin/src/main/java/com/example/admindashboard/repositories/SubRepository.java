package com.example.admindashboard.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.admindashboard.models.Sub;


@Repository
public interface SubRepository extends CrudRepository <Sub, Long> {
		ArrayList<Sub> findByName(String name);
}
