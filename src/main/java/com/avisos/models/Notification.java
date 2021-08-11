package com.avisos.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.lang.Nullable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Document
public class Notification {

    @Id
    private String id;

    private String title;

    @Nullable
    private String description;
    private Link link;
    private String created;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Notification(
            @JsonProperty("title") String title,
            @JsonProperty("description") @Nullable String description,
            @JsonProperty("Link")Link link
    ) {
        this.title = title;
        this.description = description;
        this.link = link;

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        this.created = dateFormat.format(date);
    }
}
