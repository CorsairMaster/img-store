package com.qianfengsix.hotel.wechatpay.utils;/**
*                                                                      : ,       
*                                  +7?==?O$~                           :7?,, :~=,
*                                +Z~       +Z~,                        :I+IIO+++ 
*                              ,7=,          7:,                       :?:~Z8=   
*                              :I,            7,                       +?~IZ,    
*                             ,I:   ?     ?    ?                  ,~+Z+ :~+      
*                              $,              I,             ,:~77~, ,I7=       
*                             :Z                ?:   :~~+?Z$7I+: ,,,~7+          
*                              $,                7Z7I+::         :?$+,            
*                             ,?+                           ,+7I=                 
*                              ,7:                   ,:,=N?~,                    
*                             :7$,                   IZI$?                       
*                           ?$+: ,                    ++                         
*                         ~$ ,                        ,:I~                       
*    ,                   7=                              :I$~                    
*   ,O+               =I7$7, , ,     ,                      ,77:,                
*   ,I7,            =$?, ,,O~  ~+O$#4=                        :=7~               
*~II$:+$= ,,,:++?I7?,     :I:OZ+, :~7I,,,                    ,:??7+ ,            
*+D77$$?+I?~,,,      ,,:+O$ ,        :+I=:,,               =8I~ ,,,Z+            
*     =Z7=+++++==+7TMO~                  ~$+,            :?=,,,,,,,,:?,          
*                                           :O?,      :, ?:, ,,,,,,,,,$:         
*                                             ,+I:,    ,?+,, ,,,,,,,,,,7=        
*                                                :I77~ :Z, ,,,,,,,,,,,,,,?=       
*                                                  ,,I= I,,,,,,,,,,,,,,,,,?+      
*                                                     :~,                 :=     
*                     哪错了？             错哪了？              我是谁？
*/

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shane Lau on 2018/11/06.
 */
public class ZxingUtil {
    /**
     * Zxing图形码⽣成⼯具
     *
     * @param contents
     * 内容
     * @param format
     * 图⽚格式，可选[png,jpg,bmp]
     * @param width
     * 宽
     * @param height
     * ⾼
     * @param saveImgFilePath* 存储图⽚的完整位置，包含⽂件名
     * @return
     */
    public static Boolean encode(String contents, String format, int width, int
            height, String saveImgFilePath) {
        Boolean bool = false;
        BufferedImage image = createImage(contents,width,height);
        if (image != null) {
            bool = writeToFile(image, format, saveImgFilePath);
        }
        return bool;
    }
    public static void encode(String contents, int width, int height) {
        createImage(contents,width, height);
    }
    public static BufferedImage createImage(String contents ,int width, int
            height) {
        BufferedImage bufImg=null;
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
// 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.MARGIN, 10);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        try {
// contents = new String(contents.getBytes("UTF-8"), "ISO-8859-1");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
                    BarcodeFormat.QR_CODE, width, height, hints);
            MatrixToImageConfig config = new MatrixToImageConfig(0xFF000001,
                    0xFFFFFFFF);
            bufImg = MatrixToImageWriter.toBufferedImage(bitMatrix, config);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufImg;
    }
    /**
     * 将BufferedImage对象写⼊⽂件
     *
     * @param bufImg
     * BufferedImage对象
     * @param format
     * 图⽚格式，可选[png,jpg,bmp]
     * @param saveImgFilePath
     * 存储图⽚的完整位置，包含⽂件名
     * @return
     */
    @SuppressWarnings("finally")
    public static Boolean writeToFile(BufferedImage bufImg, String format, String
            saveImgFilePath) {
        Boolean bool = false;
        try {
            bool = ImageIO.write(bufImg, format, new File(saveImgFilePath));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return bool;
        }
    }
}