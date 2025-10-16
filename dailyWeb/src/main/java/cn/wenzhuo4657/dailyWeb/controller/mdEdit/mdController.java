package cn.wenzhuo4657.dailyWeb.controller.mdEdit;


import cn.wenzhuo4657.dailyWeb.Main;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dao.MdRepository;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dto.InsertItemDto;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dto.UpdateItemDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller(value = "md")
@ResponseBody // 直接将响应值作为 HTTP 响应体正文，默认会走视图解析
@RequestMapping(value = "/md")
public class mdController {


    @Autowired
    private MdRepository mdRepository;


    /**
     * 获取基本文档（即日报）所有数据，无需指定参数
     */
    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<ItemDto> getMd() throws ClassNotFoundException {

        return mdRepository.getMd();
    }

    /**
     * 修改文档item
     */
    @RequestMapping(
            method = RequestMethod.PUT
    )
    public boolean updateItem(@RequestBody UpdateItemDto params) {

        if (params.getId() == null){
            return false;
        }


        mdRepository.updateMd( params);
        return true;

    }


    /**
     * 新增文档item条目
     */
    @RequestMapping(
            method = RequestMethod.POST
    )
    public boolean addItem(@RequestBody InsertItemDto params) throws ClassNotFoundException {
        mdRepository.addItem(params);
        return true;
    }











}
