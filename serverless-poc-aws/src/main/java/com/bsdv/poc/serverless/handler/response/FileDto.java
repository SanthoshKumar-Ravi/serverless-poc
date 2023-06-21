package com.bsdv.poc.serverless.handler.response;

import com.bsdv.poc.serverless.model.File;
import lombok.Data;

@Data
public class FileDto {
    public final String id;
    public final String name;
    public final String content;

    public static FileDto from(File file) {
        return new FileDto(file.id.value.toString(), file.name.value, file.content.value);
    }
}
