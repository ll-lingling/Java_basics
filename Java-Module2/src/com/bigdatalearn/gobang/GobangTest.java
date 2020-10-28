package com.bigdatalearn.gobang;


import java.util.Scanner;

public class GobangTest {




    void luoZi() {
        for (; ; ) {
            Gobang gobang = new Gobang();
            System.out.println("请1落子");
            Scanner scanner = new Scanner(System.in);
            int ix1 = scanner.nextInt();
            int iy1 = scanner.nextInt();
            if (gobang.qiZi(ix1, iy1, 1)) {
                break;
            }
            System.out.println("请2落子");
            int ix2 = scanner.nextInt();
            int iy2 = scanner.nextInt();
            if (gobang.qiZi(ix2, iy2, 2)) {
                break;
            }

        }
    }

    public static void main(String[] args) {

        Gobang gobang = new Gobang();
        gobang.show();
        GobangTest gobangTest = new GobangTest();
        gobangTest.luoZi();
    }
}
