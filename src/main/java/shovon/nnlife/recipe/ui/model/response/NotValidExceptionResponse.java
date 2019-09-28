package shovon.nnlife.recipe.ui.model.response;

public class NotValidExceptionResponse {

    private String message;
    private String required;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }
}
