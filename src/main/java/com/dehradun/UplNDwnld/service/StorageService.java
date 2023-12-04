package com.dehradun.UplNDwnld.service;

import com.dehradun.UplNDwnld.Util.CompressUtil;
import com.dehradun.UplNDwnld.entity.FileData;
import com.dehradun.UplNDwnld.repository.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@Service
public class StorageService {

    @Autowired
    FileStorage fileStorage;

    public String uploadFile(MultipartFile file) throws IOException {
        FileData myFileData=fileStorage.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .fileData(CompressUtil.compressFile(file.getBytes())).id(2).build()); //please increase the value of id(number of records to be saved in the OracleDB)

        return "File is Uploded:" + file.getOriginalFilename();
    }

    public byte[] downloadFile(String fileName){
        Optional<FileData>dbFileData=fileStorage.findByName(fileName);
        return CompressUtil.decompressFile(dbFileData.get().getFileData());
    }
}
