package dictionary.work.exeption;

/**
 * Свое исключение для защиты приложения
 */
public class FileException extends RuntimeException{
    public FileException(String message){
        super(message);
    }
}
