package com.yiguan.common.core.domain.entity;

import com.yiguan.common.utils.ConverterTool;

import java.util.Arrays;
import java.util.Random;

/**
 * 门禁卡
  *@Author 俞晨钟
  *@Date: Created in 2020/12/25 9:57
  */
public class FC8800frame {

    private static int MAX_DATA_COUNT = 340;
    byte[] mFrame;
    private String mSN;
    private String mPassword;
    private int mSource;
    private byte mCmdType;
    private byte mCmdIndex;
    private byte mCmdPar;
    private int mDataLen;
    private byte[] mCmdData;
    private byte mCheckData;


    FC8800frame() {
    }

    FC8800frame(String var1, String var2, int var3, int var4, int var5) {
        int var6 = this.GetRndNum();
        this.CreateFrame(var1, var2, var6, var3, var4, var5, 0, new byte[0]);
    }

    public FC8800frame(String var1, String var2, int var3, int var4, int var5, int var6, int var7, byte[] var8) {
        this.CreateFrame(var1, var2, var3, var4, var5, var6, var7, var8);
    }

    public void CreateFrame(String var1, String var2, int var3, int var4, int var5, int var6, int var7, byte[] var8) {
        this.SetSN(var1);
        this.SetPassword(var2);
        this.SetSource(var3);
        this.SetCmdType((short)var4);
        this.SetCmdIndex((short)var5);
        this.SetCmdPar((short)var6);
        this.SetDataLen(var7);
        if(var7 > 0) {
            this.SetDatabuff(var8);
        }

        this.Create();
    }

    public void SetSN(String var1) {
        this.mSN = var1;
    }

    public String GetSN() {
        return this.mSN;
    }

    public void SetPassword(String var1) {
        this.mPassword = var1;
    }

    public String GetPassword() {
        return this.mPassword;
    }

    public void SetSource(int var1) {
        this.mSource = var1;
    }

    public int GetSource() {
        return this.mSource;
    }

    public void SetCmdType(short var1) {
        this.mCmdType = (byte)var1;
    }

    public int GetCmdType() {
        return ConverterTool.uByte(this.mCmdType);
    }

    public void SetCmdIndex(short var1) {
        this.mCmdIndex = (byte)var1;
    }

    public int GetCmdIndex() {
        return ConverterTool.uByte(this.mCmdIndex);
    }

    public void SetCmdPar(short var1) {
        this.mCmdPar = (byte)var1;
    }

    public int GetCmdPar() {
        return ConverterTool.uByte(this.mCmdPar);
    }

    public void SetDataLen(int var1) {
        this.mDataLen = var1;
    }

    public int GetDataLen() {
        return this.mDataLen;
    }

    public void SetDatabuff(byte[] var1) {
        this.mCmdData = Arrays.copyOf(var1, var1.length);
    }

    public byte[] GetDatabuff() {
        return Arrays.copyOf(this.mCmdData, this.mCmdData.length);
    }

    public int GetCheckData() {
        return ConverterTool.uByte(this.mCheckData);
    }

    public void SetDatabuffSize(int var1) {
        this.mCmdData = new byte[var1];
    }

    public void SetDataValue(int var1, byte var2) {
        this.mCmdData[var1] = var2;
    }

    public void SetDataValue(int var1, byte[] var2) {
        for(int var3 = 0; var3 < var2.length; ++var3) {
            this.mCmdData[var1 + var3] = var2[var3];
        }

    }

    public byte[] GetFrame() {
        return Arrays.copyOf(this.mFrame, this.mFrame.length);
    }

    private int GetRndNum() {
        Random var1 = new Random(System.currentTimeMillis());
        long var2 = (long)(var1.nextDouble() * 2.146369536E9D);
        return (int)(var2 + 268435456L);
    }

    public boolean Create() {
        boolean var3 = false;
        boolean var4 = false;
        int var8 = 31 + this.mDataLen + 1 + 2;
        byte[] var1 = new byte[var8];
        var1[0] = 126;
        var1[var8 - 1] = 126;
        byte var9 = 1;
        byte[] var2 = this.mSN.getBytes();
        System.arraycopy(var2, 0, var1, var9, 16);
        int var10 = var9 + 16;
        var2 = ConverterTool.Hex2Byte(this.mPassword);
        System.arraycopy(var2, 0, var1, var10, 4);
        var10 += 4;
        var2 = ConverterTool.longToBytes(ConverterTool.uInt(this.mSource), 4, true);
        System.arraycopy(var2, 0, var1, var10, 4);
        var10 += 4;
        var1[var10++] = this.mCmdType;
        var1[var10++] = this.mCmdIndex;
        var1[var10++] = this.mCmdPar;
        var2 = ConverterTool.longToBytes(ConverterTool.uInt(this.mDataLen), 4, true);
        System.arraycopy(var2, 0, var1, var10, 4);
        var10 += 4;
        int var5;
        if(this.mDataLen > 0) {
            for(var5 = 0; var5 < this.mDataLen; ++var5) {
                var1[var10++] = this.mCmdData[var5];
            }
        }

        long var6 = 0L;

        for(var5 = 1; var5 < var8 - 2; ++var5) {
            var6 += (long)ConverterTool.uByte(var1[var5]);
        }

        this.mCheckData = (byte)((int)(var6 % 256L));
        var1[var10] = this.mCheckData;
        this.mFrame = this.TranslateCommandFrame(var1);
        return true;
    }

    private byte[] TranslateCommandFrame(byte[] var1) {
        int var3 = 1;
        byte[] var2 = new byte[var1.length * 2];
        var2[0] = var1[0];

        int var4;
        for(var4 = 1; var4 < var1.length - 1; ++var4) {
            int var5 = ConverterTool.uByte(var1[var4]);
            switch(var5) {
                case 126:
                    var2[var3++] = 127;
                    var2[var3++] = 1;
                    break;
                case 127:
                    var2[var3++] = 127;
                    var2[var3++] = 2;
                    break;
                default:
                    var2[var3++] = var1[var4];
            }
        }

        var2[var3++] = var1[var4];
        return Arrays.copyOf(var2, var3);
    }
}
