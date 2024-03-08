package org.jeecg.modules.link.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @Description: 付款单同步
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@Data
@TableName("fukuan_link")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="fukuan_link对象", description="付款单同步")
public class FukuanLink {
    
	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
	private java.lang.String id;
	/**erpcode*/
	@Excel(name = "erpcode", width = 15)
    @ApiModelProperty(value = "erpcode")
	private java.lang.String erpcode;
	/**dingcode*/
	@Excel(name = "dingcode", width = 15)
    @ApiModelProperty(value = "dingcode")
	private java.lang.String dingcode;
	/**state*/
	@Excel(name = "state", width = 15)
    @ApiModelProperty(value = "state")
	private java.lang.String state;
	/**tlastmaketime*/
	@Excel(name = "tlastmaketime", width = 15)
    @ApiModelProperty(value = "tlastmaketime")
	private java.lang.String tlastmaketime;

	private String corp;

	private String erpcode2;
}
