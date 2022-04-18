package log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface ILogger {

    void log(String logText);

    default String getTodayDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    }
}
