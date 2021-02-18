package com.yiguan.common.utils;

import java.util.Arrays;

/**
 * 门禁卡工具类
  *@Author 俞晨钟
  *@Date: Created in 2020/12/25 9:57
  */
public class ConverterTool {

    public static byte[] longToBytes(long var0, int var2, boolean var3) {
        byte[] var4 = new byte[8];
        boolean var5 = false;
        boolean var6 = false;
        int var8;
        if(var3) {
            var8 = 56;
        } else {
            var8 = 0;
        }

        for(int var9 = 0; var9 < 8; ++var9) {
            var4[var9] = (byte)((int)(var0 >> var8));
            if(var3) {
                var8 -= 8;
            } else {
                var8 += 8;
            }
        }

        if(var3) {
            if(var2 > 8) {
                byte[] var7 = new byte[var2];
                System.arraycopy(var4, 0, var7, var2 - 8, 8);
                return var7;
            } else {
                return Arrays.copyOfRange(var4, 8 - var2, 8 - var2 + var2);
            }
        } else {
            return Arrays.copyOf(var4, var2);
        }
    }

    public static long BytesTolong(byte[] var0, boolean var1) {
        boolean var2 = false;
        long var3 = 0L;
        int var6;
        if(var1) {
            if(var0.length > 8) {
                var0 = Arrays.copyOfRange(var0, var0.length - 8, var0.length);
            } else {
                byte[] var5 = new byte[8];
                System.arraycopy(var0, 0, var5, 8 - var0.length, var0.length);
                var0 = Arrays.copyOf(var5, 8);
            }

            var6 = 0;
        } else {
            var0 = Arrays.copyOf(var0, 8);
            var6 = 7;
        }

        for(int var7 = 0; var7 < 8; ++var7) {
            var3 += (long)uByte(var0[var6]);
            if(var7 < 7) {
                var3 <<= 8;
            }

            if(var1) {
                ++var6;
            } else {
                --var6;
            }
        }

        return var3;
    }

    public static int uByte(byte var0) {
        return var0 & 255;
    }

    public static long uInt(int var0) {
        return Long.parseLong(Integer.toHexString(var0), 16);
    }

    public static byte[] BytetoBits(byte var0, boolean var1) {
        int var2 = uByte(var0);
        byte[] var3 = new byte[8];

        for(int var4 = 0; var4 < 8; ++var4) {
            if(var1) {
                var3[7 - var4] = (byte)(var2 % 2);
            } else {
                var3[var4] = (byte)(var2 % 2);
            }

            var2 /= 2;
        }

        return var3;
    }

    public static byte BitstoByte(byte[] var0, boolean var1) {
        boolean var2 = false;
        boolean var3 = false;
        int var4 = 0;
        int var7;
        if(var1) {
            if(var0.length > 8) {
                var0 = Arrays.copyOfRange(var0, var0.length - 8, var0.length);
            } else {
                byte[] var5 = new byte[8];
                System.arraycopy(var0, 0, var5, 8 - var0.length, var0.length);
                var0 = Arrays.copyOf(var5, 8);
            }

            var7 = 0;
        } else {
            var0 = Arrays.copyOf(var0, 8);
            var7 = 7;
        }

        for(int var6 = 0; var6 < 8; ++var6) {
            var4 += var0[var7];
            if(var6 < 7) {
                var4 <<= 1;
            }

            if(var1) {
                ++var7;
            } else {
                --var7;
            }
        }

        return (byte)var4;
    }

    public static void BytestoBits(byte[] var0, byte[] var1, int var2) {
        BytestoBits(var0, var1, var2, true);
    }

    public static void BytestoBits(byte[] var0, byte[] var1, int var2, boolean var3) {
        int var5 = 0;
        Arrays.fill(var1, (byte)0);

        for(int var7 = 0; var7 < var0.length; ++var7) {
            byte[] var6 = BytetoBits(var0[var7], var3);
            if(var5 + 8 <= var2) {
                System.arraycopy(var6, 0, var1, var5, 8);
            } else {
                System.arraycopy(var6, 0, var1, var5, var2 - var5);
            }

            var5 += 8;
            if(var5 >= var2) {
                break;
            }
        }

    }

    public static void BitsToBytes(byte[] var0, byte[] var1, int var2) {
        BitsToBytes(var0, var1, var2, true);
    }

    public static void BitsToBytes(byte[] var0, byte[] var1, int var2, boolean var3) {
        boolean var4 = false;
        int var5 = 0;
        Arrays.fill(var0, (byte)0);
        byte[] var6 = new byte[8];

        for(int var7 = 0; var7 < var2; var7 += 8) {
            System.arraycopy(var1, var7, var6, 0, 8);
            var0[var5++] = BitstoByte(var6, var3);
        }

    }

    public static String Byte2Hex(byte[] var0) {
        char[] var1 = new char[var0.length * 2];
        int var2 = 0;
        char[] var4 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            for(int var5 = 0; var5 < var0.length; ++var5) {
                int var3 = uByte(var0[var5]);
                var1[var2++] = var4[var3 / 16];
                var1[var2++] = var4[var3 % 16];
            }

            return (new String(var1)).toUpperCase();
        } catch (Exception var6) {
            return new String();
        }
    }

    public static byte[] Hex2Byte(String var0) {
        int var2 = 0;
        if(var0.length() % 2 == 1) {
            var0 = "0" + var0;
        }

        byte[] var4 = new byte[128];
        byte[] var5 = "0123456789abcdef".getBytes();

        int var1;
        for(var1 = 0; var1 < var5.length; ++var1) {
            var4[var5[var1]] = (byte)var1;
        }

        var5 = "ABCDEF".getBytes();

        for(var1 = 0; var1 < var5.length; ++var1) {
            var4[var5[var1]] = (byte)(var1 + 10);
        }

        byte[] var6 = new byte[var0.length() / 2];
        byte[] var7 = var0.getBytes();

        for(var1 = 0; var1 < var7.length; ++var1) {
            int var3 = var4[var7[var1++]] * 16;
            var3 += var4[var7[var1]];
            var6[var2] = (byte)var3;
            ++var2;
        }

        return var6;
    }

    public static String BytesToString(byte[] var0) {
        String var1 = "";

        for(int var3 = 0; var3 < var0.length; ++var3) {
            int var2 = uByte(var0[var3]);
            if(var3 != var0.length - 1) {
                var1 = var1 + var2 + ",";
            } else {
                var1 = var1 + var2;
            }
        }

        return var1;
    }
}
