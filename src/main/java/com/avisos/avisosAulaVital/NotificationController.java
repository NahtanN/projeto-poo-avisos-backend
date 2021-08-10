package com.avisos.avisosAulaVital;

import com.avisos.models.Notification;
import com.avisos.services.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    /**
     * Retorna um arquivo JSON com os avisos em ordem decrescente e paginado
     *
     * @param page argumento que define a pagina que deve ser retornada. Valor padrão = 0
     * @return ResponseEntity<> Objeto que retorna o arquivo JSON e um StatusCode
     * */
    @GetMapping
    public ResponseEntity<Map<String, Object>> getNotifications(
            @RequestParam(defaultValue = "0") int page
    ) {

        // Valor definido arbitrariamente
        int pageSize = 2;

        try {

            List<Notification> notifications;

            // Define quantos documentos existirão por página e em qual ordem
            Pageable paging = PageRequest.of(
                    page,
                    pageSize,
                    Sort.by("created").descending()
            );

            // Busca no banco de dados os documentos e os divide de acordo
            // com o que foi definido no "paging"
            Page<Notification> pageNotifications = notificationService.getNotifications(paging);

            // Pega apenas os documentos
            notifications = pageNotifications.getContent();

            // Cria interface que mapeia objetos por chave e valor
            Map<String, Object> response = new HashMap<>();

            response.put("notifications", notifications);
            response.put("currentPage", pageNotifications.getNumber() + 1);
            response.put("totalItems", pageNotifications.getTotalElements());
            response.put("totalPages", pageNotifications.getTotalPages());

            // Retorno da chamada
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception exception) {

            System.out.println(exception);

            // Caso de erro, retorne null e o StatusCode de erro no servidor
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    /**
     * Recebe informações do cliente e adiciona no servidor
     *
     * @return ResponseEntity<> informa o StatusCode da chamada
     * */
    @PostMapping
    public ResponseEntity<String> addNewNotification(@RequestBody Notification notification) {

        try {

            notificationService.addNotification(notification);

            return new ResponseEntity<>("Aviso adicionado!", HttpStatus.OK);

        } catch (Exception exception) {

            System.out.println(exception);

            return new ResponseEntity<>("Falha no servidor!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
