package com.bsdv.poc.serverless.repository;

import com.bsdv.poc.serverless.model.File;
import com.bsdv.poc.serverless.model.FileContent;
import com.bsdv.poc.serverless.model.FileId;
import com.bsdv.poc.serverless.model.FileName;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("File")
@AllArgsConstructor
@Data
public class MongoFileDto {

    @Id
    private UUID id;
    private String name;
    private String content;

    public static MongoFileDto fromFileModel(File file) {
        return new MongoFileDto(file.id.value, file.name.value, file.content.value);
    }

    public File toFileModel() {
        return new File(new FileId(id), new FileName(name), new FileContent(content));
    }
}
