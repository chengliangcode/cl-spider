package com.cl.code;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;
import java.util.stream.Collectors;

public class GithubRepoPageProcessor implements PageProcessor {

    public static String web = "https://www.yuleba.org";

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    @Override
    public void process(Page page) {
        List<String> all = page.getHtml().css("p").css("img", "src").all();
        if (!all.isEmpty()) {
            for (String s : all) {
                page.putField(s, s);
            }
        }
        List<String> collect = page.getHtml().css("div.paging").css("a", "href").all().stream().distinct().filter(item -> !item.isEmpty()).collect(Collectors.toList());
        page.addTargetRequests(collect);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new GithubRepoPageProcessor()).addUrl(web + "/a/211-5048-0.html").addPipeline(new MyPipeline()).thread(5).run();
    }

}