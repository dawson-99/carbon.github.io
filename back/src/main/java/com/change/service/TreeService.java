package com.change.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.change.pojo.Tree;

import java.util.List;

public interface TreeService extends IService<Tree> {

    public String addTree(String userId,String treeType);

    public List<Tree> queryMyTree(String userId);
}
