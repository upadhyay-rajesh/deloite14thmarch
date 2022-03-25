package com.whatsappboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatsappboot.entity.WhatsappUser;

@Repository
public interface WhatsappDAOInterface extends JpaRepository<WhatsappUser, String>{

}
