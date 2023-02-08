package com.change.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("score")
public class Score {
    private String id;
    private double transportation;
    private double traffic;
    private double eating;
    private double shopping;
    private double sleeping;
    private double playing;
    private double answering;
    private double compensating;
    private double point;

    public Score(String id) {
        this.id = id;
    }

    public double addAll(){
        return transportation+traffic+eating+shopping+sleeping+playing;
    }
}
