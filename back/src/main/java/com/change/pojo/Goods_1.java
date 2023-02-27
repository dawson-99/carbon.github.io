package com.change.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("goods")
public class Goods_1 {

    @TableField("goodsId")
    private String goodsId;
    @TableField("goodsName")
    private String goodsName;
    @TableField("goodsScore")
    private double goodsScore;
    @TableField("goodsPic")
    private String goodsPic;
}
