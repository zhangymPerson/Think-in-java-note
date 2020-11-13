package cn.danao.main;


import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

/**
 * date 2020/7/19 12:20 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        System.out.println("java main() -  混编代码");

    }

    @Test
    public void test() {
        run("");
    }

    public void run(@NotNull String str) {
        log.info("test");
    }
}
