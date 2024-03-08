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
import org.jeecg.modules.link.entity.IaBillB;
import org.jeecg.modules.link.service.IIaBillBService;
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
 * @Description: 存货档案
 * @Author: jeecg-boot
 * @Date:   2024-01-31
 * @Version: V1.0
 */
@Slf4j
@Api(tags="存货档案")
@RestController
@RequestMapping("/link/iaBillB")
public class IaBillBController extends JeecgController<IaBillB, IIaBillBService> {
	@Autowired
	private IIaBillBService iaBillBService;
	
	/**
	 * 分页列表查询
	 *
	 * @param iaBillB
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "存货档案-分页列表查询")
	@ApiOperation(value="存货档案-分页列表查询", notes="存货档案-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(IaBillB iaBillB,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<IaBillB> queryWrapper = QueryGenerator.initQueryWrapper(iaBillB, req.getParameterMap());
		Page<IaBillB> page = new Page<IaBillB>(pageNo, pageSize);
		IPage<IaBillB> pageList = iaBillBService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 * 添加
	 *
	 * @param iaBillB
	 * @return
	 */
	@AutoLog(value = "存货档案-添加")
	@ApiOperation(value="存货档案-添加", notes="存货档案-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody IaBillB iaBillB) {
		iaBillBService.save(iaBillB);
		return Result.OK("添加成功！");
	}
	
	/**
	 * 编辑
	 *
	 * @param iaBillB
	 * @return
	 */
	@AutoLog(value = "存货档案-编辑")
	@ApiOperation(value="存货档案-编辑", notes="存货档案-编辑")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<?> edit(@RequestBody IaBillB iaBillB) {
		iaBillBService.updateById(iaBillB);
		return Result.OK("编辑成功!");
	}
	
	/**
	 * 通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "存货档案-通过id删除")
	@ApiOperation(value="存货档案-通过id删除", notes="存货档案-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		iaBillBService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 * 批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "存货档案-批量删除")
	@ApiOperation(value="存货档案-批量删除", notes="存货档案-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.iaBillBService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功！");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "存货档案-通过id查询")
	@ApiOperation(value="存货档案-通过id查询", notes="存货档案-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		IaBillB iaBillB = iaBillBService.getById(id);
		return Result.OK(iaBillB);
	}

  /**
   * 导出excel
   *
   * @param request
   * @param iaBillB
   */
  @RequestMapping(value = "/exportXls")
  public ModelAndView exportXls(HttpServletRequest request, IaBillB iaBillB) {
      return super.exportXls(request, iaBillB, IaBillB.class, "存货档案");
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
      return super.importExcel(request, response, IaBillB.class);
  }

}
