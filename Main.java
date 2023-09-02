import java.util.Random;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Store popular = new Store(100);
        Store unpopular = new Store(50);

        for (int i = 0; i < 365; i++) {
            popular.day();
            unpopular.day();
        }
        System.out.println("popular: " + popular);
        popular.printList();
        System.out.println("unpopular: " + unpopular);
        unpopular.printList();
    }
}

class Store {
    Random rand;
    private int all;
    private int upperCount;
    private int ticketNum;
    private ArrayList<Integer> hitList;
    Store(int num) {
        this.rand = new Random();
        this.all = 0;
        this.upperCount = 0;
        this.ticketNum = num;
        hitList = new ArrayList<Integer>();
    }
    public void day() {
        int hit = 0;
        for (int i = 0; i < ticketNum; i++) {
            double r = rand.nextDouble();
            if (r >= 0.5) {
                hit++;
            }
        }

        all++;
        if (hit / (double)ticketNum >= 0.6) {
            upperCount++;
            hitList.add(all);
        }
    }
    public String toString() {
        return String.format("%d/%d", upperCount, all);
    }
    public void printList() {
        for (int i = 0; i < hitList.size(); i++) {
            if (i < hitList.size()-1) {
                System.out.printf("%d, ", hitList.get(i));
            } else {
                System.out.println(hitList.get(i));
            }
        }
    }
}
