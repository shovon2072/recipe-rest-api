package shovon.nnlife.recipe.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import shovon.nnlife.recipe.ui.model.response.NotValidExceptionResponse;

@ControllerAdvice
public class NotValidExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, InvalidFormatException.class})
    public ResponseEntity<Object> handleCreateRecipeException() {

        NotValidExceptionResponse exception = new NotValidExceptionResponse();
        exception.setMessage("Recipe saving failed!");
        exception.setRequired("title, making_time, serves, ingredients, cost");

        return new ResponseEntity<>(exception, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
