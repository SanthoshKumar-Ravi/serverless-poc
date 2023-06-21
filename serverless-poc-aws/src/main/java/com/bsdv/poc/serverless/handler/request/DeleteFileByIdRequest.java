package com.bsdv.poc.serverless.handler.request;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteFileByIdRequest {
    private UUID id;
}
