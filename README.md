# 登录换取token
http://localhost:8081/oauth/token?grant_type=password&username=tang&password=1234&scope=backend&client_secret=secret&client_id=clientId

# 刷新token
http://localhost:8081/oauth/token?grant_type=refresh_token&refresh_token=e0a8d876-0039-4d29-9d1f-dcd9dd5eec80&client_id=clientId&client_secret=secret
