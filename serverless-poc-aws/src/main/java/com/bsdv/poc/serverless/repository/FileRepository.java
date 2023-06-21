package com.bsdv.poc.serverless.repository;

import com.bsdv.poc.serverless.model.File;
import com.bsdv.poc.serverless.model.FileId;

import java.util.List;

public interface FileRepository {
    void save(File file);

    List<File> all();

    File byId(FileId fileId);

    void delete(FileId fileId);
}
