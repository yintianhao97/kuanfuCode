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
 * @Description: 库存组织 
 * @Author: jeecg-boot
 * @Date:   2024-02-02
 * @Version: V1.0
 */
@Data
@TableName("bd_calbody")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="bd_calbody对象", description="库存组织 ")
public class BdCalbody {
    
	/**aheaddays*/
	@Excel(name = "aheaddays", width = 15)
    @ApiModelProperty(value = "aheaddays")
	private java.lang.Integer aheaddays;
	/**area*/
	@Excel(name = "area", width = 15)
    @ApiModelProperty(value = "area")
	private java.lang.String area;
	/**bodycode*/
	@Excel(name = "bodycode", width = 15)
    @ApiModelProperty(value = "bodycode")
	private java.lang.String bodycode;
	/**bodyname*/
	@Excel(name = "bodyname", width = 15)
    @ApiModelProperty(value = "bodyname")
	private java.lang.String bodyname;
	/**createdate*/
	@Excel(name = "createdate", width = 15)
    @ApiModelProperty(value = "createdate")
	private java.lang.String createdate;
	/**def1*/
	@Excel(name = "def1", width = 15)
    @ApiModelProperty(value = "def1")
	private java.lang.String def1;
	/**def2*/
	@Excel(name = "def2", width = 15)
    @ApiModelProperty(value = "def2")
	private java.lang.String def2;
	/**def3*/
	@Excel(name = "def3", width = 15)
    @ApiModelProperty(value = "def3")
	private java.lang.String def3;
	/**def4*/
	@Excel(name = "def4", width = 15)
    @ApiModelProperty(value = "def4")
	private java.lang.String def4;
	/**def5*/
	@Excel(name = "def5", width = 15)
    @ApiModelProperty(value = "def5")
	private java.lang.String def5;
	/**dr*/
	@Excel(name = "dr", width = 15)
    @ApiModelProperty(value = "dr")
	private java.lang.Integer dr;
	/**isuseretail*/
	@Excel(name = "isuseretail", width = 15)
    @ApiModelProperty(value = "isuseretail")
	private java.lang.String isuseretail;
	/**pkAddress*/
	@Excel(name = "pkAddress", width = 15)
    @ApiModelProperty(value = "pkAddress")
	private java.lang.String pkAddress;
	/**pkAreacl*/
	@Excel(name = "pkAreacl", width = 15)
    @ApiModelProperty(value = "pkAreacl")
	private java.lang.String pkAreacl;
	/**pkCalbody*/
	@Excel(name = "pkCalbody", width = 15)
    @ApiModelProperty(value = "pkCalbody")
	private java.lang.String pkCalbody;
	/**pkCorp*/
	@Excel(name = "pkCorp", width = 15)
    @ApiModelProperty(value = "pkCorp")
	private java.lang.String pkCorp;
	/**property*/
	@Excel(name = "property", width = 15)
    @ApiModelProperty(value = "property")
	private java.lang.Integer property;
	/**rationmny*/
	@Excel(name = "rationmny", width = 15)
    @ApiModelProperty(value = "rationmny")
	private java.math.BigDecimal rationmny;
	/**sealflag*/
	@Excel(name = "sealflag", width = 15)
    @ApiModelProperty(value = "sealflag")
	private java.lang.String sealflag;
	/**ts*/
	@Excel(name = "ts", width = 15)
    @ApiModelProperty(value = "ts")
	private java.lang.String ts;
	/**vnote*/
	@Excel(name = "vnote", width = 15)
    @ApiModelProperty(value = "vnote")
	private java.lang.String vnote;
}
