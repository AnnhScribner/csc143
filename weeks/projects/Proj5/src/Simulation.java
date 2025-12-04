import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class Simulation {
    private final int initialCustomerCount;
    private final int hours;
    private final int reportInterval;
    private final int callRate;
    private final double meanCallTime;
    private final double sDiveCallTime;
    private int currentTime;
    private HashSetQueue<Customer> customerQueue;
    private HashSetQueue<Tech> techQueue;
    private final ArrayList<Customer> arrCustomer;
    private final ArrayList<Tech> arrTech;
    private final int amountTech;
    private PriorityQueue<SupportSession> activeCalls;
    private static final int MILIS = 1000;

    public Simulation(int amountTech, int initialCustomerCount, int hours,
                      int reportInterval, int callRate,
                      double meanCallTime, double sDiveCallTime,
                      ArrayList<Tech> tech, ArrayList<Customer> customer) {
        this.amountTech = amountTech;
        this.initialCustomerCount = initialCustomerCount;
        this.hours = hours;
        this.reportInterval = reportInterval;
        this.callRate = callRate;
        this.meanCallTime = meanCallTime;
        this.sDiveCallTime = sDiveCallTime;

        this.arrTech = tech;
        this.arrCustomer = customer;
    }

    public void start() {
        Random random = new Random();
        activeCalls = new PriorityQueue<>();
        techQueue = new HashSetQueue<>();
        currentTime = 0;

        while (techQueue.size() < amountTech) {
            techQueue.add(arrTech.get(random.nextInt(arrTech.size())));
        }

        customerQueue = new HashSetQueue<Customer>();
        while (customerQueue.size() < initialCustomerCount) {
            customerQueue.add(arrCustomer.get(random.nextInt(arrCustomer.size())));
        }

        for (int i = 0; i < hours * 60; i++) {
            tick();
            try {
                Thread.sleep(MILIS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        finalBanner();
    }

    private void finalBanner() {
        System.out.println("========================================");
        System.out.println("======== SIMULATION IS OVER ========");
        System.out.println("========================================");
    }

    public void tick() {
        Random random = new Random();
        createSession(random);
        finishSession();
        getCustomerFromQueue(random);
        report();
        currentTime++;
    }

    private void createSession(Random random) {
        while (!techQueue.isEmpty() && !customerQueue.isEmpty()) {
            Tech saveTech = techQueue.remove();
            Customer saveCustomer = customerQueue.remove();
            double z = random.nextGaussian();
            double x = Math.abs(z * sDiveCallTime + meanCallTime);
            SupportSession session = new SupportSession(saveCustomer,
                    saveTech, currentTime, (int) x);
            activeCalls.add(session);
        }
    }

    private void finishSession() {
        while ((!activeCalls.isEmpty()) && (activeCalls.peek().endTime() <= currentTime)) {
            SupportSession s = activeCalls.remove();
            techQueue.add(s.tech());
            System.out.printf("Tech id: %s. Customer id: %s. Call length: %d. Finish time: %d\n"
                    , s.tech().id(), s.customer().id(), s.durationOfCall(), s.endTime());
        }
    }

    private void report() {
        if (currentTime % reportInterval == 0) {
            System.out.printf("\nThere are %d techs and %d customers in the queue.\n",
                    techQueue.size(), customerQueue.size());
            System.out.printf("There are %d active calls right now.\n", activeCalls.size());
            System.out.printf("%d minutes since simulation began.\n\n", currentTime);
        }
    }

    private void getCustomerFromQueue(Random random) {
        if (currentTime % callRate == 0) {
            customerQueue.add(arrCustomer.get(random.nextInt(arrCustomer.size())));
        }
    }
}
