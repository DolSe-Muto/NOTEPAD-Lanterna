package muto.dolse.core;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public final class LoggingHandler {
    public static void setup() throws IOException {

        // ログ保存先
        Path logDirectory = Path.of(
                System.getenv("LOCALAPPDATA"),
                "Muto",
                "NOTEPAD",
                "log"
        );

        // ディレクトリが存在しない場合は作成
        Files.createDirectories(logDirectory);

        // 現在時刻を取得
        String timestamp = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss")
        );

        // ログファイルのパスを作成
        Path logFile = logDirectory.resolve(timestamp + ".log");

        // FileHandlerを作成
        FileHandler fileHandler = new FileHandler(logFile.toString());

        // ログの書式を設定
        fileHandler.setFormatter(new SimpleFormatter());

        // Handlerが受け付けるログレベルを設定
        fileHandler.setLevel(Level.ALL);

        // Root Loggerを取得
        Logger rootLogger = Logger.getLogger("");

        // FileHandlerを登録
        rootLogger.addHandler(fileHandler);

        // Root Loggerが受け付けるログレベルを設定
        rootLogger.setLevel(Level.ALL);
    }
}