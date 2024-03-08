package org.jeecg;

import com.alibaba.fastjson.JSONObject;
import org.jeecg.common.util.RestUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年05月10日 14:02
 */
public class TestMain {
    public static void main(String[] args) {
        // 获取今天日期
        LocalDate today = LocalDate.now();
        // 定义日期格式化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 格式化日期并输出
        String formattedDate = today.format(formatter);

        System.out.println(formattedDate);
    }


}
