package com.dehradun.UplNDwnld.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "UploadedFiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class FileData  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    private String type;
    @Lob
    @Column(name = "fileData")
    private byte[] fileData;

}
