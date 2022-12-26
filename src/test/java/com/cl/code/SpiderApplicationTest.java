package com.cl.code;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import us.codecraft.webmagic.Spider;

import javax.annotation.Resource;

/**
 * @author chengliang
 * @since 2022/12/26 23:27
 */
@SpringBootTest
public class SpiderApplicationTest {

    @Resource
    private MyPipeline myPipeline;

    @Test
    public void test() {
        Spider.create(new GithubRepoPageProcessor()).addUrl(GithubRepoPageProcessor.web + "/b/211-0.html").addPipeline(myPipeline).thread(5).run();
    }

}
