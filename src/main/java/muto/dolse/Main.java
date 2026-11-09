package muto.dolse;
import com.googlecode.lanterna.graphics.TextGraphics;
import muto.dolse.core.LoggingHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            LoggingHandler.setup();
            logger.log(Level.INFO, "Start NOTEPAD");
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            TextGraphics graphics = screen.newTextGraphics();
            screen.startScreen();
            logger.log(Level.INFO, "Initialized correctly!");

            screen.close();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Something went wrong :(\n", e);
        } finally {
            logger.log(Level.INFO, "NOTEPAD is finished");
        }
    }
}
