package com.bsdv.poc.serverless.service;

import com.bsdv.poc.serverless.model.FileContent;
import com.bsdv.poc.serverless.model.FileName;
import lombok.Data;

@Data
public class UploadFileCommand {
    public final FileName fileName;
    public final FileContent fileContent;
}
