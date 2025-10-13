package cn.wenzhuo4657.dailyWeb.controller.mdEdit;


import cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dao.MdRepository;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dto.ItemDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController(value = "md")
public class mdController {


    @Autowired
    private MdRepository mdRepository;


    /**
     * 获取基本文档（即日报）所有数据，无需指定参数
     */
    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<ItemDto> getMd() {

        return mdRepository.getMd();
    }




//    /**
//     * 读取md文本文件进行下载
//     */
//    @RequestMapping(
//
//            method = RequestMethod.GET,
//            produces = "text/markdown; charset=UTF-8"
//    )
//    public String editMd() {
//        try {
//            Path filePath= Main.getFilePath();
//            String text = Files.readString(filePath);
//            return text;
//        }catch (IOException e){
//            log.error("读取文件失败",e);
//            return "读取文件失败";
//        }
//
//    }
//
//
//
//    /**
//     * 从客户端获取md文本进行保存
//     */
//
//    @RequestMapping(
//            method = RequestMethod.PUT,
//            consumes = "text/markdown; charset=UTF-8",
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public boolean saveMd(@RequestBody() String md) {
//        try {
//            Path filePath= Main.getFilePath();
//            Files.writeString(filePath, md);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//
//    }
//
//
//    /**
//     * 直链下载md文本文件
//     */
//    @RequestMapping(
//            value = "DownLoadFile",
//            method = RequestMethod.GET,
//            produces = "text/markdown; charset=UTF-8"
//    )
//    public ResponseEntity<Resource> DownLoadFile() {
//        try {
//
//            Path filePath= Main.getFilePath();
//            long size = Files.size(filePath);
//            InputStreamResource body = new InputStreamResource(Files.newInputStream(filePath));
//
//            ContentDisposition cd = ContentDisposition.attachment()
//                    .filename(filePath.getFileName().toString(), StandardCharsets.UTF_8)
//                    .build();
//
//
//            ResponseEntity<Resource> res = ResponseEntity.ok()
//                    .contentType(MediaType.parseMediaType("text/markdown; charset=UTF-8"))
//                    .header(HttpHeaders.CONTENT_DISPOSITION, cd.toString())
//                    .header(HttpHeaders.CACHE_CONTROL, "no-store") // 按需调整缓存策略
//                    .contentLength(size)
//                    .body(body);
//
//            return res;
//        }catch (IOException e){
//            log.error("下载文件失败",e);
//            return ResponseEntity.status(500).body(null);
//        }
//    }
//
//    /**
//     * 上传md文本文件
//     */
//    @PostMapping(
//            value = "/upload",
//            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
//
//
//        Path filePath = Main.getFilePath();
//
//        if (file == null || file.isEmpty()) {
//            return ResponseEntity.badRequest().body("{\"error\":\"文件为空\"}");
//        }
////        String original = StringUtils.cleanPath(file.getOriginalFilename() == null ? "" : file.getOriginalFilename());
////        if (original.isEmpty()) {
////            return ResponseEntity.badRequest().body("{\"error\":\"缺少文件名\"}");
////        }
//
//        Files.writeString(filePath, new String(file.getBytes()));
//
//
//
//        return ResponseEntity.ok().build();
//    }




}
