package cn.fyypumpkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = "cn.fyypumpkin")
@ServletComponentScan(basePackages = "cn.fyypumpkin.controller")
public class TransitoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransitoryApplication.class, args);
    }
}
