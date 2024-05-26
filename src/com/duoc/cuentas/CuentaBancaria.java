
package com.duoc.cuentas;

// Clase abstracta base para diferentes tipos de cuentas bancarias
public abstract class CuentaBancaria {
    // Atributos encapsulados
    private int numeroCuenta;
    private int saldo;

    // Constructor para inicializar los atributos
    public CuentaBancaria(int numeroCuenta, int saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    // Sobrecarga de constructores
    public CuentaBancaria(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0; // Inicializa el saldo a 0
    }

    // Métodos accesadores y mutadores (getters y setters)
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    // Método para depositar dinero en la cuenta
    public void depositar(int monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("-------¡Depósito realizado de manera exitosa!-------");
            System.out.println("Usted tiene un saldo actual de " + this.saldo + " pesos Chilenos.");
        } else {
            System.out.println("ALERTA: El monto a depositar debe ser mayor que cero.");
        }
    }

    // Método para girar (retirar) dinero de la cuenta
    public void girar(int monto) {
        if (monto > 0) {
            if (this.saldo >= monto) {
                this.saldo -= monto;
                System.out.println("-------¡Giro realizado de manera exitosa!-------");
                System.out.println("Usted tiene un saldo actual de " + this.saldo + " pesos Chilenos.");
            } else {
                System.out.println("-------Saldo insuficiente para realizar el giro.-------");
            }
        } else {
            System.out.println("ALERTA: El monto a girar debe ser mayor que cero.");
        }
    }

    // Método abstracto que debe ser implementado por las subclases
    public abstract void mostrarInfoCuenta();

    // Método para consultar el saldo de la cuenta
    public int consultarSaldo() {
        return this.saldo;
    }
}
