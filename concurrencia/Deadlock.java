public class Deadlock 
{
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();


    public static void main(String[] args) 
    {
        //Creacion de dos hilos
        Thread thread1 = new Thread(() -> 
        {
            synchronized(resource1)
            {
                System.out.println("Hilo 1: Bloqueado recurso 1");
                try
                {
                    Thread.sleep( 1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                synchronized (resource2)
                {
                    System.out.println("Hilo 1: Bloqueado recurso 2");
                }
            }
        });
        Thread thread2 = new Thread(() ->
        {
            synchronized (resource2)
            {
                System.out.println("Hilo 2: Bloqueado recurso 2");
                synchronized (resource1)
                {
                    System.out.println("Hilo 2: Bloqueado recurso 1");
                }
            }
        });

        //Inicio de los hilos
        thread1.start();
        thread2.start();
    }
    
}
 