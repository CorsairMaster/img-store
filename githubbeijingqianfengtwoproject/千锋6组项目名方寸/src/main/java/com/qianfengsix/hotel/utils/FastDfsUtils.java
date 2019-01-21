package com.qianfengsix.hotel.utils;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.IOException;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 02
 * 星期五 <-> 下午 3:40
 */
public class FastDfsUtils {
    private static TrackerClient trackerClient;
    private static TrackerServer trackerServer;
    private static StorageServer storageServer;
    public FastDfsUtils(String configfile) throws IOException, MyException {

//        进行初始化  加载配置文件
        ClientGlobal.init("confads.properties");
//        创建Client
        trackerClient = new TrackerClient();
//        获取连接
        trackerServer = trackerClient.getConnection();
    }
    //    参数   文件的byte数组    后缀名
    public String fileUpload(byte[] bs, String ext_name) throws Exception{
        return fileUpload(bs,ext_name,null );
    }

    private String fileUpload(byte[] bs, String ext_name, NameValuePair[] nameValuePair) throws Exception {
//     创建StorageClient
        StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
//        上传文件
        String[] resultStrings =storageClient1.upload_file(bs, ext_name, nameValuePair);
//        得到  string数组  第一个是向导  第二个是路径
        StringBuffer stringBuffer = new StringBuffer();
//        进行拼接路径  向导+路径
        for (int i = 0; i < resultStrings.length; i++) {
            stringBuffer.append(resultStrings[i]);
            if(i==0){
                stringBuffer.append("/");
            }
        }
//        返回路径
        return stringBuffer.toString();
    }
}
