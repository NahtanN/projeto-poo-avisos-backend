package com.avisos.models;

import com.mongodb.lang.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Link {

    @Nullable
    private String title;

    @NonNull
    private String url;

}
