package group.bison.sentinel.demo.service;

import org.springframework.stereotype.Service;

/**
 * Created by BSONG on 2019/6/30.
 */
@Service
public class DemoService {

    public String test() {
        return "test";
    }

    public String test01() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        return "test01";
    }

    public String test02() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return "test02";
    }

    public String test03() throws Exception {
        throw new RuntimeException("报错");
    }
}
