package cn.spike.vo;
import java.math.BigDecimal;

import cn.spike.po.Item;

/**
 * Created by Ww on 2018/6/19.
 */
public class VoItem extends Item {

    private String voCategory;

    private String voStores;

    private String voDiscounttype;

    public VoItem() {
    }

    public VoItem(Item item) {
        this.setId(item.getId());
        this.setName(item.getName());
        this.setPrice(item.getPrice());
        this.setCategory(item.getCategory());
        this.setStock(item.getStock());
        this.setOrigin(item.getOrigin());
        this.setWeight(item.getWeight());
        this.setStores(item.getStores());
        this.setDiscounttype(item.getDiscounttype());


    }

    public String getVoCategory() {
        return voCategory;
    }

    public void setVoCategory(String voCategory) {
        this.voCategory = voCategory;
    }

    public String getVoStores() {
        return voStores;
    }

    public void setVoStores(String voStores) {
        this.voStores = voStores;
    }

    public String getVoDiscounttype() {
        return voDiscounttype;
    }

    public void setVoDiscounttype(String voDiscounttype) {
        this.voDiscounttype = voDiscounttype;
    }
}
