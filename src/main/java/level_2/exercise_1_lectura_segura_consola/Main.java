package level_2.exercise_1_lectura_segura_consola;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();
    static void main(String[] args) {
        byte age = ConsoleReader.readByte("Introdueix la teva edat");
        LOGGER.info("Ha introduit: {}", age);

        int valueInt = ConsoleReader.readInt("Introdueix un int");
        LOGGER.info("Ha introduit: {}", valueInt);

        float valueFloat = ConsoleReader.readFloat("Introdueix un float");
        LOGGER.info("Ha introduit: {}", valueFloat);

        double valueDouble = ConsoleReader.readDouble("Introdueix un double");
        LOGGER.info("Ha introduit: {}", valueDouble);

        boolean yesNo = ConsoleReader.readYesNo("Introdueix \"s\" (true) o \"n\" (false)");
        LOGGER.info("Ha introduit: {}", yesNo);

        char c = ConsoleReader.readChar("Introdueix nomes un char");
        LOGGER.info("Ha introduit: {}", c);

        String str = ConsoleReader.readString("Introdueix un String");
        LOGGER.info("Ha introduit: {}", str);

    }
}
