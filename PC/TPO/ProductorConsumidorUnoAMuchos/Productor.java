package ProductorConsumidorUnoAMuchos;

import java.util.Random;

public class Productor implements Runnable{
	  private Buffer rc;

	    private Random random = new Random();

	    public Productor(Buffer rc) {
	        this.rc = rc;
	    }

	    @Override
	    public void run() {
	        while (true) {
	            try {
	                rc.producir(random.nextInt(1, rc.longitudlementos()));
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	            try {
	                Thread.sleep(3000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }

	    }
}
