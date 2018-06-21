package cn.spike.controller;

import cn.spike.po.DataGrid;
import cn.spike.po.Item;
import cn.spike.po.Page;
import cn.spike.service.ItemService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ww on 2018/6/19.
 */
@Controller
@RequestMapping(value = "/item",produces = {"application/json;charset=UTF-8"} )
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(itemService.vo(itemService.list(page)));
//        dataGrid.setTotal(itemService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(Item item) {
        try {
            itemService.add(item);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Item item) {
        item.setId(id);
        try {
            itemService.update(item);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            itemService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }
}
