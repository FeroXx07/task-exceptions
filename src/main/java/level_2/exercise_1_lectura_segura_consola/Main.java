package level_2.exercise_1_lectura_segura_consola;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();
    static void main(String[] args) {
        byte age = ConsoleReader.readByte("Introdueix la teva edat: ");
    }
}
