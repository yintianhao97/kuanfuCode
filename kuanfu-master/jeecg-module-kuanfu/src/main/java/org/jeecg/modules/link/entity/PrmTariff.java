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
 * @Description: 价目表主表
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@Data
@TableName("prm_tariff")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="prm_tariff对象", description="价目表主表")
public class PrmTariff {
    
	/**bcurrenttariff*/
	@Excel(name = "bcurrenttariff", width = 15)
    @ApiModelProperty(value = "bcurrenttariff")
	private java.lang.String bcurrenttariff;
	/**ccreaterid*/
	@Excel(name = "ccreaterid", width = 15)
    @ApiModelProperty(value = "ccreaterid")
	private java.lang.String ccreaterid;
	/**cdefcurrencyid*/
	@Excel(name = "cdefcurrencyid", width = 15)
    @ApiModelProperty(value = "cdefcurrencyid")
	private java.lang.String cdefcurrencyid;
	/**cdefmeasdocid*/
	@Excel(name = "cdefmeasdocid", width = 15)
    @ApiModelProperty(value = "cdefmeasdocid")
	private java.lang.String cdefmeasdocid;
	/**cdownpricetariffid*/
	@Excel(name = "cdownpricetariffid", width = 15)
    @ApiModelProperty(value = "cdownpricetariffid")
	private java.lang.String cdownpricetariffid;
	/**cpricetariffcode*/
	@Excel(name = "cpricetariffcode", width = 15)
    @ApiModelProperty(value = "cpricetariffcode")
	private java.lang.String cpricetariffcode;
	/**cpricetariffid*/
	@Excel(name = "cpricetariffid", width = 15)
    @ApiModelProperty(value = "cpricetariffid")
	private java.lang.String cpricetariffid;
	/**cpricetariffname*/
	@Excel(name = "cpricetariffname", width = 15)
    @ApiModelProperty(value = "cpricetariffname")
	private java.lang.String cpricetariffname;
	/**dcreatedate*/
	@Excel(name = "dcreatedate", width = 15)
    @ApiModelProperty(value = "dcreatedate")
	private java.lang.String dcreatedate;
	/**dr*/
	@Excel(name = "dr", width = 15)
    @ApiModelProperty(value = "dr")
	private java.lang.Integer dr;
	/**fcurrencydim*/
	@Excel(name = "fcurrencydim", width = 15)
    @ApiModelProperty(value = "fcurrencydim")
	private java.lang.Integer fcurrencydim;
	/**fcustcldim*/
	@Excel(name = "fcustcldim", width = 15)
    @ApiModelProperty(value = "fcustcldim")
	private java.lang.Integer fcustcldim;
	/**fcustomerdim*/
	@Excel(name = "fcustomerdim", width = 15)
    @ApiModelProperty(value = "fcustomerdim")
	private java.lang.Integer fcustomerdim;
	/**finvclassdim*/
	@Excel(name = "finvclassdim", width = 15)
    @ApiModelProperty(value = "finvclassdim")
	private java.lang.Integer finvclassdim;
	/**finvdim*/
	@Excel(name = "finvdim", width = 15)
    @ApiModelProperty(value = "finvdim")
	private java.lang.Integer finvdim;
	/**fmeasdim*/
	@Excel(name = "fmeasdim", width = 15)
    @ApiModelProperty(value = "fmeasdim")
	private java.lang.Integer fmeasdim;
	/**frecareadim*/
	@Excel(name = "frecareadim", width = 15)
    @ApiModelProperty(value = "frecareadim")
	private java.lang.Integer frecareadim;
	/**fsaleorgdim*/
	@Excel(name = "fsaleorgdim", width = 15)
    @ApiModelProperty(value = "fsaleorgdim")
	private java.lang.Integer fsaleorgdim;
	/**pkCorp*/
	@Excel(name = "pkCorp", width = 15)
    @ApiModelProperty(value = "pkCorp")
	private java.lang.String pkCorp;
	/**ts*/
	@Excel(name = "ts", width = 15)
    @ApiModelProperty(value = "ts")
	private java.lang.String ts;
}
