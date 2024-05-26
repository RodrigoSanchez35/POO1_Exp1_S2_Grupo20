
package com.duoc.cuentas;

// Subclase que extiende de CuentaBancaria para representar una cuenta de ahorro
public class CuentaAhorro extends CuentaBancaria {

    // Constructor para inicializar la cuenta de ahorro
    public CuentaAhorro(int numeroCuenta, int saldo) {
        super(numeroCuenta, saldo);
    }

    // Implementación del método abstracto mostrarInfoCuenta
    @Override
    public void mostrarInfoCuenta() {
        System.out.println("--------------------------");
        System.out.println(" SALDO CUENTA DE AHORRO");
        System.out.println("--------------------------");
        System.out.println("Cuenta de Ahorro - Número: " + getNumeroCuenta() + ", Saldo: " + getSaldo()+"pesos Chilenos");
    }
}