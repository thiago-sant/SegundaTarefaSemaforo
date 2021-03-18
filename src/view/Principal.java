package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPrato;

public class Principal {
	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int idThread = 0; idThread < 5; idThread++) {
			Thread tPrato = new ThreadPrato(idThread, semaforo);
			tPrato.start();
		}
	}
}
