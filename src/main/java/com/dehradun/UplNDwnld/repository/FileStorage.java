package com.dehradun.UplNDwnld.repository;

import com.dehradun.UplNDwnld.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileStorage extends JpaRepository<FileData, Long> {

   Optional <FileData> findByName(String fileName);
}
