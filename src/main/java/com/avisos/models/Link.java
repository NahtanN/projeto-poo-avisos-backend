package com.avisos.models;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Link {

    @Nullable
    private String title;

    @NonNull
    private String link;

}
