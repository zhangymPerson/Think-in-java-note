package cn.danao.learning.tree;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Optional;

/**
 * date 2020/4/14 10:48 <br/>
 * descriptionclass <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class TreeTest {

    @Test
    public void test() {
        TreeNode one = new TreeNode();
        one.setId("1");
        TreeNode two = new TreeNode();
        two.setId("2");
        two.setParentId("1");
        Optional<TreeNode> optionalTwo = Optional.ofNullable(Optional.ofNullable(two).orElse(new TreeNode()));
        one.addSubNode(optionalTwo);
        log.info("{}",one);
    }
}
