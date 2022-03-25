package com.amazonwebapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazonwebapp.entity.AmazonUser;

@Repository
public interface AmazonDAOInterface extends JpaRepository<AmazonUser, String>{

}
