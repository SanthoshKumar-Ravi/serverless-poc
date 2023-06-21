package com.bsdv.poc.serverless.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class File {
    public final FileId id;
    public final FileName name;
    public final FileContent content;

    public static File create(FileName fileName, FileContent fileContent) {
        return new File(new FileId(), fileName, fileContent);
    }
}
