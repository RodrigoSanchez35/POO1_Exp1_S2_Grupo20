
package com.duoc.servicios;

import com.duoc.clientes.Cliente;
import com.duoc.cuentas.CuentaBancaria;

import java.util.HashMap;
import java.util.Map;

// Clase para gestionar las operaciones del banco
public class ServicioBanco {
    // Atributo encapsulado para almacenar los clientes
    private Map<String, Cliente> clientes;

    // Constructor para inicializar el mapa de clientes
    public ServicioBanco() {
        this.clientes = new HashMap<>();
    }

    // Método para registrar un cliente
    public void registrarCliente(Cliente cliente) {
        if (!clientes.containsKey(cliente.getRut())) {
            clientes.put(cliente.getRut(), cliente);
            System.out.println("-------Cliente registrado con éxito.-------");
        } else {
            System.out.println("ALERTA: El cliente con este RUT ya está registrado.");
        }
    }

    // Método para ver los datos de un cliente
    public Cliente verDatosCliente(String rut) {
        return clientes.get(rut);
    }

    // Método para depositar dinero en una cuenta
    public void depositar(int numeroCuenta, int monto) {
        Cliente cliente = obtenerClientePorNumeroCuenta(numeroCuenta);
        if (cliente != null) {
            cliente.getCuenta().depositar(monto);
        } else {
            System.out.println("Número de cuenta no encontrado.");
        }
    }

    // Método para girar (retirar) dinero de una cuenta
    public void girar(int numeroCuenta, int monto) {
        Cliente cliente = obtenerClientePorNumeroCuenta(numeroCuenta);
        if (cliente != null) {
            cliente.getCuenta().girar(monto);
        } else {
            System.out.println("Número de cuenta no encontrado.");
        }
    }

    // Método para consultar el saldo de una cuenta
    public int consultarSaldo(int numeroCuenta) {
        System.out.println("-------Consultando saldo para la cuenta: " + numeroCuenta + "...-------");
        Cliente cliente = obtenerClientePorNumeroCuenta(numeroCuenta);
        if (cliente != null) {
            int saldo = cliente.getCuenta().consultarSaldo();
            return saldo;
        } else {
            return -1;
        }
    }

    // Método privado para obtener un cliente por número de cuenta
    private Cliente obtenerClientePorNumeroCuenta(int numeroCuenta) {
        for (Cliente cliente : clientes.values()) {
            if (cliente.getCuenta().getNumeroCuenta() == numeroCuenta) {
                return cliente;
            }
        }
        return null;
    }
}