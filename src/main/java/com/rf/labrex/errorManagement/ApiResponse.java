package com.rf.labrex.errorManagement;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiResponse {
    private int status;
    private String path;
    private Map<String,String> errors=new HashMap<>();
    private String message;
    private LocalDateTime dateTime=LocalDateTime.now();
}
