package com.qianfengsix.hotel.user.service.impl;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

import com.qianfengsix.hotel.bean.ResultBean;
import com.qianfengsix.hotel.mapper.UserMapper;
import com.qianfengsix.hotel.user.pojo.User;
import com.qianfengsix.hotel.user.service.UserService;
import com.qianfengsix.hotel.utils.ShowObjectFiledVOUtils;
import com.qianfengsix.hotel.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;
import java.util.Set;

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 05
 * 星期一 <-> 下午 2:45
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JedisPool jedisPool;
    @Override
    public ResultBean Login(String user_mobile, String code) {
//        进行验证 手机号
//        把缓存中的手机号取出来
        Jedis jedis = jedisPool.getResource();
        Set<String> codes = jedis.smembers("qianfengsix" + user_mobile);
        if(codes.size()==0||codes==null){
            return ResultBean.setError(200,"请获取验证码",null);
        }
        if(!codes.contains(code)){
            return ResultBean.setError(200,"验证码错误",code);
        }
        User user = userMapper.findUserByUserMobile(user_mobile);
        String username = StringUtils.getRandomString(7);
        if(user==null){
            user = new User();
            user.setUser_mobile(user_mobile);
            user.setUser_nickname(username);
            userMapper.addUser(user);
        }
//        默认的图片头像
        user.setUser_img(user.getUser_img()==null?"/group1/M00/00/00/rBA6i1wKcZaAPE5IAAHJi8caXB8643.jpg":user.getUser_img());
        SecurityUtils.getSubject().getSession().setAttribute("user",user);
//        返回给 前台数据
        Map<String, String> map = ShowObjectFiledVOUtils.showObjectByShowAnno(user);
        jedis.del(user_mobile);
        jedis.close();
        return ResultBean.setOk(100,"登录成功",map);
    }
    @Override
    public void addUser(User user) {
            userMapper.addUser(user);
    }

//    实现用户头像的修改
    @Override
    public void updateUser_img(String user_img) {
        User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
        String user_mobile = user.getUser_mobile();
        System.out.println(user_mobile+"手机号----->");
        userMapper.updateUser_img(user_img,user_mobile);
    }

//    实现用户昵称的修改
    @Override
    public void updateUser_nickname(String user_nickname) {
        User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
        String user_mobile = user.getUser_mobile();
        userMapper.updateUser_nickname(user_nickname,user_mobile);
    }

//    实现用户手机号的修改并验证手机号是否已经存在,并且在修改时判断验证码是否正确
    @Override
    public ResultBean updateUser_mobile(String newUser_mobile,String code) {
        User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
        int user_id = user.getUser_id();
//        对验证码进行校验
        Jedis jedis = jedisPool.getResource();
        Set<String> codes = jedis.smembers("qianfengsix" + newUser_mobile);
        if(codes.size()==0||codes==null){
            return ResultBean.setError(200,"请获取验证码",null);
        }
        if(!codes.contains(code)){
            return ResultBean.setError(200,"验证码错误",code);
        }
        userMapper.updateUser_mobile(newUser_mobile,user_id);
        //对执行是否成功进行判断给出相应的返回值.
        return null;
    }

    @Override
    public void addUser_identify(String user_identify) {
        User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
        String user_mobile = user.getUser_mobile();
        userMapper.addUser_identify(user_identify,user_mobile);
    }
}
