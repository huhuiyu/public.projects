# public.projects

## 后台接口说明

- [ajax测试工具](http://demo.ajaxtool.huhuiyu.top)
- 后台应答统一格式为

  ```json
    {
       "code":"整数应答代码",
       "message":"服务器应答消息",
       "success":"true或者false，应答是否为成功",
       "token":"服务器token",
       "datas":"应答附加的数据"
    }
  ```

  其中code,success是必然存在的字段，其它字段根据业务逻辑决定,token字段为客户端凭证，如果接口声明需要token就必须传递该字段(测试工具会自动处理)
  
- 演示服务器接口地址为：`http://demo.huhuiyu.top/projectsdataservice`
- 接口列表
  - echo url：`/`  
  参数：`{"echo":"可选参数"}`  
  应答：`message字段为echo参数值,datas.now为系统当前时间戳`  
  - 管理员登录 url：`/TbAdmin/login`，需要token  
  参数：`{"tbAdmin.username":"登录名","tbAdmin.password":"md5加密后的password"}`  
  应答：`success字段判断是否成功`  
  - 管理员登出 url：`/TbAdmin/logout`，需要token  
  参数：`{}`  
  应答：`success字段判断是否成功`  
  - 获取登录信息 url：`/TbAdmin/getAdminInfo`，需要token  
  参数：`{}`  
  应答：`没有登录datas字段为{}，否则包含datas.admin字段`  