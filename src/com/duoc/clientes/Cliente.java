
package com.duoc.clientes;

import com.duoc.cuentas.CuentaBancaria;

// Clase Cliente que implementa la interfaz MostrarInfoCliente
public class Cliente {
        // Atributos encapsulados
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private String telefono;
    private CuentaBancaria cuenta;

    // Constructor para inicializar los atributos del cliente
    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String comuna, String telefono, CuentaBancaria cuenta) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuenta = cuenta;
    }

    // Métodos accesadores y mutadores (getters y setters)
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    // Método para registrar un cliente
    public void registrarCliente() {
        System.out.println("-------¡Cliente registrado exitosamente!-------");
    }

    // Implementación del método mostrarInfoCliente de la interfaz MostrarInfoCliente
    public void mostrarInfoCliente() {
        System.out.println("--------------------------");
        System.out.println("    DATOS DEL CLIENTE");
        System.out.println("--------------------------");
        System.out.println("Rut: " + rut + "\n" +
                           "Nombre: " + nombre + "\n" +
                           "Apellido Paterno: " + apellidoPaterno + "\n" +
                           "Apellido Materno: " + apellidoMaterno + "\n" +
                           "Domicilio: " + domicilio + "\n" +
                           "Comuna: " + comuna + "\n" +
                           "Teléfono: " + telefono + "\n" +
                           "Número de Cuenta Bancaria: " + cuenta.getNumeroCuenta() + "\n" +
                           "Saldo: " + cuenta.getSaldo() + " pesos");
    }
}
