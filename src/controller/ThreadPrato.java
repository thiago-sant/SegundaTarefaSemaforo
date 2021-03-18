package controller;

import java.util.concurrent.Semaphore;

public class ThreadPrato extends Thread {
		private int idThread;
		private int tempoCoz;
		private int porcentagemTotal = 100;
		private int porcentagem;
		private Semaphore semaforo;
		
		public ThreadPrato (int idThread, Semaphore semaforo) {
			this.idThread = idThread;
			this.semaforo = semaforo;
		}
		
		@Override
		public void run() {
			Preparo();
			try {
				semaforo.acquire();
				Entrega();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}

		private void Preparo() {
			if (idThread % 2 == 0) {
				tempoCoz = (int)((Math.random()* 601) + 600);
				while (porcentagem < 100) {
					try {
						sleep(porcentagemTotal);
						System.out.println("Prato #" +idThread+ ": Lasanha a Bolonhesa cozinhou: " +porcentagem+ "%");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					porcentagem += tempoCoz / porcentagemTotal;
				}
			}
			else {
				tempoCoz = (int)((Math.random()* 501) + 300);
				while (porcentagem < 100) {
					try {
						sleep(porcentagemTotal);
						System.out.println("Prato #" +idThread+ ": Sopa de Cebola cozinhou: " +porcentagem+ "%");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					porcentagem += tempoCoz / porcentagemTotal;
				}
			}
			
			
		}
		
		private void Entrega() {
			System.out.println("Prato #" +idThread+ " está sendo entregue...");
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Prato #" +idThread+ " foi entregue.");
		}
}
