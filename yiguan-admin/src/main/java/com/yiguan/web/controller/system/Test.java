//package com.yiguan.web.controller.system;
//
//import com.yiguan.common.core.domain.entity.FC8800frame;
//import com.yiguan.common.utils.ConverterTool;
//
//import java.util.Arrays;
//import java.util.Random;
//
//public class Test
//{
//
//
//	public static void TestFrame()
//	{
//        int iSur=0xF6451C4D;
//        FC8800frame oFC = new FC8800frame("FC-8820A88888888","FFFFFFFF",iSur,2,1,0,0,new byte[1]);
//        String sHex = ConverterTool.Byte2Hex( oFC.GetFrame() );
//        System.out.println("读取时间指令：\n" + sHex + "\n");
//        //SendTCPData(oFC.GetFrame()); 发送数据到网络上
//
//
//        //模拟接收数据
//        byte buf[];
//        int i;
//        //buf =ReadTCPData()；//从网络上读取数据包
//        buf=ConverterTool.Hex2Byte("7E1E35886646432D38383130413433303630303231FFFFFFFF37030100000021000000B1E711117FFF260730154401010101FFFF100000000000FF000000000000F07E" +  //正确的命令
//                "7EF6451C4D46432D38383230413838383838383838FFFFFFFF32010000074716070314FA7E");//错误命令
//        FC8800frame oRet=null;
//
//
//        for(  i=0;i<buf.length;i++)
//        {
//            boolean bret=FC8800frameCompile.CompileData(buf[i]);
//            if(bret)
//            {
//                oRet=FC8800frameCompile.GetRxFrame();
//                //数据处理完毕，校验和正确
//                System.out.println( "返回值解析完毕，格式详解：" );
//                String sRtn;
//                sRtn="SN:" + oRet.GetSN();
//                sRtn+="\n通讯密码:" + oRet.GetPassword();
//                sRtn+="\n信息代码:" + Integer.toHexString( oRet.GetSource() );
//                sRtn+="\n命令类型：" + oRet.GetCmdType();
//                sRtn+="\n命令索引：" + oRet.GetCmdIndex();
//                sRtn+="\n命令参数：" + oRet.GetCmdPar();
//                sRtn+="\n数据长度：" + oRet.GetDataLen();
//                if( oRet.GetDataLen()>0 )
//                {
//                    sRtn+="\n数据内容：" + ConverterTool.Byte2Hex( oRet.GetDatabuff() );
//                }
//                System.out.println( sRtn );
//
//                //对返回值进行解析判断
//                if (oRet.GetSource() == iSur)  //判断是否是此命令返回，判断信息代码是否相等
//                {
//
//                    //判断是否是读取时间命令返回值
//                    if ( oRet.GetCmdType() == 0x32 & oRet.GetCmdIndex() == 1 & oRet.GetCmdPar() ==0)
//                    {
//                        if (oRet.GetDataLen() == 7) //判断长度是否正确
//                        {
//                            //根据读取时间的返回包数据格式进行解析
//                            //时间格式：ssmmHHddMMWWyy，秒分时日月周年
//                            String sTime = ConverterTool.Byte2Hex( oRet.GetDatabuff() );
//                            sRtn = "20" + sTime.substring(12,14);
//                            sRtn += "-" + sTime.substring(8,10);
//                            sRtn += "-" + sTime.substring(6,8);
//                            sRtn += " " + sTime.substring(4,6);
//                            sRtn += ":" + sTime.substring(2,4);
//                            sRtn += ":" + sTime.substring(0,2);
//                            sRtn += " 星期" + sTime.substring(10,12);
//
//                            sRtn="**时间：" + sRtn;
//                            System.out.println( sRtn );
//                        }
//                    }
//                }
//
//
//
//                System.out.println("解析完毕");
//                //继续解析数据包
//                oRet=null;
//            }
//        }
//    }
//
//
//    public static void main(String args[])
//    {
//
//        TestFrame();
//    }
//
//
//}
