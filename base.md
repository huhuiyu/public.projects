# 接口统一说明

- [返回](README.md)

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

  其中code,success是必然存在的字段，其它字段根据业务逻辑决定  
  token字段为客户端凭证，如果接口声明需要token就必须传递该字段(测试工具会自动处理)  
  如果code为1000，表示接口需要登录才能访问  

- 分页对象格式为

  ```json
  {
    "pageCount": "总页数",
    "pageNumber": "当前页码",
    "pageSize": "分页大小",
    "total": "总记录数"
  }
  ```

- 演示服务器接口地址为：`http://demo.huhuiyu.top/projectsdataservice`