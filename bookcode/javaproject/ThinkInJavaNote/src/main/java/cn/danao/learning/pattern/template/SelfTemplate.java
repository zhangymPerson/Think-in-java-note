package cn.danao.learning.pattern.template;

import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/4/17 11:33 <br/>
 * descriptionclass <br/>
 * 自定义template
 * <p>
 * 模板定义规则 - 其他实现类 然后 执行 doSomething();
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public abstract class SelfTemplate {

    /**
     * 做某件事
     */
    public final void doSomething() {
        //只定义步骤规则，不定义步骤实现，有实现类自己实现
        log.info("模板顺序类");
        one();
        two();
        three();
    }

    abstract void one();

    abstract void two();

    abstract void three();
}
