public class ContentionExample {
    private static int counter = 0;

    public static void main(String[] args) {
        // Crear múltiples hilos
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new IncrementThread();
            threads[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Imprimir el valor final del contador
        System.out.println("Valor final del contador: " + counter);
    }
    private static class IncrementThread extends Thread {
        @Override
        public void run() {
            // Incrementar el contador varias veces
            for (int i = 0; i < 1000; i++) {
                // Sección crítica: Incrementar el contador
                synchronized (ContentionExample.class) {
                    counter++;
                }
            }
        }
    }

}