package cn.danao.learning.pattern.template;

import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/4/17 11:44 <br/>
 * descriptionclass <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class DoTemplateImpl extends SelfTemplate {

    @Override
    void one() {
        log.info("DoTemplateImpl 步骤1:*******");
    }

    @Override
    void two() {
        log.info("DoTemplateImpl 步骤2:*******");
    }

    @Override
    void three() {
        log.info("DoTemplateImpl 步骤3:*******");
    }
}
