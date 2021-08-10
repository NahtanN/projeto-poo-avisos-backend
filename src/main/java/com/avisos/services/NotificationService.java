package com.avisos.services;

import com.avisos.repositories.NotificationRepository;
import com.avisos.models.Notification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    /**
     * Busca todos os documentos no bando de dados e retorna com paginação
     *
     * @return Page<Notification> Objeto com todas as informações referentes a busca no servidor
     * */
    public Page<Notification> getNotifications(Pageable paging) {

        return notificationRepository.findAll(
                paging
        );

    }

    /**
     * Adiciona um novo aviso
     * */
    public void addNotification(Notification notification) {

        try {
            notificationRepository.save(notification);
        } catch (Exception exception) {
            throw exception;
        }

    }

}
