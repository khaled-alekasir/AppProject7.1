import Model.*;
import View.*;
import Control.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        Utunes utunes = Utunes.getInstance();
        ConsoleView processor = new ConsoleView(utunes);
        processor.run();
    }
}
