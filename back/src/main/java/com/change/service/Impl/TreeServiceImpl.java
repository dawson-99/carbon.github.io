package com.change.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.change.mapper.TreeMapper;
import com.change.pojo.Tree;
import com.change.service.TreeService;
import com.change.utils.IDutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TreeServiceImpl extends ServiceImpl<TreeMapper, Tree> implements TreeService {

    @Autowired
    private TreeMapper treeMapper;

    @Override
    public String addTree(String userId, String treeType) {
        Tree tree=new Tree();
        switch (treeType){
            case "t001":
                tree.setTreeName("白皮松");
                tree.setEfficient(0.822);
                tree.setPic("cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/白皮松.jpg");
                break;
            case "t002":
                tree.setTreeName("栓皮栎");
                tree.setEfficient(1.123);
                tree.setPic("cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/栓皮栎.jpg");
                break;
            case "t003":
                tree.setTreeName("油松");
                tree.setEfficient(0.876);
                tree.setPic("cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/油松.jpg");
                break;
            case "t004":
                tree.setTreeName("雄株毛白杨");
                tree.setEfficient(1.370);
                tree.setPic("cloud://cloud1-1ggq1xwm698c7bd4.636c-cloud1-1ggq1xwm698c7bd4-1307039632/images/tree/雄株毛白杨.jpg");
                break;
            default:
                tree.setTreeName("默认");
                tree.setEfficient(0);
                break;
        }
        tree.setUserId(userId);
        tree.setTreeId(IDutils.getId());
        tree.setStartTime(new Date());
        treeMapper.addTree(tree);
        return "true";
    }

    @Override
    public List<Tree> queryMyTree(String userId) {

        return treeMapper.queryByUserId(userId);
    }
}
