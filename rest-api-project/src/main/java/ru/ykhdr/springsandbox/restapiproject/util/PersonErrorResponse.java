package ru.ykhdr.springsandbox.restapiproject.util;

import lombok.Data;


public record PersonErrorResponse(String message, long timestamp) {
}
