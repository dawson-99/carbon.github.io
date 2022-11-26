package com.change.controller;

import com.change.pojo.Tree;
import com.change.pojo.User;
import com.change.service.TreeService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TreeController {

    @Autowired
    private TreeService treeService;

    @PostMapping("/addTree")
    public Map<String,Object> addTree(@RequestParam("userId") String userId, @RequestParam("treeType") String treeType) {
        Map<String,Object> map=new HashMap<>();
        String info = treeService.addTree(userId, treeType);
        map.put("info",info);
        return map;
    }

    @PostMapping("/queryMyTree")
    public Map<String,Object> myTree(@RequestParam("userId") String userId) {
        Map<String,Object> map=new HashMap<>();
        List<Tree> treeList = treeService.queryMyTree(userId);
        map.put("info","true");
        map.put("treeList",treeList);
        return map;
    }
}
