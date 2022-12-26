package com.cl.code;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @author chengliang
 * @since 2022/11/2 23:16
 */
public class MyPipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        for (String s : resultItems.getAll().keySet()) {
            System.out.println("<img src=\"" + s + "\">");
        }
    }
}
