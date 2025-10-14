package cn.wenzhuo4657.dailyWeb.controller.system;


import cn.wenzhuo4657.dailyWeb.Main;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@RestController(value = "system")
public class systemController {

    /**
     * 直链sqlite文件
     */
    @RequestMapping(
            value = "DownLoadFile",
            method = RequestMethod.GET
    )
    public ResponseEntity<Resource> DownLoadFile() {
        try {

            Path filePath= Main.getFilePath();
            long size = Files.size(filePath);
            InputStreamResource body = new InputStreamResource(Files.newInputStream(filePath));

            ContentDisposition cd = ContentDisposition.attachment()
                    .filename(filePath.getFileName().toString(), StandardCharsets.UTF_8)
                    .build();


            ResponseEntity<Resource> res = ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, cd.toString())
                    .header(HttpHeaders.CACHE_CONTROL, "no-store") // 按需调整缓存策略
                    .contentLength(size)
                    .body(body);

            return res;
        }catch (IOException e){
            log.error("下载文件失败",e);
            return ResponseEntity.status(500).body(null);
        }
    }

    /**
     * 上传sqlite，做系统恢复
     */
    @PostMapping(
            value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {


        Path filePath = Main.getFilePath();

        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("{\"error\":\"文件为空\"}");
        }
// TODO， 这里文件可以直接增删吗？

        Files.writeString(filePath, new String(file.getBytes()));



        return ResponseEntity.ok().build();
    }


}
