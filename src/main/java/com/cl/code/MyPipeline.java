package com.cl.code;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;

/**
 * @author chengliang
 * @since 2022/11/2 23:16
 */
@Component
public class MyPipeline implements Pipeline {

    @Resource
    private ImageGroupInfoMapper imageGroupInfoMapper;

    @Override
    public void process(ResultItems resultItems, Task task) {
        resultItems.getAll().forEach((key, imageGroupInfo) -> {
            imageGroupInfoMapper.insert((ImageGroupInfo) imageGroupInfo);
        });
    }
}
