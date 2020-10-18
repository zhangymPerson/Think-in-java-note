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
public class DoTwoTemplateImpl extends SelfTemplate {

    @Override
    void one() {
        log.info("DoTwoTemplateImpl 步骤1:*******");
    }

    @Override
    void two() {
        log.info("DoTwoTemplateImpl 步骤2:*******");
    }

    @Override
    void three() {
        log.info("DoTwoTemplateImpl 步骤3:*******");
    }
}
