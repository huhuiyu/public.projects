# 后台管理信息接口（没有特殊说明都需要登录）

- [返回](README.md)
- 分类查询 url：`/auth/teachtype/queryAll`
  参数：`{"page":"参考分页查询对象"}`  
  应答：`datas.list`为分类查询结果数组

  ```json
  {
    "datas.page":"参考分页对象格式",
    "datas.list":[
      {
          "enable": "是否启用，只有y/n两种值",
          "iconfont": "iconfont的值",
          "info": "分类描述",
          "lastupdate": "最后修改时间戳",
          "ttid": "分类id",
          "typeName": "分类名称"
      }
    ]
  }
  ```

- 分类添加 url：`/auth/teachtype/add`
  参数：

  ```json
  {
    "tbTeachType.iconfont": "iconfont的值",
    "tbTeachType.info": "分类描述",
    "tbTeachType.typeName": "分类名称"
  }
  ```

  应答：`success字段判断是否成功`  

- 分类修改 url `/auth/teachtype/update`
  参数：

  ```json
  {
    "tbTeachType.ttid":"分类id",
    "tbTeachType.iconfont": "iconfont的值",
    "tbTeachType.info": "分类描述",
    "tbTeachType.typeName": "分类名称",
    "tbTeachType.enable": "是否启用，只有y/n两种值"
  }
  ```

  应答：`success字段判断是否成功`  
- 小类查询 url：`/auth/teachsubtype/queryAll`
  参数：`{"page":"参考分页查询对象"}`  
  应答：`datas.list`为小类查询结果数组，`datas.types`为大类查询结果数组

  ```json
  {
    "datas.page":"参考分页对象格式",
    "datas.list":[
      {
          "enable": "是否启用，只有y/n两种值",
          "iconfont": "iconfont的值",
          "info": "小类描述",
          "lastupdate": "最后修改时间戳",
          "ttid": "所属大类id",
          "subtypeName": "小类名称",
          "tstid": "小类id"
      }
    ],
    "datas.types":[
      {
        "enable": "是否启用，只有y/n两种值",
        "iconfont": "iconfont的值",
        "info": "分类描述",
        "lastupdate": "最后修改时间戳",
        "ttid": "分类id",
        "typeName": "分类名称"
      }
    ]
  }
  ```
