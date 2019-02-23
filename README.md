# public.projects

## 后台接口说明

- [ajax测试工具](http://demo.ajaxtool.huhuiyu.top)
- [接口统一说明](base.md)
- 接口列表（没有特别说明都需要token信息）
  - 首页echo接口 url：`/`，不需要token  
  参数：`{"echo":"可选参数"}`  
  应答：`message字段为echo参数值,datas.now为系统当前时间戳`  
  - [用户信息接口](user.md)
  - [后台管理信息接口](admin.md)
  - [教学网站前端信息接口](teach.md)