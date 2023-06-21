package com.bsdv.poc.serverless.service;

import com.bsdv.poc.serverless.model.FileId;
import lombok.Data;

@Data
public class DeleteFileCommand {
    public final FileId fileId;
}
