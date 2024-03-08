package org.jeecg.modules.link.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.link.entity.PoOrderB;
import org.jeecg.modules.link.service.IPoOrderBService;
import java.util.Date;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 /**
 * @Description: 采购订单表体
 * @Author: jeecg-boot
 * @Date:   2024-02-26
 * @Version: V1.0
 */
@Slf4j
@Api(tags="采购订单表体")
@RestController
@RequestMapping("/link/poOrderB")
public class PoOrderBController extends JeecgController<PoOrderB, IPoOrderBService> {
	@Autowired
	private IPoOrderBService poOrderBService;
	
	/**
	 * 分页列表查询
	 *
	 * @param poOrderB
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "采购订单表体-分页列表查询")
	@ApiOperation(value="采购订单表体-分页列表查询", notes="采购订单表体-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(PoOrderB poOrderB,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<PoOrderB> queryWrapper = QueryGenerator.initQueryWrapper(poOrderB, req.getParameterMap());
		Page<PoOrderB> page = new Page<PoOrderB>(pageNo, pageSize);
		IPage<PoOrderB> pageList = poOrderBService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 * 添加
	 *
	 * @param poOrderB
	 * @return
	 */
	@AutoLog(value = "采购订单表体-添加")
	@ApiOperation(value="采购订单表体-添加", notes="采购订单表体-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody PoOrderB poOrderB) {
		poOrderBService.save(poOrderB);
		return Result.OK("添加成功！");
	}
	
	/**
	 * 编辑
	 *
	 * @param poOrderB
	 * @return
	 */
	@AutoLog(value = "采购订单表体-编辑")
	@ApiOperation(value="采购订单表体-编辑", notes="采购订单表体-编辑")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<?> edit(@RequestBody PoOrderB poOrderB) {
		poOrderBService.updateById(poOrderB);
		return Result.OK("编辑成功!");
	}
	
	/**
	 * 通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "采购订单表体-通过id删除")
	@ApiOperation(value="采购订单表体-通过id删除", notes="采购订单表体-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		poOrderBService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 * 批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "采购订单表体-批量删除")
	@ApiOperation(value="采购订单表体-批量删除", notes="采购订单表体-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.poOrderBService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功！");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "采购订单表体-通过id查询")
	@ApiOperation(value="采购订单表体-通过id查询", notes="采购订单表体-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		PoOrderB poOrderB = poOrderBService.getById(id);
		return Result.OK(poOrderB);
	}

  /**
   * 导出excel
   *
   * @param request
   * @param poOrderB
   */
  @RequestMapping(value = "/exportXls")
  public ModelAndView exportXls(HttpServletRequest request, PoOrderB poOrderB) {
      return super.exportXls(request, poOrderB, PoOrderB.class, "采购订单表体");
  }

  /**
   * 通过excel导入数据
   *
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
  public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
      return super.importExcel(request, response, PoOrderB.class);
  }

}
