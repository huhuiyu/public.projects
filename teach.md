# 教学网站前端信息接口

- [返回](README.md)

- 大类查询 url：`/teachtype/queryAll`
  参数：`{}`
  应答：`datas.list`为分类查询结果数组

  ```json
  {
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

- 小类查询 url：`/teachsubtype/queryByType`
  参数：`{"tbTeachSubtype.ttid":"大类id"}`
  应答：`datas.list`为小类查询结果数组

  ```json
  {
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
    ]
  }
  ```

- 信息查询 url：`/teachinfo/queryBySubtype`
  参数：`{"tbTeachInfo.tstid":"小类id"}`
  应答：`datas.list`为信息查询结果数组，`datas.config`为配置信息

  ```json
  {
    "datas.list": [
      {
        "enable": "是否启用，只有y/n两种值",
        "info": "信息描述",
        "lastupdate": "最后修改时间戳",
        "link": "链接",
        "linktype": {
          "infoCode": "链接类型code",
          "infoValue": "链接类型"
        },
        "scid": "系统信息id",
        "tiid": "信息id",
        "tstid": "小类id"
      }
    ],
    "datas.config": {
      "infoCode": "链接类型code",
      "infoValue": "链接地址",
      "lastupdate": "最后修改时间戳",
      "scid": "系统信息id",
      "typeCode": "系统类型code"
    }
  }
  ```
