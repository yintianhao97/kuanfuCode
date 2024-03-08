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
 * @Description: 单据类型记录
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@Data
@TableName("doc_type_link")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="doc_type_link对象", description="单据类型记录")
public class DocTypeLink {
    
	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
	private java.lang.String id;
	/**doctype*/
	@Excel(name = "doctype", width = 15)
    @ApiModelProperty(value = "doctype")
	private java.lang.String doctype;
	/**dingcode*/
	@Excel(name = "dingcode", width = 15)
    @ApiModelProperty(value = "dingcode")
	private java.lang.String dingcode;
	/**erpcode*/
	@Excel(name = "erpcode", width = 15)
    @ApiModelProperty(value = "erpcode")
	private java.lang.String erpcode;
}
