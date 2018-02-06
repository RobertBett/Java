package com.example.imageupload20.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.imageupload20.models.Image;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {

}
