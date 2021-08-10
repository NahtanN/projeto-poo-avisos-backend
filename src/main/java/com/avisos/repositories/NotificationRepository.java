package com.avisos.repositories;

import com.avisos.models.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository
        extends MongoRepository<Notification, String> {

    // Método que busca todos os elementos e cria a paginação
    Page<Notification> findAll(Pageable pageable);

}
