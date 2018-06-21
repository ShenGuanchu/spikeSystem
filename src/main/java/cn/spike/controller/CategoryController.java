package cn.spike.controller;

import cn.spike.po.DataGrid;
import cn.spike.po.Category;
import cn.spike.po.Page;
import cn.spike.service.CategoryService;
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
@RequestMapping(value = "/category",produces = {"application/json;charset=UTF-8"} )
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(categoryService.list(page));
//        dataGrid.setTotal(CategoryService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(Category category) {
        try {
            categoryService.add(category);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Category category) {
        category.setId(id);
        try {
            categoryService.update(category);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            categoryService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/ddllist")
    @ResponseBody
    public String ddllist() {
        return JSON.toJSONString(categoryService.list(new Page()));
    }
}
