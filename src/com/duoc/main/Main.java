
package com.duoc.main;

import com.duoc.clientes.Cliente;
import com.duoc.cuentas.CuentaBancaria;
import com.duoc.cuentas.CuentaCorriente;
import com.duoc.cuentas.CuentaAhorro;
import com.duoc.cuentas.CuentaCredito;
import com.duoc.servicios.ServicioBanco;

import java.util.Scanner;

// Clase principal para ejecutar el programa del banco
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServicioBanco servicioBanco = new ServicioBanco();

        while (true) {
            System.out.println("--------------------------");
            System.out.println("    Menú Interactivo:");
            System.out.println("--------------------------");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver datos de cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Girar");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            System.out.println("--------------------------");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarCliente(scanner, servicioBanco);
                    break;
                case 2:
                    verDatosCliente(scanner, servicioBanco);
                    break;
                case 3:
                    depositar(scanner, servicioBanco);
                    break;
                case 4:
                    girar(scanner, servicioBanco);
                    break;
                case 5:
                    consultarSaldo(scanner, servicioBanco);
                    break;
                case 6:
                    System.out.println("-------Saliendo del sistema...-------");
                    scanner.close();
                    return;
                default:
                    System.out.println("ALERTA: Opción no válida. Intente nuevamente.");
            }
        }
    }

    // Método para registrar un cliente
    private static void registrarCliente(Scanner scanner, ServicioBanco servicioBanco) {
        System.out.print("Ingrese Rut: ");
        String rut = scanner.nextLine();
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido paterno: ");
        String apellidoPaterno = scanner.nextLine();
        System.out.print("Ingrese apellido materno: ");
        String apellidoMaterno = scanner.nextLine();
        System.out.print("Ingrese domicilio: ");
        String domicilio = scanner.nextLine();
        System.out.print("Ingrese comuna: ");
        String comuna = scanner.nextLine();
        System.out.print("Ingrese teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Seleccione tipo de cuenta (1: Corriente, 2: Ahorro, 3: Crédito): ");
        int tipoCuenta = scanner.nextInt();
        System.out.print("Ingrese número de cuenta corriente: ");
        int numeroCuenta = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Crear la cuenta bancaria según el tipo seleccionado
        CuentaBancaria cuenta;
        if (tipoCuenta == 1) {
            cuenta = new CuentaCorriente(numeroCuenta, 0);
        } else if (tipoCuenta == 2) {
            cuenta = new CuentaAhorro(numeroCuenta, 0);
        } else if (tipoCuenta == 3) {
            cuenta = new CuentaCredito(numeroCuenta, 0);
        } else {
            System.out.println("ALERTA: Tipo de cuenta no válido. Registrando como Cuenta Corriente por defecto.");
            cuenta = new CuentaCorriente(numeroCuenta, 0);
        }

        // Crear el cliente y registrar en el sistema
        Cliente cliente = new Cliente(rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefono, cuenta);
        servicioBanco.registrarCliente(cliente);
    }

    // Método para ver los datos de un cliente
    private static void verDatosCliente(Scanner scanner, ServicioBanco servicioBanco) {
        System.out.print("Ingrese Rut del cliente: ");
        String rut = scanner.nextLine();
        Cliente cliente = servicioBanco.verDatosCliente(rut);
        if (cliente != null) {
            cliente.mostrarInfoCliente();
        } else {
            System.out.println("ALERTA: Cliente no encontrado.");
        }
    }

    // Método para depositar dinero en una cuenta
    private static void depositar(Scanner scanner, ServicioBanco servicioBanco) {
        System.out.print("Ingrese número de cuenta bancaria: ");
        int numeroCuenta = scanner.nextInt();
        System.out.print("Ingrese monto a depositar: ");
        int monto = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        servicioBanco.depositar(numeroCuenta, monto);
    }

    // Método para girar (retirar) dinero de una cuenta
    private static void girar(Scanner scanner, ServicioBanco servicioBanco) {
        System.out.print("Ingrese número de cuenta bancaria: ");
        int numeroCuenta = scanner.nextInt();
        System.out.print("Ingrese monto a girar: ");
        int monto = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        servicioBanco.girar(numeroCuenta, monto);
    }

    // Método para consultar el saldo de una cuenta
    private static void consultarSaldo(Scanner scanner, ServicioBanco servicioBanco) {
        System.out.print("Ingrese número de cuenta bancaria: ");
        int numeroCuenta = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("--------------------------");
        System.out.println(" SALDO CUENTA BANCARIA");
        System.out.println("--------------------------");
        int saldo = servicioBanco.consultarSaldo(numeroCuenta);
        if (saldo != -1) {
            System.out.println("El saldo de la cuenta " + numeroCuenta + " es: " + saldo + " pesos Chilenos.");
        } else {
            System.out.println("ALERTA: Número de cuenta no encontrado.");
        }
    }
}