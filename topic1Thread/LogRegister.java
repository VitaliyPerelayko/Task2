package topic1Thread;

import java.io.*;
import java.time.LocalDateTime;

public class LogRegister {
    private static LogRegister logRegister;
    private static File log;
    private static String path;

    private LogRegister(){
        log = new File(".\\log.txt");
        try {
            log.createNewFile();
            path = log.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  static synchronized LogRegister getLogRegister(){
        if (logRegister==null){
            logRegister = new LogRegister();
        }
        return logRegister;
    }

    public static String getPath() {
        return path;
    }

    public synchronized void aadInfo(String info) {
        try (PrintWriter printWriter =new PrintWriter(
                     new BufferedOutputStream(
                             new FileOutputStream(log,true)))) {
            printWriter.println(LocalDateTime.now());
            printWriter.println(info);
            printWriter.println("\n=============================================\n");

        } catch (FileNotFoundException e) {
            System.out.println("при попытке записать ошибку появилась ошибка\n НЕВЕЗУХА  =))))");
        }
    }

    public static String ExceptionToString(Exception e){
        StringBuilder result = new StringBuilder();
        result.append(e+"\n");
        for (StackTraceElement traceElement : e.getStackTrace()) {
            result.append("\n\tat " + traceElement);
        }
        return result.toString();
    }

}
