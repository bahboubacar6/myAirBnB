package com.bbb.rbnbperso.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data @NoArgsConstructor
public class ImageModelDTO {

    private Long id;
    private String name;
    private String type;
    private byte[] picByte;

    public ImageModelDTO(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }
}
