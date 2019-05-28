package com.bysj.controller;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 29029
 * @Version 1.0
 * @Time 20:04
 */
@Controller
@RequestMapping("upload")
public class UploadController {


    @RequestMapping(value = "/saveFile")
    @ResponseBody
    public HashMap<String, Object> saveUser(HttpServletRequest request, HttpServletResponse response) {
        Integer relId = request.getParameter("relId")!=null&&!"".equals(request.getParameter("relId")) ? new Integer(request.getParameter("relId")) : null;
        HashMap<String, Object> map =  new HashMap<String, Object>();
        // 文件保存目录URL
        String saveUrl = "/upload/";
        // 文件保存目录路径
        String savePath = request.getServletContext().getRealPath("/");
        savePath = savePath.substring(0, savePath.length() - 1);
        savePath = savePath.substring(0, savePath.lastIndexOf("\\"));
        savePath += saveUrl;
        // 定义允许上传的文件扩展名
        HashMap<String, String> extMap = new HashMap<String, String>();
        extMap.put("image", "gif,jpg,jpeg,png,bmp");
        // 最大文件大小
        long maxSize = 2000000000;
        String dirName = "image";
        // 创建文件夹
        savePath += dirName + "/";
        saveUrl += dirName + "/";
        File saveDirFile = new File(savePath);
        if (!saveDirFile.exists()) {
            saveDirFile.mkdirs();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String ymd = sdf.format(new Date());
        savePath += ymd + "/";
        saveUrl += ymd + "/";
        File dirFile = new File(savePath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        List items = null;
        try {
            items = upload.parseRequest((RequestContext) request);
        } catch (FileUploadException e1) {
            e1.printStackTrace();
        }
        Iterator itr = items.iterator();
        String newFileName = "";
        while (itr.hasNext()) {
            FileItem item = (FileItem) itr.next();
            String fileName = item.getName();
            long fileSize = item.getSize();

            if (!item.isFormField()) {
                // 检查文件大小
                if (item.getSize() > maxSize) {
                    map.put("msg", "上传文件大小超过限制。");
                    return map;
                }
                // 检查扩展名
                String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                try {
                    Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt);
                } catch (Exception e) {
                    System.out.println(e);
                }
                if (!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)) {
                    map.put("msg", "上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。");
                    return map;
                }

                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000)+"." + fileExt;
                try {
                    File uploadedFile = new File(savePath, newFileName);
                    item.write(uploadedFile);
                } catch (Exception e) {
                    System.out.println(e);
                    map.put("msg", "上传文件失败。");
                    return map;
                }
            }
        }
        return map;
    }

}