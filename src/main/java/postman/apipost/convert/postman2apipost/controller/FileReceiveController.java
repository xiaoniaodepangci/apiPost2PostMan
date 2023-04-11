package postman.apipost.convert.postman2apipost.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import postman.apipost.convert.postman2apipost.global.Data;
import postman.apipost.convert.postman2apipost.global.ResultJson;
import postman.apipost.convert.postman2apipost.postman.PostManJson;
import postman.apipost.convert.postman2apipost.service.PostManToApiPostService;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @ClassName: FileReceiveController
 * @Description: todo 添加描述
 * @Author: HC
 * @Date: 2022/12/31 16:44
 * @Version: 1.0
 * @Copy right
 */

@Controller
@RequestMapping("/")
public class FileReceiveController {
    @Autowired
    private PostManToApiPostService postManToApiPostService;
    //         定义文件存放的父文件夹路径
    private static String parentPath = "D:" + File.separator + "fileUpload";

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson upload(@RequestParam("file") MultipartFile file) throws IOException {
//        判断上传文件是否为空，若为空则返回错误信息
        ResultJson resultJson = new ResultJson();

        String newFilename = "";
        if (file.isEmpty()) {
            resultJson.setCode(1);
            resultJson.setMsg("失败");
            Data data = new Data();
            data.setSrc("");
            resultJson.setData(data);
            return resultJson;
        }

        String fileContents = new String(file.getBytes());
        PostManJson postManJson = JSONObject.parseObject(fileContents,
                PostManJson.class);
        String apiPostJson = postManToApiPostService.getApiPostJson(postManJson);

        String fileTempName = "apiPostJsonResult" + System.currentTimeMillis() / 1000 + ".json";
        String apiPostJsonResult = System.getProperty("user.dir") + File.separator + fileTempName;

        BufferedWriter bufferedWriter = null;
        try {
            Path path = Paths.get(apiPostJsonResult);
            if (Files.exists(path)) {
                Files.delete(path);
            }
            bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
            bufferedWriter.write(apiPostJson);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        resultJson.setCode(0);
        resultJson.setMsg("上传成功");
        Data data = new Data();
        data.setSrc(fileTempName);
        resultJson.setData(data);
        return resultJson;
    }


    @RequestMapping(value = "/download/{fileCode}", method = RequestMethod.GET)
    public void download(HttpServletResponse response, @PathVariable("fileCode") String fileCode) {
//        通过response输出流将文件传递到浏览器
//        1、获取文件路径
        String fileName = fileCode;
//2.构建一个文件通过Paths工具类获取一个Path对象
        Path path = Paths.get(System.getProperty("user.dir"), fileName);
        //判断文件是否存在
        if (Files.exists(path)) {
            //存在则下载
            //通过response设定他的响应类型
            //4.获取文件的后缀名
            String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);
//            5.设置contentType ,只有指定contentType才能下载
            response.setContentType("application/" + fileSuffix);
//            6.添加http头信息
//            因为fileName的编码格式是UTF-8 但是http头信息只识别 ISO8859-1 的编码格式
//            因此要对fileName重新编码
            try {
                response.addHeader("Content-Disposition", "attachment;filename="
                        + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
//            7.使用  Path 和response输出流将文件输出到浏览器
            try {
                Files.copy(path, response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
