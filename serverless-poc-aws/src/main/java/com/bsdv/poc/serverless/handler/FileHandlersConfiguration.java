package com.bsdv.poc.serverless.handler;

import com.bsdv.poc.serverless.handler.request.DeleteFileByIdRequest;
import com.bsdv.poc.serverless.handler.request.RetrieveFileByIdRequest;
import com.bsdv.poc.serverless.handler.request.UploadFileRequest;
import com.bsdv.poc.serverless.handler.response.FileDto;
import com.bsdv.poc.serverless.handler.response.UploadFileResponse;
import com.bsdv.poc.serverless.model.File;
import com.bsdv.poc.serverless.model.FileContent;
import com.bsdv.poc.serverless.model.FileId;
import com.bsdv.poc.serverless.model.FileName;
import com.bsdv.poc.serverless.service.DeleteFileCommand;
import com.bsdv.poc.serverless.service.FileService;
import com.bsdv.poc.serverless.service.UploadFileCommand;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Configuration
@AllArgsConstructor
public class FileHandlersConfiguration {

    private final FileService fileService;

    @Bean
    public Supplier<List<FileDto>> retrieveAllFilesHandler() {
        return () -> fileService.all()
                .stream()
                .map(FileDto::from)
                .collect(Collectors.toList());
    }

    @Bean
    public Function<RetrieveFileByIdRequest, FileDto> retrieveFileByIdHandler() {
        return (RetrieveFileByIdRequest retrieveFileByIdRequest) -> FileDto.from(fileService.byId(new FileId(retrieveFileByIdRequest.getId())));
    }

    @Bean
    public Function<UploadFileRequest, UploadFileResponse> uploadFileHandler() {
        return (UploadFileRequest uploadFileRequest) -> {
            FileName fileName = new FileName(uploadFileRequest.getFileName());
            FileContent fileContent = new FileContent(uploadFileRequest.getFileContent());
            UploadFileCommand command = new UploadFileCommand(fileName, fileContent);
            File uploadedFile = fileService.upload(command);
            return UploadFileResponse.from(uploadedFile);
        };
    }

    @Bean
    public Consumer<DeleteFileByIdRequest> deleteFileByIdHandler() {
        return (DeleteFileByIdRequest request) -> fileService.delete(new DeleteFileCommand(new FileId(request.getId())));
    }
}
