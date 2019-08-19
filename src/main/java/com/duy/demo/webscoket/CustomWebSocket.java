package com.duy.demo.webscoket;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/8/16 13:42
 **/

@ServerEndpoint(value = "/duy/websocket/{username}")
@Component
public class CustomWebSocket {
    private static final Logger log = LoggerFactory.getLogger(CustomWebSocket.class);

    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static int onlineCount = 0;

    private static Map<String,CustomWebSocket> webSocketMap = new ConcurrentHashMap<>();
    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 每个客户端的用户标识
     */
    private String username;

    /**
     * 连接建立成功调用的方法
     *
     * @param session
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        this.session = session;
        this.username = username;
        //加入set中
        webSocketMap.put(username,this);
        //添加在线人数
        addOnlineCount();
        System.out.println(username+"接入。当前在线人数为：" + getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        //从set中删除
        webSocketMap.remove(this.username);
        //在线数减1
        subOnlineCount();
        System.out.println(this.username+"关闭。当前在线人数为：" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用
     *
     * @param dataJson
     */
    @OnMessage
    public void onMessage(String dataJson) {
        JSONObject jo = JSONObject.parseObject(dataJson);
        String username = jo.getString("username");
        String msg = jo.getString("msg");
        System.out.println(this.username+"客户端发送消息：" + msg + "给"+username);
        this.sendMessage(msg, webSocketMap.get(username).session);
    }

    /**
     * 暴露给外部的群发
     *
     * @param message
     * @throws IOException
     */
    public static void sendInfo(String message) throws IOException {
        sendAll(message);
    }

    /**
     * 群发
     *
     * @param message
     */
    private static void sendAll(String message) {
        Arrays.asList(webSocketMap.values().toArray()).forEach(item -> {
            CustomWebSocket customWebSocket = (CustomWebSocket) item;
            //群发
            customWebSocket.sendMessage(message,((CustomWebSocket) item).session);
        });
    }

    /**
     * 发生错误时调用
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("----websocket-------有异常啦");
        error.printStackTrace();
    }

    /**
     * 减少在线人数
     */
    private void subOnlineCount() {
        CustomWebSocket.onlineCount--;
    }

    /**
     * 添加在线人数
     */
    private void addOnlineCount() {
        CustomWebSocket.onlineCount++;
    }

    /**
     * 当前在线人数
     *
     * @return
     */
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    /**
     * 发送信息
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message,Session session){
        //获取session远程基本连接发送文本消息
        try {
            session.getBasicRemote().sendText(message);
            // this.session.getAsyncRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("发送数据错误，msg：{}", message);
        }
    }
}
