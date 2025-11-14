package cn.wenzhuo4657.dailyWeb.tigger.http;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.ItemEditService;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.*;
import cn.wenzhuo4657.dailyWeb.types.utils.AuthUtils;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller("item")
@ResponseBody
@Validated
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemEditService itemEditService;

    @PostMapping("/get")
    public List<ItemDto> getItems(@Valid @RequestBody QueryItemDto params) {
        
        return itemEditService.getItem(params, AuthUtils.getLoginId());
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertItem(@Valid @RequestBody InsertItemDto body) {
        boolean ok = itemEditService.insertItem(body, AuthUtils.getLoginId());
        return ResponseEntity.ok(Map.of("success", ok));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateItem(@Valid @RequestBody UpdateItemDto body) {
        boolean ok = itemEditService.updateItem(body,AuthUtils.getLoginId());
        return ResponseEntity.ok(Map.of("success", ok));
    }

    @PostMapping("/field/checklist/title")
    public ResponseEntity<?> updateChecklist(@Valid @RequestBody UpdateCheckListDto body) {
        boolean ok = itemEditService.CheckList(body);
        return ResponseEntity.ok(Map.of("success", ok));
    }

    @PostMapping("field/checklist/finish")
    public ResponseEntity<?> finishChecklist(@RequestParam("id") @NotNull @Min(0) Long id) {
        boolean ok = itemEditService.CheckListFinish(id);
        return ResponseEntity.ok(Map.of("success", ok));
    }
}
