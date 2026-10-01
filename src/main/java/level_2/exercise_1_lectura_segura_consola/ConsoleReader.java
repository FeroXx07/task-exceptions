package level_2.exercise_1_lectura_segura_consola;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader {
    private static Scanner scanner = new Scanner(System.in);
    private static final Logger LOGGER = LogManager.getLogger();

    private static void cleanInputBuffer(Scanner input) {
        while (true) {
            try {
                if (!(System.in.available() > 0))
                    break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            input.nextLine();
        }
    }

    // For reasons, I don't understand the cleanInputBuffer() doesn't clean the buffer after numeric mismatch exception
    // and throw exceptions goes infinitely.
    private static void forceCleanInputBuffer(Scanner input) {
        input.nextLine();
    }
    public static byte readByte(String message) {
        byte input = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                LOGGER.info(message);
                input = scanner.nextByte();
                validInput = true;
            } catch (InputMismatchException e) {
                LOGGER.warn("Error de format <<{}>>. Torna-ho a provar.", e.getClass());
            } catch (Exception e){
                LOGGER.error("Unknown exception: ", e);
            }
            finally {
                forceCleanInputBuffer(scanner);
            }
        }
        return input;
    }

    public static int readInt(String message) {
        int input = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                LOGGER.info(message);
                input = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                LOGGER.warn("Error de format <<{}>>. Torna-ho a provar.", e.getClass());
            } catch (Exception e){
                LOGGER.error("Unknown exception: ", e);
            }
            finally {
                forceCleanInputBuffer(scanner);
            }
        }
        return input;
    }

    public static float readFloat(String message) {
        float input = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                LOGGER.info(message);
                input = scanner.nextFloat();
                validInput = true;
            } catch (InputMismatchException e) {
                LOGGER.warn("Error de format <<{}>>. Torna-ho a provar.", e.getClass());
            } catch (Exception e){
                LOGGER.error("Unknown exception: ", e);
            }
            finally {
                forceCleanInputBuffer(scanner);
            }
        }
        return input;
    }

    public static double readDouble(String message) {
        double input = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                LOGGER.info(message);
                input = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                LOGGER.warn("Error de format <<{}>>. Torna-ho a provar.", e.getClass());
            } catch (Exception e){
                LOGGER.error("Unknown exception: ", e);
            }
            finally {
                forceCleanInputBuffer(scanner);
            }
        }
        return input;
    }
}
