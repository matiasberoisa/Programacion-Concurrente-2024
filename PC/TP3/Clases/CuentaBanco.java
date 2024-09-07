package PC.TP3.Clases;

public class CuentaBanco {
    private int balance = 50;

    public CuentaBanco() {
    }

    public int getBalance() {
        return balance;
    }

    public void retiroBancario(int retiro) {
        balance = balance - retiro;
    }

    public static void main(String[] args) {
        VerificarCuenta vc = new VerificarCuenta();
        Thread Luis = new Thread(vc, "Luis");
        Thread Manuel = new Thread(vc, "Manuel");
        Luis.start();
        Manuel.start();
    }
}