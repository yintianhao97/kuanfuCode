package org.jeecg.modules.link.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 钉钉用户信息维护
 * @Author: jeecg-boot
 * @Date:   2024-02-29
 * @Version: V1.0
 */
@Data
@TableName("dingtalk_user_info")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="dingtalk_user_info对象", description="钉钉用户信息维护")
public class DingtalkUserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
	/**U8C登录手机*/
	@Excel(name = "U8C登录手机", width = 15)
    @ApiModelProperty(value = "U8C登录手机")
    private java.lang.String u8cPhone;
	/**U8C登录名称*/
	@Excel(name = "U8C登录名称", width = 15)
    @ApiModelProperty(value = "U8C登录名称")
    private java.lang.String u8cUserCode;
	/**钉钉UserId*/
	@Excel(name = "钉钉UserId", width = 15)
    @ApiModelProperty(value = "钉钉UserId")
    private java.lang.String dingUserId;
	/**U8C账户pk*/
	@Excel(name = "U8C账户pk", width = 15)
    @ApiModelProperty(value = "U8C账户pk")
    private java.lang.String u8cUserPk;
}
