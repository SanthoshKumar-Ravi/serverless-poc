package com.bsdv.poc.serverless.handler.response;

import com.bsdv.poc.serverless.model.File;
import lombok.Data;

@Data
public class UploadFileResponse {
    private final String id;
    private final String fileName;

    public static UploadFileResponse from(File file) {
        return new UploadFileResponse(file.id.value.toString(), file.name.value);
    }
}
