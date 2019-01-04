package cn.itcast.controller;

import cn.itcast.domain.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.StyledEditorKit;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author hftang
 * @date 2019-01-04 9:15
 * @desc
 */
@RequestMapping(path = "/user")
@Controller
public class UserController {


    @RequestMapping("/hello")
    public String testHello() {
        System.out.println("---->hello");
        return "success";
    }

    //接受json数据
    @RequestMapping("/recejson")
    public @ResponseBody
    User receJson(@RequestBody User user) {
        System.out.println(user);
        user.setAge(18);
        user.setPwd("1234567");
        user.setName("hftang666");
        return user;
    }
    //跨域上传文件

    @RequestMapping(path = "/uploadfile03",method = RequestMethod.POST)
    public String uploadFilesMethod(MultipartFile upload) throws IOException {

        String path = "http://localhost:9090/fileuploadservice/uploads/";
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        Client client = Client.create();
        WebResource webResource = client.resource(path + filename);
        webResource.put(upload.getBytes());



        return "success";
    }


    //上传文件

    /**
     * 文件上传
     *
     * @return
     */
    @RequestMapping("/fileupload1")
    public String fileuoload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传...");

        // 使用fileupload组件完成文件上传
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断，该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            // 创建该文件夹
            file.mkdirs();
        }

        // 解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解析request
        List<FileItem> items = upload.parseRequest(request);
        // 遍历
        for (FileItem item : items) {
            // 进行判断，当前item对象是否是上传文件项
            if (item.isFormField()) {
                // 说明普通表单向
            } else {
                // 说明上传文件项
                // 获取上传文件的名称
                String filename = item.getName();
                // 把文件的名称设置唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
                // 完成文件上传
                item.write(new File(path, filename));
                // 删除临时文件
                item.delete();
            }
        }

        return "success";
    }

    //springmvc方式上传文件 本地上传

    @RequestMapping(path = "/uploadFiles")
    public String uploadFiles(HttpServletRequest request, MultipartFile upload) throws IOException {

        System.out.println("springmvc文件上传...");

        // 使用fileupload组件完成文件上传
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断，该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            // 创建该文件夹
            file.mkdirs();
        }

        // 说明上传文件项
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        // 完成文件上传
        upload.transferTo(new File(path, filename));


        return "success";
    }


}
