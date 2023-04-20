package com.example.ymo;

import com.example.ymo.load.LoadFromFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

public class YmoApplication {
    static LoadFromFile l;
    public static void main(String[] args) throws Exception {
        l= new LoadFromFile();
        System.out.println(l.toString());
        SpringApplication.run(YmoApplication.class, args);
    }
}
