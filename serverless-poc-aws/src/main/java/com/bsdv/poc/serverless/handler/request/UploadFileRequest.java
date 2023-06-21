package com.bsdv.poc.serverless.handler.request;

import lombok.Data;

@Data
public class UploadFileRequest {
    private String fileName;
    private String fileContent;
}
