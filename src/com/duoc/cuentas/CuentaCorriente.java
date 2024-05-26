
package com.duoc.cuentas;

// Subclase que extiende de CuentaBancaria para representar una cuenta corriente
public class CuentaCorriente extends CuentaBancaria {

    // Constructor para inicializar la cuenta corriente
    public CuentaCorriente(int numeroCuenta, int saldo) {
        super(numeroCuenta, saldo);
    }

    // Implementación del método abstracto mostrarInfoCuenta
    @Override
    public void mostrarInfoCuenta() {
        System.out.println("--------------------------");
        System.out.println("  SALDO CUENTA CORRIENTE");
        System.out.println("--------------------------");
        System.out.println("Cuenta Corriente - Número: " + getNumeroCuenta() + ", Saldo: " + getSaldo()+ "pesos Chilenos.");
    }
}