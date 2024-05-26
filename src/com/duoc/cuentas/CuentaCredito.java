
package com.duoc.cuentas;

// Subclase que extiende de CuentaBancaria para representar una cuenta de crédito
public class CuentaCredito extends CuentaBancaria {

    // Constructor para inicializar la cuenta de crédito
    public CuentaCredito(int numeroCuenta, int saldo) {
        super(numeroCuenta, saldo);
    }

    // Implementación del método abstracto mostrarInfoCuenta
    @Override
    public void mostrarInfoCuenta() {
        System.out.println("--------------------------");
        System.out.println(" SALDO TARJETA DE CRÉDITO");
        System.out.println("--------------------------");
        System.out.println("Cuenta de Crédito - Número: " + getNumeroCuenta() + ", Saldo: " + getSaldo()+ "pesos Chilenos");
    }
}