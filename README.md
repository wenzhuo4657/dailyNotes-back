# dailyWeb-back
日报程序后端

# 安装

一键安装脚本

`bash <(curl -fsSL https://raw.githubusercontent.com/wenzhuo4657/myScript/main/daily-install.sh)`

演示地址
https://test.wenzhuo4657.org/md-web/



## 变量
```

# 邮箱配置 ，目前仅支持gmail， password不是账号密码，而是gmail的16位应用专属密码
email.enable: true/ false
email.config.from: example@example.com
email.config.to: smtp.example.com
email.config.password: xxxxx   

# 备份
dir.beifen: 备份目录、数据目录
dir.home:  家目录，在一键脚本当中，他用于统一配置安装目录，且  dir.beifen == &dir.home/beifen
```
