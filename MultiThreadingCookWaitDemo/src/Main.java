//Scenario:
//You are building a simple simulation of a restaurant:
//There is one cook (producer) who prepares one dish at a time.
//There is one waiter (consumer) who picks up and serves the dish.
//The cook should wait if a dish is already on the counter.
//The waiter should wait if there is no dish to serve.
//        💡 Requirements:
//You need to synchronize the communication between cook and waiter.
//Use wait() / notify() (not advanced tools like BlockingQueue).

//Print output like:
//Cook: Preparing dish 1
//Waiter: Picked up dish 1
//Cook: Preparing dish 2
//Waiter: Picked up dish 2

//Implement a class RestaurantCounter with methods:
//public void putDish(int dishId) – called by Cook
//public void takeDish() – called by Waiter
//Use synchronized, wait(), and notify()
//Create 2 threads: Cook and Waiter


class RestaurantCounter{
    public int dishId;
    boolean preparingDish=false;
    public synchronized void putDish(int dishId) throws InterruptedException {
        if(!preparingDish){
           wait();
        }
        System.out.println("Cook: Preparing dish "+dishId);
        preparingDish=false;
        notify();
    }
    public synchronized void takeDish(int dishId) throws InterruptedException {
        if(preparingDish){
            wait();
        }
        System.out.println("Waiter: Picked up dish "+dishId);
        preparingDish=true;
        notify();
    }
}
public class Main {

    public static void main(String[] args) {
        RestaurantCounter counter=new RestaurantCounter();
            Thread Cook =new Thread(()->{for(int i =0;i<=10;i++){
                try {
                    counter.putDish(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }});
            Thread Waiter =new Thread(()->{for(int i =0;i<=10;i++){
                try {
                    counter.takeDish(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }});

            Cook.start();;
            Waiter.start();
    }
}