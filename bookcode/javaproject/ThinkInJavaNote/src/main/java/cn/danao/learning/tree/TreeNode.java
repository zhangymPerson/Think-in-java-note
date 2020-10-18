package cn.danao.learning.tree;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * date 2020/4/14 10:38 <br/>
 * descriptionclass <br/>
 * 定义一个数的节点
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Data
@Slf4j
public class TreeNode {
    //节点id
    private String id;
    //父节点id
    private String parentId;

    //子节点
    private List<TreeNode> subList = new ArrayList<>();

    public void addSubNode(Optional<TreeNode> optionalTreeNode) {
        if (!optionalTreeNode.isPresent()) {
            return;
        }
        TreeNode node = optionalTreeNode.get();
        if (Objects.nonNull(node.parentId) && node.parentId.equals(id)) {
            subList.add(node);
        }else {
            log.error("子节点的父节点与当前节点不符 {} ！= {}",node,id);
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", subList=" + subList +
                '}';
    }
}
