package ink.imimi.BiliDanmuVoter;

import com.ggemo.va.bilidanmakuclient.BiliLiveDanmakuClient;
import com.ggemo.va.bilidanmakuclient.handler.CmdHandler;
import com.ggemo.va.bilidanmakuclient.handler.HandlerHolder;
import com.ggemo.va.bilidanmakuclient.handler.UserCountHandler;
import com.ggemo.va.bililivedanmakuoop.cmddata.DanmakuData;
import com.ggemo.va.bililivedanmakuoop.cmddata.GuardBuyData;
import com.ggemo.va.bililivedanmakuoop.cmddata.SendGiftData;
import com.ggemo.va.bililivedanmakuoop.cmddata.SuperChatData;
import com.ggemo.va.bililivedanmakuoop.handler.*;

public class DanmuClientThread extends Thread {

    public static void oopPrint(long roomId) {
        // OopCmdHandler实现了CmdHandler接口, 本质是将事件字符串转换为对应对象
        OopCmdHandler oopCmdHandler = new OopCmdHandler(roomId);

        // 收到弹幕时打印com.ggemo.bilidanmakuclient.oop.cmddata.DanmakuData对象
        oopCmdHandler.addDanmakuHandler(new DanmakuHandler() {
            @Override
            public void handle(DanmakuData x) {
                //getLogger().info(x.getContent());
                System.out.println(x.getContent());
            }
        });

        // 收到礼物时打印com.ggemo.bilidanmakuclient.oop.cmddata.SendGiftData对象
        oopCmdHandler.addSendGiftHandler(new SendGiftHandler() {
            @Override
            public void handle(SendGiftData x) {
                System.out.println(x);
            }
        });

        // 有观众上舰时打印com.ggemo.bilidanmakuclient.oop.cmddata.GuardBuyData对象
        oopCmdHandler.addGuardBuyHandler(new GuardBuyHandler() {
            @Override
            public void handle(GuardBuyData x) {
                System.out.println(x);
            }
        });

        // 收到醒目留言时打印com.ggemo.bilidanmakuclient.oop.cmddata.SuperChatData对象
        oopCmdHandler.addSuperchatHandler(new SuperChatHandler() {
            @Override
            public void handle(SuperChatData x) {
                System.out.println(x);
            }
        });

        HandlerHolder handlerHolder = new HandlerHolder();

        // 收到房间观众数信息时打印房间观众数
        handlerHolder.addUserCountHandler(x -> System.out.println(x));

        // 使用oopCmdHandler作为handlerHolder的cmdHandler
        handlerHolder.addCmdHandler(oopCmdHandler);

        // 创建BiliLiveDanmakuClient对象,使用房间号和HandlerHolder作为实例化参数
        BiliLiveDanmakuClient client = new BiliLiveDanmakuClient(roomId, handlerHolder);
        client.start();
    }


    public void simplePrint(long roomId) {
        // 需要使用一个HandlerHolder对象,在这个对象里定义响应弹幕的操作
        // HandlerHolder由两部分组成,一部分是处理观众信息的UserCountHandler,一部分是处理其他事件的CmdHandler
        HandlerHolder handlerHolder = new HandlerHolder();

        // 收到房间观众数信息时打印房间观众数
        handlerHolder.addUserCountHandler(new UserCountHandler() {
            @Override
            public void handle(int x) {
                System.out.println(x);
            }
        });

        // 收到事件时打印事件(字符串)
        handlerHolder.addCmdHandler(new CmdHandler() {
            @Override
            public void handle(String x) {
                System.out.println(x);
                //getLogger().info(x);
            }
        });

        // 创建BiliLiveDanmakuClient对象,使用房间号和HandlerHolder作为实例化参数
        BiliLiveDanmakuClient client = new BiliLiveDanmakuClient(roomId, handlerHolder);

        // 开始监听(这个start是个同步操作)
        client.start();
    }

    public void run()
    {
        long roomId = 22700047L;
        simplePrint(roomId);
    }
}
