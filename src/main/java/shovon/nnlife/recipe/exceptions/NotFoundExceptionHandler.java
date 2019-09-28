package shovon.nnlife.recipe.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import shovon.nnlife.recipe.ui.model.response.NotFoundExceptionResponse;

@ControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handleCreateRecipeException(NotFoundException ex) {
        NotFoundExceptionResponse exception = new NotFoundExceptionResponse();
        exception.setMessage(ex.getMessage());

        return new ResponseEntity<>(exception, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
