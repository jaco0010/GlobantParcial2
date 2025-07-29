package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ValidadorEntrada {

    public static LocalDate leerFecha(Scanner sc) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (true) {
            System.out.print("Fecha de vencimiento (YYYY-MM-DD): ");
            String entrada = sc.nextLine();
            try {
                return LocalDate.parse(entrada, formato);
            } catch (DateTimeParseException e) {
                System.out.println("❌ Formato inválido. Ejemplo: 2025-12-31");
            }
        }
    }

    public static int leerEntero(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String linea = sc.nextLine();
            try {
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Ingresa un número entero válido.");
            }
        }
    }
}
