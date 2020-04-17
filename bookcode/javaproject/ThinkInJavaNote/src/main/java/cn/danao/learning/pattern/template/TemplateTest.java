package cn.danao.learning.pattern.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * date 2020/4/17 11:48 <br/>
 * descriptionclass <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class TemplateTest {

    @Test
    public void test() {
        SelfTemplate selfTemplate = new DoTemplateImpl();
        run(selfTemplate);
        SelfTemplate selfTemplate1 = new DoTwoTemplateImpl();
        run(selfTemplate1);
    }

    /**
     * 模拟业务过程
     */
    private void run(SelfTemplate selfTemplate) {
        log.info("业务开始");
        selfTemplate.doSomething();
        log.info("业务结束");
    }

}
