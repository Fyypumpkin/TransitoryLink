package cn.fyypumpkin.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author juntuan
 * @date 2020-05-19
 */
@Builder
@Data
public class Response {
    Status status;
    String msg;
    Object data;

    public static Response ok() {
        return Response.builder().status(Status.SUCCESS).build();
    }

    public static Response ok(Object data) {
        return Response.builder().status(Status.SUCCESS).data(data).build();
    }

    public static String failed(){
        return "404";
    }

    public static String index(){
        return "index";
    }

    public static Response failed(String msg) {
        return Response.builder().status(Status.FAILED).msg(msg).build();
    }

    public enum Status {
        SUCCESS,
        FAILED
    }
}
