public class Starvation {

    public static void main(String[] args) {
        Resource sharedResource = new Resource();
        // creacion de hilos
        Thread thread1 = new Thread(() -> {
            while (true) {
                sharedResource.doWork();// invoca funcion
            }
        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                sharedResource.doWork();// invoca funcion
            }
        });
        // inicio de los hilos
        thread1.start();
        thread2.start();
    }

    static class Resource {
        public synchronized void doWork() {
            String threadName = Thread.currentThread().getName();
            System.out.println("Trabajando en recurso compartido - " + threadName);

            // simulacion de trabajo
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}