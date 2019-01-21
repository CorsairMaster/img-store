package com.qianfengsix.hotel.utils;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 14
 * 星期三 <-> 下午 3:12
 */
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class FileUpLoadUtils {
    //         实现文件上传,获取存储地址
//         这里的参数名称要和form表单中的文件name属性相同.
    public static String  fileOnload(MultipartFile file) {
        String filePath=null;
        try {
            //创建存储操作端.
            ClientGlobal.init("confads.properties");
            TrackerClient trackerClient=new TrackerClient();
            TrackerServer trackerServer=trackerClient.getConnection();
            StorageServer storageServer=null;
            StorageClient1 storageClient1=new StorageClient1(trackerServer,storageServer);
            //实现上传文件3个参数,文件的字节格式 ,文件后缀名,文件的元 数据
            //获取文件的字节格式.
            byte[] file2 = file.getBytes();
            //获取文件名后缀
            String fileName=file.getOriginalFilename();
            String ext =fileName.substring(fileName.lastIndexOf(".") + 1);
            //得到路径的字符串数组格式.
            String[] paths = storageClient1.upload_file(file2, ext, null);
            StringBuffer stringBuffer=new StringBuffer("/");
            for (int i = 0; i < paths.length; i++) {
                stringBuffer.append(paths[i]);
                if (i==0){
                    stringBuffer.append("/");
                }
            }
            filePath=stringBuffer.toString();
            System.out.println(filePath);
        } catch (IOException e) {e.printStackTrace();

        } catch (MyException e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
