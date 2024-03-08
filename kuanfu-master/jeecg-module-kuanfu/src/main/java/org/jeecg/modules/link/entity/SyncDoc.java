package org.jeecg.modules.link.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@TableName("sync_doc")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class SyncDoc {
    private int id;
    private String number;
    private int state;
}
