import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '公司编码',
    align:"center",
    dataIndex: 'corpCode'
   },
   {
    title: '公司名称',
    align:"center",
    dataIndex: 'gsmc'
   },
   {
    title: '公司pk',
    align:"center",
    dataIndex: 'corpPk'
   },
   {
    title: '库存组织pk',
    align:"center",
    dataIndex: 'chzz'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "公司编码",
      field: 'corpCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "公司pk",
      field: 'corpPk',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "库存组织pk",
      field: 'chzz',
      component: 'Input',
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '公司编码',
    field: 'corpCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入公司编码!'},
          ];
     },
  },
  {
    label: '公司名称',
    field: 'gsmc',
    component: 'Input',
    dynamicDisabled:true
  },
  {
    label: '公司pk',
    field: 'corpPk',
    component: 'Input',
    dynamicDisabled:true
  },
  {
    label: '库存组织pk',
    field: 'chzz',
    component: 'Input',
    dynamicDisabled:true
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];

// 高级查询数据
export const superQuerySchema = {
  corpCode: {title: '公司编码',order: 0,view: 'text', type: 'string',},
  gsmc: {title: '公司名称',order: 1,view: 'text', type: 'string',},
  corpPk: {title: '公司pk',order: 2,view: 'text', type: 'string',},
  chzz: {title: '库存组织pk',order: 3,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}