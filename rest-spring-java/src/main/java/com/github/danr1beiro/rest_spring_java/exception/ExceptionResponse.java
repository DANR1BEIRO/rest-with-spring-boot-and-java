package com.github.danr1beiro.rest_spring_java.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {
}

