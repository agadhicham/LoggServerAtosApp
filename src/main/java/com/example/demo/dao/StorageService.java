package com.example.demo.dao;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.File;

public interface StorageService {

    void init();

    void store(MultipartFile file, File file2);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();

}