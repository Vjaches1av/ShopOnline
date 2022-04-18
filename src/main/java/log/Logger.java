package log;

public class Logger implements ILogger {
    private static Logger logger;

    private Logger() {}

    @Override
    public void log(String logText) {
        System.out.println(getTodayDate() + ": " + logText);
    }

    public static Logger getInstance() {
        if (logger == null) {
            return logger = new Logger();
        }

        return logger;
    }
}
