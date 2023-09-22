package vip.sujianfeng.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;


/**
 * @author SuJianFeng
 * @date 2022/3/19 8:46
 */
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"vip.sujianfeng"})
@EnableWebSocket
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

}
