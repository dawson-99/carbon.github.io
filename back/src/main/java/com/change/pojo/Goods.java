package com.change.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("goods")
public class Goods {

    private String goodsId;
    private String goodsName;
    private double goodsScore;
    private String goodsPic;
}
