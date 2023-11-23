package com.example.report.controllers.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Command {
    private String command;
    private Integer playersNumber;
}
