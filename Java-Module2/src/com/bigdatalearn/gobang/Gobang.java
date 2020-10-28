package com.bigdatalearn.gobang;

import java.time.Year;

public class Gobang {

    int x;
    int y;
    int user;
    int count;
    boolean flag;
    String[] arr = {" ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    static String[][] checker_board = new String[17][17];


    void show() {
        for (int i = 0; i < 17; i++) {

            if (i < 1) {
                for (int j = 0; j < 17; j++) {
                    if (j >= 16) {

                        System.out.print(arr[j] + "\n\r");
                        checker_board[i][j] = arr[j];
                    } else {
                        System.out.print(arr[j] + " ");
                        checker_board[i][j] = arr[j];
                    }
                }
            } else {
                for (int j = 0; j < 17; j++) {
//                    System.out.print(arr[j+1]);
                    if (j < 1) {
                        System.out.print(arr[i] + " ");
                        checker_board[i][j] = arr[i];
                    } else if (j >= 16) {
                        System.out.print("+" + "\n\r");
                        checker_board[i][j] = "+";
                    } else {
                        System.out.print("+ ");
                        checker_board[i][j] = "+";
                    }
                }
            }
        }
    }

    void showCheckBoard() {
        for (int i = 0; i < checker_board.length; i++) {
            System.out.println();
            for (int j = 0; j <checker_board.length; j++) {
                if (j == checker_board.length-1) {
                    System.out.print(checker_board[i][j]+"\r\n");
                }else {
                    System.out.print(checker_board[i][j] + "\t");
                }
            }
        }
    }

    boolean qiZi(int x, int y, int user) {
        this.x = x + 1;
        this.y = y + 1;
        this.user = user;
        Gobang gobang = new Gobang();
        if (x > 17 || y > 17) {
            System.out.println("棋子越界");
        } else {
            if (user == 1) {
                if (checker_board[x][y].equals("+")) {
                    checker_board[x][y] = "#";
                    gobang.showCheckBoard();
                    if (isWin(x, y, "#")) {
                        System.out.println("用户1赢了");
                        return true;
                    }
                } else {
                    System.out.println("该位置已经有棋子了");
                }
            } else {
                if (checker_board[x][y].equals("+")) {
                    checker_board[x][y] = "*";
                    gobang.showCheckBoard();
                    if (isWin(x, y, "*")) {
                        System.out.println("用户2赢了");
                        return true;
                    }
                } else {
                    System.out.println("该位置已经有棋子了");
                }
            }
        }
        return false;
    }

    boolean isWin(int x, int y, String color) {
        int count = 1;      //本身一点为 1
        int posX = 0;
        int posY = 0;
        /**判断水平方向上的胜负
         /* 将水平方向以传入的点x上的y轴作为分隔线分为两部分
         * 先向左边遍历，判断到的相同的连续的点  count++
         */
        for (posX = x - 1; posX > 0; posX--) {
            if (checker_board[posX][y].equals(color)) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                break;
            }
        }    //向右边遍历
        for (posX = x + 1; posX <= 17; posX++) {
            if (checker_board[posX][y].equals(color)) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                break;
            }
        }
        /**判断垂直方向上的胜负
         /* 将垂直方向以传入的点y上的x轴作为分隔线分为两部分
         * 先向上遍历，判断到的相同的连续的点  count++
         */
        for (posY = y - 1; posY > 0; posY--) {
            if (checker_board[x][posY].equals(color)) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                break;
            }
        }//向下遍历
        for (posY = y + 1; posY <= 17; posY++) {
            if (checker_board[x][posY].equals(color)) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                break;
            }
        }
        /**判断左上右下方向上的胜负
         * 以坐标点为分割线，将棋盘分为左右两个等腰三角形
         * 先判断左边的
         */
        for (posX = x - 1, posY = y - 1; posX > 0 && posY > 0; posX--, posY--) {
            if (checker_board[posX][posY].equals(color)) {
                count++;
                if (count >= 5) {
                    count = 1;
                    return true;
                }
            } else {
                break;
            }
        }//判断右边的
        for (posX = x + 1, posY = y + 1; posX <= 17 && posY <= 17; posX++, posY++) {
            if (checker_board[posX][posY].equals(color)) {
                count++;
                if (count >= 5) {
                    count = 1;
                    return true;
                }
            } else {
                break;
            }
        }
        /**判断右下左下方向上的胜负
         * 以坐标点为分割线，将棋盘分为左右两个等腰三角形
         * 先判断左边的
         */
        for (posX = x + 1, posY = y - 1; posX <= 17 && posY > 0; posX++, posY--) {
            if (checker_board[posX][posY].equals(color)) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                break;
            }
        }//判断右边的
        for (posX = x - 1, posY = y + 1; posX > 0 && posY <= 17; posX--, posY++) {
            if (checker_board[posX][posY].equals(color)) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }
}

