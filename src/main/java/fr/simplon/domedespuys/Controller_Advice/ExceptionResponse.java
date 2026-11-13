package fr.simplon.domedespuys.Controller_Advice;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Views.ExceptionView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExceptionResponse {

    @JsonView(ExceptionView.Message.class)
    String message;

    @JsonView(ExceptionView.Status.class)
    int status;

    @JsonView(ExceptionView.Name.class)
    String name;
}