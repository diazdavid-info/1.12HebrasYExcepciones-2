package david;

import java.lang.Thread.UncaughtExceptionHandler;

class MiHebra extends Thread{
	public void run(){
		throw new NullPointerException();
	}
}

public class HebrasYExcepciones implements UncaughtExceptionHandler{

	public static void main(String[] args) throws InterruptedException {
		MiHebra mh = new MiHebra();
		mh.setUncaughtExceptionHandler(new HebrasYExcepciones());
		mh.start();
		
		mh.join();
		
		System.out.println("La hebra ha terminado.");

	}

	@Override
	public void uncaughtException(Thread arg0, Throwable arg1) {
		System.out.println("La hebra: "+arg0+" acabó por: "+arg1);
		
	}

}