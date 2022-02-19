package Backtracking;

public class Backtracking {
    int[] result = new int[8];  //全局或成员变量,下标表示行,值表示queen存储在哪一列

    public void cal8queens(int row) {
        // 调用方式：cal8queens(0);
        if (row == 8) {
            printQueens(result);
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8queens(row + 1);
            }
        }
    }

    private boolean isOk(int row, int column) {
        int leftUp = column - 1, rightUp = column + 1;
        for (int i = row - 1; i >= 0; --i) {
            if (result[i] == column) return false;
            if (leftUp >= 0) {
                if (result[i] == leftUp) return false;
            }
            if (rightUp < 8) {
                if (result[i] == rightUp) return false;
            }
            --leftUp;
            ++rightUp;
        }
        return true;
    }

    private void printQueens(int[] result) {
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
