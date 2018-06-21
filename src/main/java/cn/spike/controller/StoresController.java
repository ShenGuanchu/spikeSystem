package cn.spike.controller;

import cn.spike.po.DataGrid;
import cn.spike.po.Stores;
import cn.spike.po.Page;
import cn.spike.service.StoresService;
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
@RequestMapping(value = "/stores",produces = {"application/json;charset=UTF-8"} )
public class StoresController {

    @Autowired
    StoresService storesService;

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(storesService.list(page));
//        dataGrid.setTotal(StoresService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(Stores stores) {
        try {
            storesService.add(stores);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Stores stores) {
        stores.setId(id);
        try {
            storesService.update(stores);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            storesService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }
    
    @RequestMapping("/ddllist")
    @ResponseBody
    public String ddllist() {
        return JSON.toJSONString(storesService.list(new Page()));
    }
}
