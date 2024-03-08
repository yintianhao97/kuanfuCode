import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: 'U8C登录手机',
    align:"center",
    dataIndex: 'u8cPhone'
   },
   {
    title: 'U8C登录名称',
    align:"center",
    dataIndex: 'u8cUserCode'
   },
   {
    title: '钉钉UserId',
    align:"center",
    dataIndex: 'dingUserId'
   },
   {
    title: 'U8C账户pk',
    align:"center",
    dataIndex: 'u8cUserPk'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "U8C登录手机",
      field: 'u8cPhone',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "U8C登录名称",
      field: 'u8cUserCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "钉钉UserId",
      field: 'dingUserId',
      component: 'Input',
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: 'U8C登录手机',
    field: 'u8cPhone',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入U8C登录手机!'},
          ];
     },
  },
  {
    label: 'U8C登录名称',
    field: 'u8cUserCode',
    component: 'Input',
    dynamicDisabled:true
  },
  {
    label: '钉钉UserId',
    field: 'dingUserId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入钉钉UserId!'},
          ];
     },
  },
  {
    label: 'U8C账户pk',
    field: 'u8cUserPk',
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
  u8cPhone: {title: 'U8C登录手机',order: 0,view: 'text', type: 'string',},
  u8cUserCode: {title: 'U8C登录名称',order: 1,view: 'text', type: 'string',},
  dingUserId: {title: '钉钉UserId',order: 2,view: 'text', type: 'string',},
  u8cUserPk: {title: 'U8C账户pk',order: 3,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}