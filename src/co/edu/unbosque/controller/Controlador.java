package co.edu.unbosque.controller;

import co.edu.unbosque.model.CasaDeApuestas;
import co.edu.unbosque.model.EventoDeportivo;
import co.edu.unbosque.model.Sede;
import co.edu.unbosque.model.Apostador;
import co.edu.unbosque.model.Apuesta;
import co.edu.unbosque.view.InterfazUsuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

public class Controlador {

    private CasaDeApuestas casaDeApuestas;
    private InterfazUsuario interfazUsuario;
    private Apostador apostadorActual; 
    

    public Controlador(CasaDeApuestas casaDeApuestas, InterfazUsuario interfazUsuario) {
        this.casaDeApuestas = casaDeApuestas;
        this.interfazUsuario = interfazUsuario;
    }
  
    private void mostrarMenuPrincipal() {
        System.out.println("----- Menú Principal -----");
        System.out.println("1. Gestionar Sedes");
        System.out.println("2. Gestionar Apostadores");
        System.out.println("3. Gestionar Apuestas");
        System.out.println("4. Consultas");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    private String leerEntrada() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            mostrarMenuPrincipal();
            String opcion = leerEntrada();

            switch (opcion) {
                case "1":
                    gestionarMenuSedes();
                    break;
                case "2":
                    gestionarMenuApostadores();
                    break;
                case "3":
                    gestionarMenuApuestas();
                    break;
                case "4":
                    gestionarMenuConsultas();
                    break;
                case "5":
                    salir = true;
                    break;
                default:
                    interfazUsuario.mostrarMensajeError("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
    
    private double obtenerValorApuesta() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de la apuesta: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Por favor, ingrese un valor válido: ");
            scanner.next();
        }

        return scanner.nextDouble();
    }
    private String obtenerNombreSede() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la sede: ");
        return scanner.nextLine();
    }
    

    private String obtenerDia() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el día: ");
        return scanner.nextLine();
    }

    
    private void crearApuestaLoteria(Apostador apostador) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Creando apuesta de Lotería para " + apostador.getNombre());

        // Puedes pedir al usuario que ingrese los números y otros detalles necesarios
        System.out.println("Ingrese cuatro números de Lotería (separados por espacios):");
        String[] numeros = scanner.nextLine().split(" ");

        System.out.println("Ingrese la serie de hasta tres dígitos:");
        String serie = scanner.nextLine();

        // Lógica para guardar la apuesta de Lotería en el archivo correspondiente
        // Puedes utilizar un objeto ApuestaLoteria y luego guardarlo en el archivo

        // Ejemplo de cómo podrías guardar la apuesta en un archivo (ajusta según tu implementación)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("apuestas-loteria.dat", true))) {
            writer.write(apostador.getCedula() + ";" + obtenerNombreSede() + ";" + obtenerDia() + ";" + obtenerValorApuesta() +
                    ";" + "Lotería" + ";" + numeros[0] + " " + numeros[1] + " " + numeros[2] + " " + numeros[3] + ";" + serie);
            writer.newLine();

            System.out.println("Apuesta de Lotería creada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar la apuesta de Lotería: " + e.getMessage());
        }
    }
    private void crearApuestaSuperastro(Apostador apostador) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Creando apuesta de Superastro para " + apostador.getNombre());

        // Puedes pedir al usuario que ingrese los números y otros detalles necesarios
        System.out.println("Ingrese cuatro cifras del 0 al 9 (sin espacios):");
        String cifras = scanner.nextLine();

        System.out.println("Ingrese el signo del zodiaco:");
        String signoZodiaco = scanner.nextLine();

        // Lógica para guardar la apuesta de Superastro en el archivo correspondiente
        // Puedes utilizar un objeto ApuestaSuperastro y luego guardarlo en el archivo

        // Ejemplo de cómo podrías guardar la apuesta en un archivo (ajusta según tu implementación)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("apuestas-superastro.dat", true))) {
            writer.write(apostador.getCedula() + ";" + obtenerNombreSede() + ";" + obtenerDia() + ";" + obtenerValorApuesta() +
                    ";" + "Superastro" + ";" + cifras + ";" + signoZodiaco);
            writer.newLine();

            System.out.println("Apuesta de Superastro creada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar la apuesta de Superastro: " + e.getMessage());
        }
    }
    private void crearApuestaBaloto(Apostador apostador) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Creando apuesta de Baloto para " + apostador.getNombre());

        // Puedes pedir al usuario que ingrese los números y otros detalles necesarios
        Set<Integer> numerosBaloto = new HashSet<>();

        while (numerosBaloto.size() < 6) {
            System.out.println("Ingrese un número entre 1 y 45:");
            int numero = scanner.nextInt();

            if (numero >= 1 && numero <= 45) {
                numerosBaloto.add(numero);
            } else {
                System.out.println("Número no válido. Debe estar entre 1 y 45.");
            }
        }

        // Lógica para guardar la apuesta de Baloto en el archivo correspondiente
        // Puedes utilizar un objeto ApuestaBaloto y luego guardarlo en el archivo

        // Ejemplo de cómo podrías guardar la apuesta en un archivo (ajusta según tu implementación)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("apuestas-baloto.dat", true))) {
            StringBuilder numerosBalotoString = new StringBuilder();
            for (int numero : numerosBaloto) {
                numerosBalotoString.append(numero).append(" ");
            }

            writer.write(apostador.getCedula() + ";" + obtenerNombreSede() + ";" + obtenerDia() + ";" + obtenerValorApuesta() +
                    ";" + "Baloto" + ";" + numerosBalotoString.toString().trim());
            writer.newLine();

            System.out.println("Apuesta de Baloto creada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar la apuesta de Baloto: " + e.getMessage());
        }
    }

    private void crearApuestaBetPlay(Apostador apostador) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Creando apuesta de BetPlay para " + apostador.getNombre());

        // Lógica para obtener la lista de partidos y resultados del usuario
        // Puedes cargar la lista de partidos desde un archivo o utilizar cualquier otro método de entrada

        // Aquí se muestra un ejemplo básico
        System.out.println("Ingrese los resultados para los 14 partidos (1 para local, 2 para visitante, 0 para empate):");

        int[] resultados = new int[14];
        for (int i = 0; i < 14; i++) {
            System.out.print("Partido " + (i + 1) + ": ");
            resultados[i] = scanner.nextInt();
        }

        // Lógica para guardar la apuesta de BetPlay en el archivo correspondiente
        // Puedes utilizar un objeto ApuestaBetPlay y luego guardarlo en el archivo

        // Ejemplo de cómo podrías guardar la apuesta en un archivo (ajusta según tu implementación)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("apuestas-betplay.dat", true))) {
            StringBuilder resultadosString = new StringBuilder();
            for (int resultado : resultados) {
                resultadosString.append(resultado).append(" ");
            }

            writer.write(apostador.getCedula() + ";" + obtenerNombreSede() + ";" + obtenerDia() + ";" + obtenerValorApuesta() +
                    ";" + "BetPlay" + ";" + resultadosString.toString().trim());
            writer.newLine();

            System.out.println("Apuesta de BetPlay creada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar la apuesta de BetPlay: " + e.getMessage());
        }
    }
    private void crearApuestaChance(Apostador apostador) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Creando apuesta de Chance para " + apostador.getNombre());

        // Lógica para obtener los números del usuario
        // Puedes generar números aleatorios o permitir al usuario ingresarlos

        // Aquí se muestra un ejemplo básico
        System.out.println("Ingrese cuatro números para la apuesta de Chance:");

        int[] numerosChance = new int[4];
        for (int i = 0; i < 4; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numerosChance[i] = scanner.nextInt();
        }

        // Lógica para guardar la apuesta de Chance en el archivo correspondiente
        // Puedes utilizar un objeto ApuestaChance y luego guardarlo en el archivo

        // Ejemplo de cómo podrías guardar la apuesta en un archivo (ajusta según tu implementación)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("apuestas-chance.dat", true))) {
            StringBuilder numerosChanceString = new StringBuilder();
            for (int numero : numerosChance) {
                numerosChanceString.append(numero).append(" ");
            }

            writer.write(apostador.getCedula() + ";" + obtenerNombreSede() + ";" + obtenerDia() + ";" + obtenerValorApuesta() +
                    ";" + "Chance" + ";" + numerosChanceString.toString().trim());
            writer.newLine();

            System.out.println("Apuesta de Chance creada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar la apuesta de Chance: " + e.getMessage());
        }
    }
    public void gestionarMenuSedes() {
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("----- Menú de Gestión de Sedes -----");
            System.out.println("1. Crear nueva sede");
            System.out.println("2. Modificar datos de una sede");
            System.out.println("3. Mostrar sedes");
            System.out.println("4. Guardar cambios y salir");
            System.out.println("------------------------------------");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de la lectura de la opción

            switch (opcion) {
                case 1:
                    crearNuevaSede();
                    break;
                case 2:
                    modificarDatosSede();
                    break;
                case 3:
                    mostrarSedes();
                    break;
                case 4:
                    guardarCambiosSedes();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 4);
    }
    private List<Sede> sedes = new ArrayList<>();

    private void crearNuevaSede() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la ubicación (localidad) de la nueva sede:");
        String ubicacion = scanner.nextLine();

        System.out.println("Ingrese el número de empleados de la nueva sede:");
        int numeroEmpleados = scanner.nextInt();

        Sede nuevaSede = new Sede("Sede Ejemplo", "Dirección de la Sede", 100);
        sedes.add(nuevaSede);

        System.out.println("Nueva sede creada correctamente.");
    }
    public Sede buscarSedePorUbicacion(String ubicacion, List<Sede> sedes) {
        for (Sede sede : sedes) {
            if (sede.obtenerUbicacion().equalsIgnoreCase(ubicacion)) {
                return sede; // Se encontró la sede por ubicación
            }
        }
        return null; // No se encontró ninguna sede con la ubicación especificada
    }
    private void modificarDatosSede() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la ubicación (localidad) de la sede a modificar:");
        String ubicacion = scanner.nextLine();

        Sede sedeAModificar = buscarSedePorUbicacion(ubicacion, sedes);

        if (sedeAModificar != null) {
            System.out.println("Ingrese el nuevo número de empleados:");
            int nuevoNumeroEmpleados = scanner.nextInt();
            sedeAModificar.setNumeroEmpleados(nuevoNumeroEmpleados);

            System.out.println("Datos de la sede modificados correctamente.");
        } else {
            System.out.println("Sede no encontrada. Verifique la ubicación e intente de nuevo.");
        }
    }
    private void mostrarSedes() {
        System.out.println("----- Listado de Sedes -----");
        for (Sede sede : sedes) {
            System.out.println("Ubicación: " + sede.obtenerUbicacion() + ", Número de empleados: " + sede.getNumeroEmpleados());
        }
        System.out.println("----------------------------");
    }
    private void guardarCambiosSedes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sedes.dat"))) {
            for (Sede sede : sedes) {
                writer.write(sede.obtenerUbicacion() + ";" + sede.getNumeroEmpleados());
                writer.newLine();
            }
            System.out.println("Cambios guardados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar los cambios en sedes.dat: " + e.getMessage());
        }
    }
    
    public void gestionarMenuApostadores() {
        boolean salir = false;

        while (!salir) {
            interfazUsuario.mostrarMenuApostadores();
            String opcion = interfazUsuario.leerEntrada();

            switch (opcion) {
                case "1":
                    agregarApostador();
                    break;
                case "2":
                    mostrarApostadores();
                    break;
                case "3":
                    actualizarApostador();
                    break;
                case "4":
                    borrarApostador();
                    break;
                case "5":
                    salir = true;
                    break;
                default:
                    interfazUsuario.mostrarMensajeError("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
    public void mostrarApostadores() {
        // Implementación del método para mostrar apostadores
        // Puedes utilizar JOptionPane u otro componente según tus necesidades
        // Ejemplo:
        System.out.println("Mostrando apostadores...");
    }
    
    public void mostrarMenuApostadores() {
        String mensaje = "Seleccione una opción:\n1. Realizar apuesta\n2. Ver historial de apuestas\n3. Salir";
        int opcion = JOptionPane.showOptionDialog(null, mensaje, "Menú de Apostadores", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        // Aquí puedes manejar la opción seleccionada
        switch (opcion) {
            case 0:
                // Lógica para realizar apuesta
                // Puedes llamar a otros métodos del controlador u otras clases según sea necesario
                realizarApuesta();
                break;
            case 1:
                // Lógica para ver historial de apuestas
                // verHistorialApuestas();
                break;
            case 2:
                // Lógica para salir
                System.exit(0);
                break;
            default:
                // Opción no válida
                mostrarMensajeError("Opción no válida");
                break;
        }
    }
    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void mostrarMensaje(String mensaje) {
        // Utiliza la interfaz de usuario para mostrar el mensaje
        interfazUsuario.mostrarMensaje(mensaje);
    }
    private void realizarApuesta() {
    	 // Obtener información necesaria para la apuesta
        double valorApuesta = obtenerValorApuesta();
        EventoDeportivo evento = seleccionarEvento();

        // Realizar la apuesta
        if (apostadorActual != null && evento != null) {
            Apuesta apuesta = new Apuesta(apostadorActual, evento, valorApuesta);
            // Aquí puedes manejar la apuesta, por ejemplo, almacenarla en una lista de apuestas
            // apuestas.add(apuesta);
            mostrarMensaje("¡Apuesta realizada con éxito!");
        } else {
            mostrarMensajeError("No se pudo realizar la apuesta. Asegúrate de tener un apostador seleccionado y un evento válido.");
        }
    }
   
    private EventoDeportivo seleccionarEvento() {
        // Implementa la lógica para permitir al usuario seleccionar un evento deportivo
        // Puedes mostrar una lista de eventos y permitir que el usuario elija uno
        // En este ejemplo, simplemente devolvemos un evento fijo para fines de demostración
        return new EventoDeportivo("Partido de fútbol", null, null);
    }

    

    private void agregarApostador() {
        // Implementa la lógica para agregar un apostador.
    	try {
    	    interfazUsuario.mostrarMensaje("Ingrese el nombre completo del apostador:");
    	    String nombre = interfazUsuario.leerEntrada();

    	    interfazUsuario.mostrarMensaje("Ingrese la cédula del apostador (solo mayores de edad):");
    	    String cedula = interfazUsuario.leerEntrada();

    	    interfazUsuario.mostrarMensaje("Ingrese la sede donde el apostador esté jugando:");
    	    String sede = interfazUsuario.leerEntrada();

    	    interfazUsuario.mostrarMensaje("Ingrese la dirección del apostador:");
    	    String direccion = interfazUsuario.leerEntrada();

    	    interfazUsuario.mostrarMensaje("Ingrese el número de celular del apostador:");
    	    String celular = interfazUsuario.leerEntrada();

    	    if (validarCedula(cedula)) {
    	        Apostador apostador = new Apostador(nombre, cedula, sede, direccion, celular);
    	        casaDeApuestas.agregarApostador(apostador);
    	        interfazUsuario.mostrarMensaje("Apostador agregado correctamente.");
    	    } else {
    	        interfazUsuario.mostrarMensajeError("La cédula ingresada no es válida para un mayor de edad.");
    	    }
    	} catch (Exception e) {
    	    interfazUsuario.mostrarMensajeError("Error al procesar la entrada del usuario. Por favor, inténtelo de nuevo.");
    	}
    }

    private boolean validarCedula(String cedula) {
        // Verificar si la longitud es la correcta
        if (cedula.length() != 10) {
            return false;
        }

        // Verificar si todos los caracteres son dígitos numéricos
        if (!cedula.matches("\\d{10}")) {
            return false;
        }

        // Verificar la regla de verificación (por ejemplo, el último dígito)
        // Aquí deberías incluir la lógica específica según las reglas de tu país

        // En este ejemplo, simplemente retornamos true si pasa las verificaciones anteriores
        return true;
    }
    	private void actualizarApostador() {
    	    interfazUsuario.mostrarMensaje("Ingrese la cédula del apostador que desea actualizar:");
    	    String cedula = interfazUsuario.leerEntrada();

    	    Apostador apostador = casaDeApuestas.buscarApostadorPorCedula(cedula);

    	    if (apostador != null) {
    	        interfazUsuario.mostrarMensaje("Ingrese el nuevo número de celular del apostador:");
    	        String nuevoCelular = interfazUsuario.leerEntrada();

    	        apostador.setCelular(nuevoCelular);
    	        interfazUsuario.mostrarMensaje("Apostador actualizado correctamente.");
    	    } else {
    	        interfazUsuario.mostrarMensajeError("Apostador no encontrado.");
    	    }
    	}


    	private void borrarApostador() {
    	    interfazUsuario.mostrarMensaje("Ingrese la cédula del apostador que desea borrar:");
    	    String cedula = interfazUsuario.leerEntrada();

    	    Apostador apostador = casaDeApuestas.buscarApostadorPorCedula(cedula);

    	    if (apostador != null) {
    	        casaDeApuestas.borrarApostador(apostador);
    	        interfazUsuario.mostrarMensaje("Apostador borrado correctamente.");
    	    } else {
    	        interfazUsuario.mostrarMensajeError("Apostador no encontrado.");
    	    }
    	}
    	
    private void gestionarMenuApuestas() {
        boolean salir = false;

        while (!salir) {
            interfazUsuario.mostrarMenuApuestas();
            String opcion = interfazUsuario.leerEntrada();

            switch (opcion) {
                case "1":
                    crearApuesta();
                    break;
                case "2":
                    mostrarApuestas();
                    break;
                case "3":
                    actualizarApuesta();
                    break;
                case "4":
                    borrarApuesta();
                    break;
                case "5":
                    salir = true;
                    break;
                default:
                    interfazUsuario.mostrarMensajeError("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    public void crearApuesta() {
        System.out.println("Seleccione el tipo de juego:");
        System.out.println("a) Lotería");
        System.out.println("b) Superastro");
        System.out.println("c) Baloto");
        System.out.println("d) BetPlay");
        System.out.println("e) Chance");

        char opcionJuego = scanner.next().charAt(0);
        scanner.nextLine(); // Limpiar el buffer después de leer el carácter

        switch (opcionJuego) {
            case 'a':
                crearApuestaLoteria();
                break;
            case 'b':
                crearApuestaSuperastro();
                break;
            case 'c':
                crearApuestaBaloto();
                break;
            case 'd':
                crearApuestaBetPlay();
                break;
            case 'e':
                crearApuestaChance();
                break;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
        }
    }

    private void mostrarApuestas(String tipoJuego) {
        String nombreArchivo = obtenerNombreArchivoApuestas(tipoJuego);

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("Apuestas de " + tipoJuego + ":");
            
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de apuestas: " + e.getMessage());
        }
    }

    private String obtenerNombreArchivoApuestas(String tipoJuego) {
        // Ajusta la lógica para obtener el nombre del archivo según el tipo de juego
        return "apuestas-" + tipoJuego.toLowerCase() + ".dat";
    }

  
    private void actualizarApuesta(String tipoJuego) {
        String nombreArchivo = obtenerNombreArchivoApuestas(tipoJuego);

        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo + ".tmp"));
            try (Scanner scanner = new Scanner(System.in)) {
				System.out.println("Ingrese el número de la apuesta que desea actualizar:");
				int numeroApuestaActualizar = scanner.nextInt();

				String linea;
				boolean apuestaEncontrada = false;

				while ((linea = br.readLine()) != null) {
				    String[] datosApuesta = linea.split(";"); // Ajusta el delimitador según tu formato
				    int numeroApuesta = Integer.parseInt(datosApuesta[0]);

				    if (numeroApuesta == numeroApuestaActualizar) {
				        // Apuesta encontrada, permite al usuario actualizar la información
				        System.out.println("Apuesta encontrada. Ingrese los nuevos datos:");

				        // Aquí puedes solicitar al usuario la nueva información y actualizar los datos

				        apuestaEncontrada = true;
				    }

				    bw.write(linea + System.lineSeparator());
				}

				br.close();
				bw.close();

				// Renombrar el archivo temporal al original
				if (apuestaEncontrada) {
				    File archivoOriginal = new File(nombreArchivo);
				    File archivoTemporal = new File(nombreArchivo + ".tmp");
				    archivoTemporal.renameTo(archivoOriginal);

				    System.out.println("Apuesta actualizada exitosamente.");
				} else {
				    System.out.println("Apuesta no encontrada.");
				}
			}

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al actualizar la apuesta: " + e.getMessage());
        }
    }
    private void borrarApuesta() {
        // Implementa la lógica para borrar una apuesta.
    }

    private void gestionarMenuConsultas() {
        boolean salir = false;

        while (!salir) {
            interfazUsuario.mostrarMenuConsultas();
            String opcion = interfazUsuario.leerEntrada();

            switch (opcion) {
                case "1":
                    listarClientesPorSede();
                    break;
                case "2":
                    calcularValorTotalApostado();
                    break;
                case "3":
                    detallarApuestasPorClienteYSede();
                    break;
                case "4":
                    totalApostadoPorSedeYTipoJuego();
                    break;
                case "5":
                    salir = true;
                    break;
                default:
                    interfazUsuario.mostrarMensajeError("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    private void listarClientesPorSede() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la sede para listar clientes:");
        String sede = scanner.nextLine();

        List<Apostador> apostadoresEnSede = obtenerApostadoresEnSede(sede);

        if (!apostadoresEnSede.isEmpty()) {
            System.out.println("Clientes en la sede " + sede + ":");
            for (Apostador apostador : apostadoresEnSede) {
                System.out.println(apostador);
            }
        } else {
            System.out.println("No hay clientes en la sede " + sede + ".");
        }
    }

    private List<Apostador> obtenerApostadoresEnSede(String sede) {
        List<Apostador> apostadoresEnSede = new ArrayList<>();

        for (Apostador apostador : listaApostadores) {
            if (apostador.getSede().equalsIgnoreCase(sede)) {
                apostadoresEnSede.add(apostador);
            }
        }

        return apostadoresEnSede;
    }

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        // Agrega algunos apostadores de ejemplo a la lista
        controlador.listaApostadores.add(new Apostador("Juan", "123456789", "SedeA", "Direccion1", "1234567890"));
        controlador.listaApostadores.add(new Apostador("Maria", "987654321", "SedeB", "Direccion2", "9876543210"));

        // Llama al método para listar clientes por sede
        controlador.listarClientesPorSede();
    }


    private void calcularValorTotalApostado(String cedulaCliente) {
        double valorTotalApostado = 0.0;
        Scanner scanner = new Scanner(System.in);

        // Recorre los archivos de apuestas para el tipo de juego que desees
        String[] tiposJuego = {"Lotería", "Superastro", "Baloto", "BetPlay", "Chance"};

        for (String tipoJuego : tiposJuego) {
            String nombreArchivo = obtenerNombreArchivoApuestas(tipoJuego);

            try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
                String linea;

                while ((linea = br.readLine()) != null) {
                    String[] datosApuesta = linea.split(";"); // Ajusta el delimitador según tu formato
                    String cedulaApostador = datosApuesta[1];
                    double valorApuesta = Double.parseDouble(datosApuesta[3]); // Ajusta según la posición del valor en tus datos

                    if (cedulaApostador.equals(cedulaCliente)) {
                        valorTotalApostado += valorApuesta;
                    }
                }

            } catch (IOException | NumberFormatException e) {
                System.err.println("Error al calcular el valor total apostado: " + e.getMessage());
            }
        }

        System.out.println("Valor total apostado por el cliente " + cedulaCliente + ": $" + valorTotalApostado);
    }

    private void detallarApuestasPorClienteYSede() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cédula del cliente:");
        String cedulaCliente = scanner.nextLine();

        System.out.println("Ingrese el nombre de la sede:");
        String nombreSede = scanner.nextLine();

        String[] tiposJuego = {"Lotería", "Superastro", "Baloto", "BetPlay", "Chance"};

        for (String tipoJuego : tiposJuego) {
            String nombreArchivo = obtenerNombreArchivoApuestas(tipoJuego);

            try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
                String linea;

                while ((linea = br.readLine()) != null) {
                    String[] datosApuesta = linea.split(";"); // Ajusta el delimitador según tu formato
                    String cedulaApostador = datosApuesta[1];
                    String sedeApuesta = obtenerSedeApuesta(datosApuesta[0]); // Ajusta según la posición del nombre de la sede

                    if (cedulaApostador.equals(cedulaCliente) && sedeApuesta.equalsIgnoreCase(nombreSede)) {
                        // Imprime o almacena la información de la apuesta detallada
                        System.out.println("Detalles de la apuesta:");
                        System.out.println("Tipo de juego: " + tipoJuego);
                        System.out.println("Cédula del apostador: " + cedulaApostador);
                        System.out.println("Sede de la apuesta: " + sedeApuesta);
                        // ... (otros detalles de la apuesta)

                        System.out.println("--------------");
                    }
                }

            } catch (IOException e) {
                System.err.println("Error al detallar las apuestas: " + e.getMessage());
            }
        }
    }
    

    private void totalApostadoPorSedeYTipoJuego() {
        Map<String, Map<String, Double>> totalApostado = new HashMap<>(); // Mapa para almacenar el total por sede y tipo de juego

        String[] tiposJuego = {"Lotería", "Superastro", "Baloto", "BetPlay", "Chance"};

        for (String tipoJuego : tiposJuego) {
            String nombreArchivo = obtenerNombreArchivoApuestas(tipoJuego);

            try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
                String linea;

                while ((linea = br.readLine()) != null) {
                    String[] datosApuesta = linea.split(";"); // Ajusta el delimitador según tu formato
                    String sedeApuesta = obtenerSedeApuesta(datosApuesta[0]); // Ajusta según la posición del nombre de la sede
                    double valorApuesta = Double.parseDouble(datosApuesta[3]); // Ajusta según la posición del valor en tus datos

                    // Calcula el total apostado por sede y tipo de juego
                    totalApostado.computeIfAbsent(sedeApuesta, k -> new HashMap<>());
                    totalApostado.get(sedeApuesta).merge(tipoJuego, valorApuesta, Double::sum);
                }

            } catch (IOException | NumberFormatException e) {
                System.err.println("Error al calcular el total apostado: " + e.getMessage());
            }
        }

        // Imprime o maneja el resultado
        System.out.println("Total apostado por sede y tipo de juego:");
        for (String sede : totalApostado.keySet()) {
            for (String tipoJuego : totalApostado.get(sede).keySet()) {
                System.out.println("Sede: " + sede + ", Tipo de juego: " + tipoJuego +
                        ", Total apostado: $" + totalApostado.get(sede).get(tipoJuego));
            }
        }
    }
    

}
