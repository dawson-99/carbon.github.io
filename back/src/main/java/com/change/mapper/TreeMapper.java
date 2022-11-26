package com.change.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.change.pojo.Tree;

import java.util.List;


public interface TreeMapper extends BaseMapper<Tree> {

    public List<Tree> queryByUserId(String userId);

    public void addTree(Tree tree);
}
