//Problem Statement: Web Page Downloader Simulation

//You have 10 URLs (just simulate them as String values)
//        Each download task should:
//        Print: Downloading <URL> on <Thread-Name>
//        Sleep for a random time (1–3 seconds) to simulate latency
//        Then print: Completed <URL> on <Thread-Name>
//        Use ExecutorService with a fixed thread pool of 3
//        Gracefully shut down the executor




import java.util.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//                ExecutorService executor = Executors.newFixedThreadPool(3);
//
//                for (int i = 1; i <= 5; i++) {
//                    final int taskId = i;
//                    executor.execute(() -> {
//                        System.out.println("Task " + taskId + " running on " + Thread.currentThread().getName());
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    });
//                }
//
//                executor.shutdown();

        List<String> urllist= new ArrayList<String>();
        urllist.add("http://example.com/page1");
        urllist.add("http://example.com/page2");
        urllist.add("http://example.com/page3");
        urllist.add("http://example.com/page4");
        urllist.add("http://example.com/page5");
        urllist.add("http://example.com/page6");
        urllist.add("http://example.com/page7");
        urllist.add("http://example.com/page8");
        urllist.add("http://example.com/page9");
        urllist.add("http://example.com/page10");

        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < urllist.size(); i++) {
            final int I=i;
            service.submit(()->{
                System.out.println("Downloading Started for url "+ urllist.get(I) + " Thread ID: "+ Thread.currentThread().getName());
                try {
                    Thread.sleep((long)(Math.random()*100));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Downloading Ended for url "+ urllist.get(I));
            });
        }
        service.shutdown();



    }
}