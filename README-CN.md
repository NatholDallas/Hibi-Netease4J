# Hibi-Netease4J
使用到的依赖项
1. Gson

## Usage - Version
- 请求版本
> 此版本仅封装了 HibiAPI 中的网易云请求地址
> 
> 并且提供了将请求中的数据提取 Json 数据,并通过 Gson 反序列化为 JsonElement
> 
> 并且用户可以自己从原生 Json 数据 或 JsonElement 对象中提取信息
> 
> 如何使用? 位于 com.nathol.hibi.netease.Netease 类,里面有详细的 JavaDoc
> 
> 并且封装了 Gson 的 fromJson 操作,你可以自己定义一个 java 对象对他进行反序列化操作
> 
> 已经制作完成
- 反序列化版本
> 此版本较为复杂
> 
> 你可以将 请求到的 Json 数据,通过 Gson 直接反序列化为 Java 对象
> 
> 此 Java 对象为本人自己定义的对象,里面有部分常用的属性
> 
> 此版本较为方便,但是信息不全,但是你依旧可以自己从 com.nathol.hibi.netease.Netease 类
> 
> 中提取原生的 Json 数据与 JsonElement 对象去提取信息
> 
> 还在制作中

鸣谢 : Google 制作的 Gson 工具包