package com.epam.file;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Andrey_Vaganov on 12/5/2016.
 */
public class MainReader {

    /**
     * Формат даты
     */
    private static final String DATE_FORMAT_PATTERN = "dd.MM.yyyy";

    /**
     * Логгер
     */
    private static final Logger LOGGER = LogManager.getLogger(MainReader.class);

    /**
     * Форматтер, используется для преобразования строк в даты и обратно
     */
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT_PATTERN);


    /**
     * Точка входа в программу
     *
     * @param args
     */
    public static void main(String[] args) {

        try {
            readFile("file.t1xt");
        } catch (MyIOException e) {
            LOGGER.error("catch MyIOException in method 'main'", e);
        } finally {
            LOGGER.debug("exit\n");
        }
    }

    /**
     * Метод для чтения дат из файла
     */
    public static void readFile(String fileName) throws MyIOException {
        //Открываем потоки на чтение из файла
        try (BufferedReader byfReader = new BufferedReader(new FileReader(fileName))) {
            LOGGER.debug("file: '" + fileName + "' correctly open");

            //Читаем первую строку из файла
            String strDate = byfReader.readLine();
            LOGGER.debug("'" + strDate + "' correctly read from file(first read)");

            while (strDate != null) {
                //Преобразуем строку в дату
                Date date = parseDate(strDate);

                if (date != null) {
                    String formattedDate = String.format("%1$td-%1$tm-%1$ty", date);

                    LOGGER.debug("Date: " + strDate + " successfully parsed to " + formattedDate);
                    //Выводим дату в консоль в формате dd-mm-yy
                    System.out.println(formattedDate);

                } else {
                    String message = "'" + strDate + "' is incorrect date";

                    System.out.println(message);
                    LOGGER.debug(message);
                }
                //Читаем следующую строку из файла
                strDate = byfReader.readLine();
                LOGGER.debug("'" + strDate + "' correctly read from file");
            }
        } catch (FileNotFoundException e) {
            String message = "File: '" + fileName + "' not found.";

            System.out.println(message);
            LOGGER.error(message, e);
        } catch (IOException e) {
            LOGGER.error("catch IOException in method 'readFile'", e);
            throw new MyIOException(e);
        }
    }

    /**
     * Метод преобразует строковое представление даты в класс Date
     *
     * @param strDate строковое представление даты
     * @return converted date if strDate is correct or null if incorrect
     */
    public static Date parseDate(String strDate) {
        try {
            if (isDateCorrect(strDate)) {
                return dateFormatter.parse(strDate);
            }
        } catch (ParseException e) {
            // вообще-то сюда попасть не должны
            LOGGER.warn("'" + strDate + "' date matches pattern, but something wrong.", e);
        }
        return null;
    }

    private static boolean isDateCorrect(String strDate) {
        return strDate.matches("[0-3]\\d.[0-1][0-2].\\d{4}");
    }
}
