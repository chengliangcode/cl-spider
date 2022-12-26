package com.cl.code;

import com.cl.code.util.IdGeneratorUtil;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;
import java.util.stream.Collectors;

public class GithubRepoPageProcessor implements PageProcessor {

    public static String web = "https://www.yuleba.org";

    @Override
    public void process(Page page) {
        List<Selectable> lis = page.getHtml().xpath("//div[@class='b_img']").css("li").nodes();
        for (Selectable selectable : lis) {
            String href = selectable.css("a", "href").get();
            String img = selectable.css("img", "src").get();
            String alt = selectable.css("img", "alt").get();
            String time = selectable.regex("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}").get();
            href = web + href;
            page.putField(href, new ImageGroupInfo(IdGeneratorUtil.generateId(),href, img, alt, time));
        }
        List<String> collect = page.getHtml().css("div.paging").css("a", "href").all().stream().distinct().filter(item -> !item.isEmpty()).collect(Collectors.toList());
        page.addTargetRequests(collect);
    }

    @Override
    public Site getSite() {
        return Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);
    }

}