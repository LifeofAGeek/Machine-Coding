import Service.BiddingService;
import Service.EventService;
import Service.UserService;
import models.Bid;
import models.Event;
import models.Item;
import models.User;
import repository.BidRepository;
import repository.EventRepository;
import repository.UserRepository;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
//        Item iphone14 = new Item("IPHONE-14");
//
//        User user1 = new User("1", "akshay", 10000);
//        User user2 = new User("2", "chris", 5000);
//        User user3 = new User("3", "anubhav", 500);
//
//        UserRepository userRepository = new UserRepository();
//        UserService userService = new UserService(userRepository);
//
//        userService.addUser(user1);
//        userService.addUser(user2);
//        userService.addUser(user3);
//
//        EventRepository eventRepository = new EventRepository();
//        BidRepository bidRepository = new BidRepository();
//        EventService eventService = new EventService(eventRepository, bidRepository);
//
//        Event event1 = eventService.createEvent("1", "BBD", iphone14, "2023-06-06");
//
//        eventService.registerUser(user1, event1);
//        eventService.registerUser(user2, event1);
//
//        BiddingService biddingService = new BiddingService(bidRepository, eventRepository);
//
//        Bid bidUser1 = new Bid(user1.getId(), event1.getId(), List.of(100, 200, 400, 500, 600));
//        Bid bidUser2 = new Bid(user2.getId(), event1.getId(), List.of(50, 200, 400)); // lowest bid made by user 2
//        Bid bidUser3 = new Bid(user3.getId(), event1.getId(), List.of(100, 200, 400));
//
//        biddingService.submitBid(user1.getId(), event1.getId(), bidUser1.getBidValues());
//        biddingService.submitBid(user2.getId(), event1.getId(), bidUser2.getBidValues());
//        biddingService.submitBid(user3.getId(), event1.getId(), bidUser3.getBidValues());
//
//        String id = eventService.declareWinner(event1.getId());
//        System.out.println("Winner's userId: " + id); // user 2 should be the winner

//        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
//        concurrentHashMap.put("Hi", 2);
//        System.out.println(concurrentHashMap.compute("Hi", (key, value) -> value + 10));
//        concurrentHashMap.merge("Hi", 5, (existingValue, newValue) -> existingValue + newValue);
//        System.out.println(concurrentHashMap.get("Hi"));
//        MyThread myThread = new MyThread(new MyRunnable());
//        if (myThread instanceof Thread) System.out.println("yes");
//        myThread.setPriority(Thread.MAX_PRIORITY);
//        myThread.getPriority();
//        myThread.start();
//        StringBuffer sb = new StringBuffer();
//        Runnable appendTask = () -> {
//            System.out.println("inside thread");
//            sb.append("A".repeat(100));
//        };
//
//        Thread thread1 = new Thread(appendTask);
//        Thread thread2 = new Thread(appendTask);
//
//        thread1.start();
//        thread2.start();
//
//        try {
//            thread1.join();
//            thread2.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        for (int i = 1; i <= 5; i++) {
//            System.out.println("Main Thread: " + i);
//        }
//        Person person = new Person("Anubhav", 26);
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
//            oos.writeObject(person);
//            System.out.println("done serialisation");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
//            Person p = (Person) ois.readObject();
//            System.out.println(p);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        Thread daemonThread = new Thread(() -> {
//            while (true) {
//                System.out.println("Daemon Thread is running");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

//        daemonThread.setDaemon(true);
//        daemonThread.start();
//
//        Thread nonDaemonThread = new Thread(() -> {
//            for (int i = 1; i <= 5; i++) {
//                System.out.println("Non-Daemon Thread: " + i);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        nonDaemonThread.start();

//        try {
//            Class<?> clazz = Class.forName("Person");
//            Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
//            Person p = (Person) constructor.newInstance("Anubhav", 10);
//            System.out.println(p);
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
//                 InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }

//        Set<Integer> set = new HashSet<>(){
//            {
//                add(1);
//                add(2);
//                add(3);
//            }
//        };

//        final Object resource1 = new Object();
//        final Object resource2 = new Object();
//
//        Thread thread1 = new Thread(() -> {
//            synchronized (resource1) {
//                System.out.println("Thread 1: Holding resource 1");
//
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println("Thread 1: Waiting for resource 2");
//                synchronized (resource2) {
//                    System.out.println("Thread 1: Holding resource 1 and resource 2");
//                }
//            }
//        });
//
//        Thread thread2 = new Thread(() -> {
//            synchronized (resource2) {
//                System.out.println("Thread 2: Holding resource 2");
//
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println("Thread 2: Waiting for resource 1");
//                synchronized (resource1) {
//                    System.out.println("Thread 2: Holding resource 1 and resource 2");
//                }
//            }
//        });

//        thread1.start();
//        thread2.start();
//
//
//        System.out.println("Main thread exiting");



        //inputs: array - A1 = {1, 2, 3, 4, 5, 5, 6, 7}, op = 5
        // A2 = {127, 128, 129, 130, 130}, op = 130
        // A3 = {14, 14, 15, 16}, op = 14

        // assumptions
        // array is sorted
        // array elements are natural nums in incr order, d = 1

        // a = 14, d = 1, O(N), O(1)
        // freqMap {key = elem, val = freq}
        // freqMap.get(14) = 1, O(N) space

        // binary search
        // [l, r] l = 1, r = 7,

        // {1, 2, 3, 4, 5, 5, 6, 7}, m = 5

//        List<Integer> nums = List.of(1, 2, 3, 4, 5, 5, 6, 7);
//        int n = nums.size();
//        int lower = 0, high = n - 1, duplicateIndex = -1;
//        while (lower <= high) {
//            int midIndex = lower + (high - lower) / 2;
//
//            if ((midIndex > 0 && nums.get(midIndex) == nums.get(midIndex - 1)) ||
//                    (midIndex < n - 1 && nums.get(midIndex) == nums.get(midIndex + 1))) {
//                duplicateIndex = midIndex;
//                break;
//            }
//            // index -> index + nums.get(0)
//            else if (midIndex + nums.get(0) == nums.get(midIndex)) {
//                lower = midIndex + 1;
//            } else high = midIndex - 1;
//        }
//        System.out.println(nums.get(duplicateIndex));



        // array = [3,2,1,6,5,4], n = 6, kth largest element

        // assumptions
        // element would be not sorted and in range of INTEGER
        // array2 = [3,2,3,1,2,4,5,5,6] k = 4, op = 4
        // include duplicates as well in kth largest answer

        // Approach - 1
        // sort in increasing order, answer = [1,2,3,3,4,5,5,6] = n - k = 8 - 4 = 4th index will be my answer
        // O(NlogN)

        // Using Heap, O(1), O(logN)
        // Heap with a limited size of K, min heap

        // heap = {4, 5, 5, 6}, answer is top element = 4
        // O(NlogK)

        // tradeoff = if K << N ? O(NlogK) : (NlogN)

//        List<Integer> nums = List.of(1,2,3,3,4,5,5,6);
//        int k = 5;
//        int K = nums.size() - k;
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//
//        for (int i = 0; i < nums.size(); i++) {
//            if (minHeap.size() < K) minHeap.offer(nums.get(0));
//            else if (minHeap.peek() < nums.get(i)) {
//                minHeap.poll();
//                minHeap.offer(nums.get(i));
//            }
//        }
//
//        System.out.println(minHeap.peek());

        // [1,2,3,3] window of size k
        // answer which is kth largest. O(N + K)

//        final Object lock1 = new Object();
//        final Object lock2 = new Object();
//        // Use a consistent lock order
//        synchronized (lock1) {
//            synchronized (lock2) {
//                // Code here
//            }
//        }
//
//        if (Lock(lock1)) {
//            try {
//                // Code here
//            } finally {
//                lock1.unlock();
//            }
//        }


















    }
}