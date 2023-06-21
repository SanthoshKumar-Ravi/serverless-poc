package com.bsdv.poc.serverless.service;

import com.bsdv.poc.serverless.model.File;
import com.bsdv.poc.serverless.model.FileId;
import com.bsdv.poc.serverless.repository.FileRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    public List<File> all() {
        log.info("Retrieving all files.");
        return fileRepository.all();
    }

    public File byId(FileId fileId) {
        log.info("Retrieving file with ID [" + fileId.value.toString() + "].");
        return fileRepository.byId(fileId);
    }

    public File upload(UploadFileCommand command) {
        log.info("Received command to upload a file called [" + command.fileName.value + "] with [" + command.fileContent.value.length() + "] length.");
        File file = File.create(command.fileName, command.fileContent);
        fileRepository.save(file);
        log.info("Successfully saved file with ID [" + file.id.value.toString() + "]");
        return file;
    }

    public void delete(DeleteFileCommand command) {
        log.info("Received command to delete a file with ID [" + command.fileId.value.toString() + "].");
        fileRepository.delete(command.fileId);
        log.info("Successfully deleted file with ID [" + command.fileId.value + "]");
    }
}
