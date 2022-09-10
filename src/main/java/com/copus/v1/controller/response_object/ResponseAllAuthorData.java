package com.copus.v1.controller.response_object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAllAuthorData {

    private String bookName;
    private String author;
    private String jipsuStart;
    private String jipsuEnd;
    private String publishYear;

}
