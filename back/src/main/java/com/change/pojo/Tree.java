package com.change.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("score")
public class Tree {

    private String treeId;
    private String userId;
    private String treeName;
    private Date startTime;
    private double efficient;
    private String pic;

    public Tree(String treeId, String userId, String treeName, Date startTime, double efficient) {
        this.treeId = treeId;
        this.userId = userId;
        this.treeName = treeName;
        this.startTime = startTime;
        this.efficient = efficient;
    }
}
