package BitMap;

public class BitMap {
    private char[] bytes;
    private int nbits;

    public BitMap(int nbits) {
        this.nbits = nbits;
        this.bytes = new char[nbits/16 + 1];
    }

    public void set(int k) {
        if (k > nbits) return;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int k) {
        if (k > nbits) return false;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }

    //将数字 A 的第 k 位设置为1：A = A | (1 << (k - 1))
    //将数字 A 的第 k 位设置为0：A = A & ~(1 << (k - 1))
    //检测数字 A 的第 k 位：A & (1 << (k - 1)) != 0
}
