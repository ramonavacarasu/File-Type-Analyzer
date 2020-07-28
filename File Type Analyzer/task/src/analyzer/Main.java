package analyzer;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        File currentDirectory = new File(args[0]);

        File[] files = currentDirectory.listFiles();

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Callable<String>> workers = new LinkedList<>();

        for (File file : files) {
            if (file.isFile()) {
                workers.add(new Worker(file, args[1], args[2]));
            }
        }


        List<String> results = new LinkedList<>();

        try {
            List<Future<String>> futures;
            futures = executor.invokeAll(workers);

            for (Future future : futures) {
                String aResult = future.get(10, TimeUnit.SECONDS).toString();
                results.add(aResult);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Collections.sort(results);

        for (String s : results) {
            System.out.println(s);
        }

        executor.shutdown();

    }

}
