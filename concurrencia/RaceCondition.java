public class RaceCondition {
  private static int counter = 0;

  public static void main(String[] args) {
    //creacion de varios hilos
    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < 1000; i++) {
        incrementCounter();
      }
    });
    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < 1000; i++) {
        incrementCounter();
      }
    });

    //inicializacion de los hilos
    thread1.start();
    thread2.start();
    //espera a que los hilos terminen
    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    //imprime el valor de counter
    System.out.println("Valor final del contador: " + counter);

  }

  private static synchronized void incrementCounter() {
    counter++;
  }
}