import java.util.Arrays;
import java.util.LinkedHashMap;

public class mayinTarlasi {


    mayinTarlasi() {

    }

    public static int[] board() {
        int[] map = new int[100];


        int count = 0;
        while (count < 15) {


            int x = (int) (Math.random() * 100);
            if (map[x] != -1) {
                map[x] = -1;
                count++;
            }


        }
        return map;
    }

    public static int[] game(int[] arr) {


        for (int i = 0; i < 100; i++)
            if (arr[i] == -1) {
                int x1 = i - 11;
                int x2 = i - 10;
                int x3 = i - 9;
                int x4 = i + 10;
                int x5 = i + 11;
                int x6 = i + 9;
                int x7 = i - 1;
                int x8 = i + 1;


                if (x1 >= 0&&!(i%10==0)&&arr[x1]!=-1)
                    arr[x1] += 1;
                if (x2 >= 0&&arr[x2]!=-1)
                    arr[x2] += 1;
                if (x3 >= 0&&!(i%10==9)&&arr[x3]!=-1)
                    arr[x3] += 1;
                if (x4 < 100&&arr[x4]!=-1)
                    arr[x4] += 1;
                if (x5 <100 &&!(i%10==9)&&arr[x5]!=-1)
                    arr[x5] += 1;
                if (x6 <100&&!(i%10==0)&&arr[x6]!=-1)
                    arr[x6] += 1;
                if (x7 > 0&&!(i%10==0)&&arr[x7]!=-1)
                    arr[x7] += 1;
                if (!(i%10==9)&&arr[x8]!=-1)
                    arr[x8] += 1;
            }


        return arr;
    }


}
