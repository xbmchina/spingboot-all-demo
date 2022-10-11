package cn.xbmcloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author xiebaoming
 * @date 2022/10/10
 * @apiNote
 */
@RestController
public class ActuatorController {

    private int stackLength = 1;

    @GetMapping("/user/info/{id}")
    public ResponseEntity<Map<String, Object>> queryUserInfoById(@PathVariable("id") long id)
            throws InterruptedException {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", "shawn");
        map.put("realname", "shawn");
        map.put("age", 25);
        for (int i = 0; i < 100000; i++) {
            int finalI = i;
            new Thread(() -> {
                map.put(finalI + "id", finalI);
            }).start();
        }
        return ResponseEntity.ok(map);
    }

    @GetMapping("/user/list")
    public ResponseEntity<List<Map<String, Object>>> listUser()
            throws InterruptedException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", i);
            map.put("username", "shawn_" + i);
            map.put("realname", "shawn_" + i);
            map.put("age", 25 + i);
            list.add(map);
            new Thread(() -> {
                try {
                    Thread.sleep(10000);
                    System.out.println("信息科技法律上的军阀的是");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(2);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/user/add")
    public ResponseEntity<List<ActuatorController>> addUser()
            throws InterruptedException {
        List<ActuatorController> list = new ArrayList<>();
        while (true) {
            list.add(new ActuatorController());
        }
    }


    @GetMapping("/user/update")
    public ResponseEntity<String> updateUser()
            throws InterruptedException {
        stackLeak();
        return ResponseEntity.ok("success");
    }


    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

}
