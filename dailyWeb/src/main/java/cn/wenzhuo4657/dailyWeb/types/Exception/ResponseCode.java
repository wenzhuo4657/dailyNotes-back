package cn.wenzhuo4657.dailyWeb.types.Exception;

/**
 * 响应码枚举类，用于定义异常的代码和信息。
 * 1xx - 信息响应
 * 2xx - 成功响应
 * 3xx - 重定向
 * 4xx - 客户端错误
 * 5xx - 服务器错误
 */
public enum ResponseCode {


    ;
    private String info;
    private Integer code;


    ResponseCode(Integer code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "info='" + info + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
