package com.qianfengsix.hotel.hotel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qianfengsix.hotel.bean.ResultBean;
import com.qianfengsix.hotel.card.pojo.Group2;
import com.qianfengsix.hotel.hotel.pojo.Group;
import com.qianfengsix.hotel.hotel.service.GroupService;
import com.qianfengsix.hotel.utils.FastDfsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by lcr on 2018/11/12 0012.
 */
@CrossOrigin
@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private FastDfsUtils fastDfsUtils;
    @CrossOrigin
    @RequestMapping(value = "/addgroup",method = {RequestMethod.POST})
    public ResultBean addGroup(@Valid Group group, MultipartFile multipartFiles, BindingResult bindingResult){
        boolean b=bindingResult.hasErrors();
        if (b){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                String defaultMessage = allError.getDefaultMessage();
                return ResultBean.setError(200,"fail" ,defaultMessage );
            }
        }

        /**
         *
         *
         */

        //上传图片
        String originalFilename = multipartFiles.getOriginalFilename();
        String lastname = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
            String fileUpload = fastDfsUtils.fileUpload(multipartFiles.getBytes(), lastname);
            Map<String,String> map=new HashMap<>();
            map.put("file", fileUpload);
            ObjectMapper objectMapper = new ObjectMapper();
            String a=objectMapper.writeValueAsString(map);
            group.setGroup_image(a);
            groupService.addGroup(group);
            return ResultBean.setOk(100, "success",group );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultBean.setError("插入团建项目失败！");

    }
    @CrossOrigin
    @RequestMapping("/findbypersonnum")
    public ResultBean findByPerSonNum(int group_personnum) {
        try {
            List<Group> group = groupService.findByPerSonNum(group_personnum);
            return ResultBean.setOk(100, "success", group);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ResultBean.setError(200,"fail","您的团建人数过多，无法容纳！");
    }


    @RequestMapping("/getallgroup")
    public ResultBean getAllGroup(Integer pageNum,Integer pageSize){
        pageNum = pageNum==null?1:pageNum;
        pageSize = pageSize==null?4:pageSize;
       List<Group2> list =  groupService.getAllGroup(pageNum,pageSize);
        return ResultBean.setOk(100,"success" ,list );
    }
}

