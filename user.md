# 用户信息接口

- [返回](README.md)
- 用户登录
  - echo url：`/`，不需要token  
    参数：`{"echo":"可选参数"}`  
    应答：`message字段为echo参数值,datas.now为系统当前时间戳`  
  - 管理员登录 url：`/TbAdmin/login` 
    参数：`{"tbAdmin.username":"登录名","tbAdmin.password":"md5加密后的password"}`  
    应答：`success字段判断是否成功`  
  - 管理员登出 url：`/TbAdmin/logout`  
    参数：`{}`  
    应答：`success字段判断是否成功`  
  - 获取登录信息 url：`/TbAdmin/getAdminInfo`  
    参数：`{}`  
    应答：`没有登录datas字段为{}，否则包含datas.admin字段`  
  - 修改密码 url：`/auth/admin/modifyPwd`，需要登录
    参数：

    ```json
    {
      "tbAdmin.password": "md5加密后的password",
      "oldPwd": "md5加密后的旧密码"
    }
    ```

    应答：`success字段判断是否成功`
