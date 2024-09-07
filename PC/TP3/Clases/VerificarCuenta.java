package PC.TP3.Clases;

public class VerificarCuenta implements Runnable {
    private CuentaBanco cb = new CuentaBanco();

    /**
     * @param cantidad
     * @throws InterruptedException
     */
    private void HacerRetiro(int cantidad) throws InterruptedException {
        synchronized (this) {
            if (cb.getBalance() >= cantidad) {
                System.out
                        .println(Thread.currentThread().getName() + " está realizando un retiro de: " + cantidad + ".");
                Thread.sleep(1000);
                cb.retiroBancario(cantidad);
                System.out.println(Thread.currentThread().getName() + ": Retiro realizado.");
                System.out.println(Thread.currentThread().getName() + ": Los fondos son de: " + cb.getBalance());
            } else {
                System.out.println(
                        "No hay suficiente dinero en la cuenta Facultad de Informática Programación Concurrente - Departamento de Programación 2024 para realizar el retiro Sr."
                                + Thread.currentThread().getName());
                System.out.println("Su saldo actual es de " +
                        cb.getBalance());
                Thread.sleep(1000);
            }
        }
    }

    // de hacer retiro

    public void run() {
        for (int i = 0; i <= 3; i++) {
            try {
                this.HacerRetiro(10);
                if (cb.getBalance() < 0) {
                    System.out.println("La cuenta está sobregirada.");
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}