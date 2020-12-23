package com.qc.online.diagnosis;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @Description:
 * @Author: wangyilong
 * @Date: 2020/12/14 15:38
 **/
@SpringBootApplication
@Slf4j
@MapperScan(basePackages = "com.qc.online.diagnosis.mapper")
public class OnlineVMAppplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineVMAppplication.class,args);
        log.info("statr service succ");
    }
}
