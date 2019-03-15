# 后台管理信息接口（没有特殊说明都需要登录）

- [返回](README.md)
- 教学分类查询 url：`/auth/teachtype/queryAll`
  参数：`{"page":"参考分页查询对象"}`  
  应答：`datas.list`为分类查询结果数组

  ```json
  {
    "datas.page": "参考分页对象格式",
    "datas.list": [
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

- 教学分类添加 url：`/auth/teachtype/add`
  参数：

  ```json
  {
    "tbTeachType.iconfont": "iconfont的值",
    "tbTeachType.info": "分类描述",
    "tbTeachType.typeName": "分类名称"
  }
  ```

  应答：`success字段判断是否成功`

- 教学分类修改 url `/auth/teachtype/update`
  参数：

  ```json
  {
    "tbTeachType.ttid": "分类id",
    "tbTeachType.iconfont": "iconfont的值",
    "tbTeachType.info": "分类描述",
    "tbTeachType.typeName": "分类名称",
    "tbTeachType.enable": "是否启用，只有y/n两种值"
  }
  ```

  应答：`success字段判断是否成功`

- 教学小类查询 url：`/auth/teachsubtype/queryAll`
  参数：`{"page":"参考分页查询对象"}`  
  应答：`datas.list`为小类查询结果数组，`datas.types`为大类查询结果数组

  ```json
  {
    "datas.page": "参考分页对象格式",
    "datas.list": [
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
    "datas.types": [
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

- 教学小类添加 url：`/auth/teachsubtype/add`
  参数：

  ```json
  {
    "tbTeachSubtype.iconfont": "iconfont的值",
    "tbTeachSubtype.info": "小类描述",
    "tbTeachSubtype.subtypeName": "小类类名称",
    "tbTeachSubtype.ttid": "所属大类id"
  }
  ```

  应答：`success字段判断是否成功`

- 教学小类修改 url：`/auth/teachsubtype/update`
  参数：

  ```json
  {
    "tbTeachSubtype.iconfont": "iconfont的值",
    "tbTeachSubtype.info": "小类描述",
    "tbTeachSubtype.sbutypeName": "小类类名称",
    "tbTeachSubtype.ttid": "所属大类id",
    "tbTeachSubtype.tstid": "小类id",
    "tbTeachSubtype.enable": "是否启用，只有y/n两种值"
  }
  ```

  应答：`success字段判断是否成功`

- 教学信息查询 url：`/auth/teachinfo/queryAll`
  参数：`{"page":"参考分页查询对象"}`  
  应答：`datas.list`为信息查询结果数组

  ```json
  {
    "datas.page": "参考分页对象格式",
    "datas.list": [
      {
        "enable": "是否启用，只有y/n两种值",
        "info": "信息描述",
        "lastupdate": "最后修改时间戳",
        "tiid": "信息id",
        "tstid": "所属小类",
        "scid": "链接类型id",
        "link": "链接地址",
        "linktype": {
          "infoValue": "链接类型"
        },
        "subtype": {
          "subtypeName": "小类名称",
          "type": {
            "typeName": "大类名称"
          }
        }
      }
    ]
  }
  ```

- 教学信息添加表单关联信息查询 url：`/auth/teachinfo/queryAddBaseInfo`
  参数：`{}`  
  应答：`datas.types`为大类信息，`datas.infotypes`为链接类型链接类型

  ```json
  {
    "datas.types": [
      {
        "enable": "是否启用，只有y/n两种值",
        "iconfont": "iconfont的值",
        "info": "分类描述",
        "lastupdate": "最后修改时间戳",
        "ttid": "分类id",
        "typeName": "分类名称"
      }
    ],
    "datas.infotypes": [
      {
        "infoCode": "系统信息代码",
        "infoValue": "系统信息值",
        "scid": "信息id",
        "typeCode": "分类代码",
        "lastupdate": "最后修改时间戳"
      }
    ]
  }
  ```

- 教学信息添加 url：`/auth/teachinfo/add`
  参数：

  ```json
  {
    "tbTeachInfo.link": "链接地址",
    "tbTeachInfo.info": "信息描述",
    "tbTeachInfo.scid": "链接类型id",
    "tbTeachInfo.tstid": "所属小类id"
  }
  ```

  应答：`success字段判断是否成功`

- 教学信息修改表单关联信息查询 url：`/auth/teachinfo/queryAddBaseInfo`
  参数：`{"tbTeachInfo.tstid":"所属小类id"}`  
  应答：`datas.types`为大类信息，`datas.subtypes`为小类信息，`datas.infotypes`为链接类型链接类型

  ```json
  {
    "datas.types": [
      {
        "enable": "是否启用，只有y/n两种值",
        "iconfont": "iconfont的值",
        "info": "分类描述",
        "lastupdate": "最后修改时间戳",
        "ttid": "分类id",
        "typeName": "分类名称"
      }
    ],
    "datas.subtypes": [
      {
        "enable": "是否启用，只有y/n两种值",
        "iconfont": "iconfont的值",
        "info": "分类描述",
        "lastupdate": "最后修改时间戳",
        "ttid": "分类id",
        "typeName": "分类名称"
      }
    ],
    "datas.infotypes": [
      {
        "enable": "是否启用，只有y/n两种值",
        "iconfont": "iconfont的值",
        "info": "小类描述",
        "lastupdate": "最后修改时间戳",
        "ttid": "所属大类id",
        "subtypeName": "小类名称",
        "tstid": "小类id"
      }
    ]
  }
  ```

- 教学信息修改 url：`/auth/teachinfo/update`
  参数：

  ```json
  {
    "tbTeachInfo.tiid": "信息id",
    "tbTeachInfo.link": "链接地址",
    "tbTeachInfo.info": "信息描述",
    "tbTeachInfo.scid": "链接类型id",
    "tbTeachInfo.tstid": "所属小类id",
    "tbTeachInfo.enable": "是否启用，只有y/n两种值"
  }
  ```

  应答：`success字段判断是否成功`
