package com.marstalk.alibabadruid.dao;

import com.marstalk.alibabadruid.domain.User;
import com.marstalk.alibabadruid.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTests {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testInsert() {

        ExecutorService executorService = new ThreadPoolExecutor(50, 50, 1000, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        UserDao userDao = applicationContext.getBean(UserDao.class);

        List<Future<User>> futures = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            Future<User> futureResult = executorService.submit(new UserService(userDao, new User()));
            futures.add(futureResult);
        }
        log.info("commit finished");
        for (Future<User> futrue : futures) {
            log.info("get user: " + futrue.isDone());
        }

    }

}
