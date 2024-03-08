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
import org.jeecg.modules.link.entity.ArapDjfb;
import org.jeecg.modules.link.service.IArapDjfbService;
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
 * @Description: 付款单副表
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@Slf4j
@Api(tags="付款单副表")
@RestController
@RequestMapping("/link/arapDjfb")
public class ArapDjfbController extends JeecgController<ArapDjfb, IArapDjfbService> {
	@Autowired
	private IArapDjfbService arapDjfbService;
	
	/**
	 * 分页列表查询
	 *
	 * @param arapDjfb
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "付款单副表-分页列表查询")
	@ApiOperation(value="付款单副表-分页列表查询", notes="付款单副表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(ArapDjfb arapDjfb,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<ArapDjfb> queryWrapper = QueryGenerator.initQueryWrapper(arapDjfb, req.getParameterMap());
		Page<ArapDjfb> page = new Page<ArapDjfb>(pageNo, pageSize);
		IPage<ArapDjfb> pageList = arapDjfbService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 * 添加
	 *
	 * @param arapDjfb
	 * @return
	 */
	@AutoLog(value = "付款单副表-添加")
	@ApiOperation(value="付款单副表-添加", notes="付款单副表-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody ArapDjfb arapDjfb) {
		arapDjfbService.save(arapDjfb);
		return Result.OK("添加成功！");
	}
	
	/**
	 * 编辑
	 *
	 * @param arapDjfb
	 * @return
	 */
	@AutoLog(value = "付款单副表-编辑")
	@ApiOperation(value="付款单副表-编辑", notes="付款单副表-编辑")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<?> edit(@RequestBody ArapDjfb arapDjfb) {
		arapDjfbService.updateById(arapDjfb);
		return Result.OK("编辑成功!");
	}
	
	/**
	 * 通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "付款单副表-通过id删除")
	@ApiOperation(value="付款单副表-通过id删除", notes="付款单副表-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		arapDjfbService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 * 批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "付款单副表-批量删除")
	@ApiOperation(value="付款单副表-批量删除", notes="付款单副表-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.arapDjfbService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功！");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "付款单副表-通过id查询")
	@ApiOperation(value="付款单副表-通过id查询", notes="付款单副表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		ArapDjfb arapDjfb = arapDjfbService.getById(id);
		return Result.OK(arapDjfb);
	}

  /**
   * 导出excel
   *
   * @param request
   * @param arapDjfb
   */
  @RequestMapping(value = "/exportXls")
  public ModelAndView exportXls(HttpServletRequest request, ArapDjfb arapDjfb) {
      return super.exportXls(request, arapDjfb, ArapDjfb.class, "付款单副表");
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
      return super.importExcel(request, response, ArapDjfb.class);
  }

}
