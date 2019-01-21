package com.qianfengsix.hotel.user.controller;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import com.qianfengsix.hotel.bean.ResultBean;
import com.qianfengsix.hotel.sendmessage.IndustrySMS;
import com.qianfengsix.hotel.user.pojo.User;
import com.qianfengsix.hotel.user.service.UserService;
import com.qianfengsix.hotel.utils.FileUpLoadUtils;
import com.qianfengsix.hotel.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 05
 * 星期一 <-> 下午 2:45
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JedisPool jedisPool;
    //返回类型
    ResultBean resultBean = new ResultBean();

    @CrossOrigin
    @RequestMapping("/adduser")
    public void addUser(User user) {
        userService.addUser(user);
    }

    @CrossOrigin
//    得到手机验证码 6位
    @RequestMapping("/getmobilecode")
    public ResultBean getMobileCode(String user_mobile) {
        boolean mobile = StringUtils.isMobile(user_mobile);
        if (!mobile) {
            return ResultBean.setError(200, "fail", "手机格式不对");
        }
        Jedis jedis = jedisPool.getResource();
        if(jedis.exists("qianfengsix"+user_mobile)){
            return ResultBean.setError(200,"fail" ,"请不要频繁发送哦");
        }
        String s = jedis.get("qianfengsix" + user_mobile);
        String code = StringUtils.RandomMobileString(6);
//        通过redis缓存 进行存贮 登录信息  缓存中的key  是 qianfengsix+mobile
        jedis.sadd("qianfengsix" + user_mobile, code);
//        设置有效期 一分钟
        jedis.expire("qianfengsix" + user_mobile, 120);
        IndustrySMS.execute(user_mobile, code);
        jedis.close();
        return ResultBean.setOk(100, "success", "发送成功");
//        return ResultBean.setOk(100,"success" ,code);
     //   return ResultBean.setOk(100,"success" , code);
    }

    @CrossOrigin
//    手机号进行登录
    @RequestMapping("/login")
    private ResultBean Login(String user_mobile, String code) {
        boolean mobile = StringUtils.isMobile(user_mobile);
        if (!mobile) {
            return ResultBean.setError(200, "fail", "手机号格式不对");
        }
        if (StringUtils.IsEmpty(code)) {
            return ResultBean.setError(200, "验证码不能为空", null);
        }
        return userService.Login(user_mobile, code);
    }

    //    接受用户用户头像二进制数据,存入服务器,返回地址,并将地址存入数据库.
    @RequestMapping("/updateuer_img")
    public ResultBean updateUser_img(MultipartFile file) {
        String user_img = null;
//        StringBuffer sb = new StringBuffer("ceshi.qfjava.cn");
        try {
//            group....
            user_img = FileUpLoadUtils.fileOnload(file);
            System.out.println(user_img+"------>");
//            sb = sb.append(user_img);
        } catch (Exception e) {
//   因为工具类以及服务器而引起错误
            resultBean.setCode(200);
            resultBean.setMessage("更换头像失败");
            e.printStackTrace();
        }
        try {
            userService.updateUser_img(user_img);
            resultBean.setCode(100);
            resultBean.setMessage("更换头像成功");
            resultBean.setData(user_img);
        } catch (Exception e) {
            //这里异常判断应该更加精确,进过测试后再做修改.因为数据库操作引起错误
            resultBean.setCode(200);
            resultBean.setMessage("更换头像失败");
            e.getMessage();
        }
        return resultBean;
    }

    //    实现用户昵称的修改
    @RequestMapping("/updateuser_nickname")
    public ResultBean updateUser_nickname(String user_nickname) {
        try {
            userService.updateUser_nickname(user_nickname);
            resultBean.setCode(100);
            resultBean.setMessage("修改用户昵称成功");
            resultBean.setData(user_nickname);
        } catch (Exception e) {
            resultBean.setCode(200);
            resultBean.setMessage("修改用户昵称失败");
            resultBean.setData(StringUtils.getRandomString(7));
            e.printStackTrace();
        }
        return resultBean;
    }

    //    实现绑定手机号的修改
    @RequestMapping("/updateuser_mobile")
    public ResultBean updateUser_mobile(String mobile, String code) {
        try {
            userService.updateUser_mobile(mobile, code);
            resultBean.setCode(100);
            resultBean.setMessage("修改手机号成功");
        } catch (Exception e) {
            resultBean.setCode(200);
            resultBean.setMessage("修改手机号失败");
            e.printStackTrace();
        }
        return resultBean;
    }

    @RequestMapping("/adduser_identify")
    public ResultBean addUser_identify(String user_identify) {
        try {
            userService.addUser_identify(user_identify);
            resultBean.setCode(100);
            resultBean.setMessage("添加用户身份成功");
        } catch (Exception e) {
            resultBean.setCode(200);
            resultBean.setMessage("添加用户身份失败");
            e.printStackTrace();
        }
        return resultBean;
    }

//    @RequestMapping("/testmo")
//    public String testMo( @Pattern(regexp="^[1][3,4,5,8][0-9]{9}$",message="手机号格式不对")String mobile){
//        System.out.println("hah"+mobile);
//        return mobile;
//    }

}
