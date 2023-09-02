import java.util.Random;
import java.util.ArrayList;

/**
 * メインクラス
 */
public class Main {
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

    /**
   * 1つの店のクラス
   */
class Store {
    Random rand; // 乱数クラスのインスタンス
    private int all; // シミュレーションした合計日数
    private int upperCount; //  // 当たりの割合が60%を超えた日数
    private int ticketNum; // 1日に売るくじの数
    private ArrayList<Integer> hitList; // 当たりの割合が60%を超えた日のリスト
    /**
   * コンストラクタ
   * @param num 1日に売るくじの数
   */
    Store(int num) {
        this.rand = new Random();
        this.all = 0;
        this.upperCount = 0;
        this.ticketNum = num;
        hitList = new ArrayList<Integer>();
    }

    /**
   * 1日をシミュレーションするメソッド
   * 1日ごとに実行する
   */
    public void day() {
        int hit = 0; // 当たりくじの数
        // 1日に売るチケットの枚数分シミュレーションする
        for (int i = 0; i < ticketNum; i++) {
            double r = rand.nextDouble();
            if (r >= 0.5) {
                hit++; // 乱数が0５を超えたとき当たりとする
            }
        }

        all++; // シミュレーション日数を更新
        if (hit / (double)ticketNum >= 0.6) { // 当たりの割合が60%を超えた場合はカウント
            upperCount++;
            hitList.add(all);
        }
    }

    /**
   * 今までのシミュレーション結果概要を文字列として返すメソッド
   *
   * @return 今までのシミュレーション結果で当たり割合が60%以上だった日の割合を文字列として返す
   */
    public String toString() {
        return String.format("%d/%d", upperCount, all);
    }

    /**
   * 当たり割合が60%以上だった日を標準出力する
   */
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
