一个短连接服务
web(DTO) -> service(DO) -> repository(Entity)

[x] 请求

[x] 注册

[ ] log

[x] 跨域（不受浏览器同源策略限制，同源策略只针对 Dom, Ajax, Cookie, LocalStorage, IndexDb）

[ ] 接入登陆账号

[ ] 短连接分级

[ ] 管理后台

[ ] 访问控制

[ ] 设备跳转

[ ] 地区跳转

[ ] 时间段跳转

[ ] 参数跳转
 

```jshelllanguage
curl -d '{"longUri":"http://www.baidu.com","redirectType":1, "transitoryType":1}' -H 'Content-Type:
 
application/json' "http://127.0.0.1:7001/pumpkin/register"
{"status":"SUCCESS","msg":null,"data":{"shortUri":"0018xI6U","redirectType":1,"longUri":"http://www.youzan.com","expireDate":"Thu May 20 13:21:43 CST 2021"}}%                                                                                                           
```

chrome 访问 http://127.0.0.1:7001/pumpkin/0018xI6U

