package cn.xbmcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author xiebaoming
 * @date 2022/10/10
 * @apiNote
 */
@SpringBootApplication
@Slf4j
@ServletComponentScan
public class ActuatorDemoApp {
    public static void main(String[] args) {
        SpringApplication.run(ActuatorDemoApp.class, args);
        log.info("启动成功");
    }
}
