package com.cl.code;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author chengliang
 * @since 2022/12/26 22:57
 */
@Data
@TableName("image_group")
public class ImageGroupInfo {

    @TableId(value = "id")
    private Long id;

    @TableField(value = "href")
    private String href;

    @TableField(value = "img")
    private String img;

    @TableField(value = "alt")
    private String alt;

    @TableField(value = "time")
    private String time;

    public ImageGroupInfo(Long id, String href, String img, String alt, String time) {
        this.id = id;
        this.href = href;
        this.img = img;
        this.alt = alt;
        this.time = time;
    }

}
