package co.edu.unbosque.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {
    private static final String CONFIG_FILE = "config.properties";
    private static final String NOMBRE_CASA = "nombreCasa";
    private static final String NUMERO_SEDES = "numeroSedes";
    private static final String PRESUPUESTO_TOTAL = "presupuestoTotal";

    public static void guardarConfiguracion(String nombreCasa, int numeroSedes, double presupuestoTotal) {
        Properties properties = new Properties();
        properties.setProperty(NOMBRE_CASA, nombreCasa);
        properties.setProperty(NUMERO_SEDES, String.valueOf(numeroSedes));
        properties.setProperty(PRESUPUESTO_TOTAL, String.valueOf(presupuestoTotal));

        try (FileOutputStream fileOut = new FileOutputStream(CONFIG_FILE)) {
            properties.store(fileOut, "Configuración de la Casa de Apuestas");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String obtenerNombreCasa() {
        return obtenerPropiedad(NOMBRE_CASA);
    }

    public static int obtenerNumeroSedes() {
        return Integer.parseInt(obtenerPropiedad(NUMERO_SEDES));
    }

    public static double obtenerPresupuestoTotal() {
        return Double.parseDouble(obtenerPropiedad(PRESUPUESTO_TOTAL));
    }

    private static String obtenerPropiedad(String propiedad) {
        Properties properties = new Properties();
        try (FileInputStream fileIn = new FileInputStream(CONFIG_FILE)) {
            properties.load(fileIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(propiedad);
    }
}
