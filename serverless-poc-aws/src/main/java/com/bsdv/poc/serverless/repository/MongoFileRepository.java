package com.bsdv.poc.serverless.repository;

import com.bsdv.poc.serverless.model.File;
import com.bsdv.poc.serverless.model.FileId;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Repository
@Slf4j
@AllArgsConstructor
public class MongoFileRepository implements FileRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public void save(File file) {
        MongoFileDto mongoFileDto = MongoFileDto.fromFileModel(file);
        mongoTemplate.save(mongoFileDto);
    }

    @Override
    public List<File> all() {
        return mongoTemplate.findAll(MongoFileDto.class)
                .stream()
                .map(MongoFileDto::toFileModel)
                .collect(Collectors.toList());
    }

    @Override
    public File byId(FileId fileId) {
        MongoFileDto mongoFileDto = mongoTemplate.findById(fileId.value, MongoFileDto.class);
        if (mongoFileDto == null) {
            throw new NoSuchElementException("File with ID [" + fileId.value.toString() + "] does not exist.");
        }

        return mongoFileDto.toFileModel();
    }

    @Override
    public void delete(FileId fileId) {
        Query query = Query.query(Criteria.where("id").is(fileId.value));
        mongoTemplate.remove(query, MongoFileDto.class);
    }
}
