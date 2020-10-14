package com.foodorder.controller;

import com.foodorder.util.ResultBean;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping(value="/fileUpload")
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);


    @Value("${upload.maxsize}")
    private int uploadMaxSize;

    @Value(("${vsftpd.host}"))
    private String hostname;

    @Value(("${vsftpd.port}"))
    private Integer port;

    @Value(("${vsftpd.username}"))
    private String username;

    @Value(("${vsftpd.password}"))
    private String password;


    @RequestMapping(value="/upload")
    public ResultBean<String> upload(@RequestParam(value = "file") MultipartFile file){
        String path = "";
        if(!file.isEmpty()){
            if (file.getSize() > uploadMaxSize * 1024 * 1024) {
                return ResultBean.error("上传的文件不能超过" + uploadMaxSize + "M");
            }
            FTPClient ftpClient = new FTPClient();
            try {
                String imagefileFileName = file.getOriginalFilename();
                ftpClient.setControlEncoding("UTF-8");

                //链接ftp服务器
                ftpClient.connect(hostname, port);
                //登录ftp
                ftpClient.login(username, password);

                int reply = ftpClient.getReplyCode();
                //如果reply返回230就算成功了，如果返回530密码用户名错误或当前用户无权限下面有详细的解释。
                if (!FTPReply.isPositiveCompletion(reply)) {
                    ftpClient.disconnect();
                    return ResultBean.success("连接ftp 失败!!");
                }
                //ftpClient.changeWorkingDirectory("/images");
                //FTP.BINARY_FILE_TYPE
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

                // ftpClient.makeDirectory("path");//在root目录下创建文件夹
                path =  System.currentTimeMillis()+"_"+imagefileFileName;
                InputStream input = file.getInputStream();
                ftpClient.storeFile(path, input);//文件你若是不指定就会上传到root目录下
                input.close();
                ftpClient.logout();

            } catch (Exception e){
                logger.error(e.getMessage());
                return ResultBean.success(e.getMessage());
            } finally {
                if (ftpClient.isConnected()) {
                    try {
                        ftpClient.disconnect();
                    } catch (Exception ioe) {
                        ioe.printStackTrace();
                    }
                }
            }
        }
        return ResultBean.success(path);
    }


}
