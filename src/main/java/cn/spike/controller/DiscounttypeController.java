package cn.spike.controller;

import cn.spike.po.Discounttype;
import cn.spike.po.DataGrid;
import cn.spike.po.Page;
import cn.spike.service.DiscounttypeService;
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
@RequestMapping(value = "/discounttype",produces = {"application/json;charset=UTF-8"} )
public class DiscounttypeController {

    @Autowired
    DiscounttypeService discounttypeService;

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(discounttypeService.list(page));
//        dataGrid.setTotal(DiscounttypeService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(Discounttype discounttype) {
        try {
            discounttypeService.add(discounttype);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Discounttype discounttype) {
        discounttype.setId(id);
        try {
            discounttypeService.update(discounttype);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            discounttypeService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }
    
    @RequestMapping("/ddllist")
    @ResponseBody
    public String ddllist() {
        return JSON.toJSONString(discounttypeService.list(new Page()));
    }
}
