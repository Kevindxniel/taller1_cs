import java.util.Objects;

abstract class CuentaBancaria {
    abstract void verSaldo();
}

class CuentaReal extends CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaReal(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    @Override
    public void verSaldo() {
        System.out.println("El saldo de la cuenta de " + titular + " es: $" + saldo);
    }
}

class ProxyCuentaBancaria extends CuentaBancaria {
    private String titular;
    private double saldo;
    private String usuario;
    private CuentaReal cuentaReal;

    public ProxyCuentaBancaria(String titular, double saldo, String usuario) {
        this.titular = titular;
        this.saldo = saldo;
        this.usuario = usuario;
    }

    @Override
    public void verSaldo() {
        if (Objects.equals(usuario, titular)) {
            if (cuentaReal == null) {
                cuentaReal = new CuentaReal(titular, saldo);
            }
            cuentaReal.verSaldo();
        } else {
            System.out.println("Acceso denegado. " + usuario + " no tiene permiso para ver esta cuenta.");
        }
    }
}

public class proxytype {
    public static void main(String[] args) {
        ProxyCuentaBancaria cuenta1 = new ProxyCuentaBancaria("Carlos", 5000, "Carlos");
        cuenta1.verSaldo();

        ProxyCuentaBancaria cuenta2 = new ProxyCuentaBancaria("Carlos", 5000, "Juan");
        cuenta2.verSaldo();
    }
}
