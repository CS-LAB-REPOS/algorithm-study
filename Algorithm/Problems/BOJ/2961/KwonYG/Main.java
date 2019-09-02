import java.util.Scanner;

class Item {
    int sour;
    int bitter;

    public Item(int sour, int bitter) {
        this.sour = sour;
        this.bitter = bitter;
    }

    public int getSour() {
        return sour;
    }

    public void setSour(int sour) {
        this.sour = sour;
    }

    public int getBitter() {
        return bitter;
    }

    public void setBitter(int bitter) {
        this.bitter = bitter;
    }
}

public class Main {
    static int min = Integer.MAX_VALUE;
    static Item items[];

    public static void find(int index, int limit, int mul, int sum) {
        int result = Math.abs(mul - sum);
        if (result < min) {
            min = result;
        }

        for (int i = index+1; i < limit; i++) {
            find(i, limit, mul * items[i].getSour(), sum + items[i].getBitter());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        items = new Item[N];


        int count = N;
        for (int i = 0; i < N; i++) {
            items[i] = new Item(sc.nextInt(), sc.nextInt());
        }

        for(int i = 0; i < N; i++){
            find(i, N, items[i].getSour(), items[i].getBitter() );
        }

        System.out.println(min);
    }
}

