package com.bsdv.poc.serverless.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class FileId {
    public final UUID value;

    public FileId() {
        this(UUID.randomUUID());
    }
}
