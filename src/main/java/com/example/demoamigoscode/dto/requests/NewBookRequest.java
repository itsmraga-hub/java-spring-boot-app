package com.example.demoamigoscode.dto.requests;

import com.example.demoamigoscode.models.Library;

public record NewBookRequest(String title, Library library) {

}