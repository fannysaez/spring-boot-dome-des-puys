package fr.simplon.domedespuys.Views;

public class ExceptionView {
    public interface Message {}
    public interface Status {}
    public interface Name {}

    public interface ExceptionViewFull extends
            Message,
            Status,
            Name {}

}