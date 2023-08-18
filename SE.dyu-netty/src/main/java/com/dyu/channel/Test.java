package com.dyu.channel;

import kotlin.Unit;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.data.FriendInfoImpl;
import net.mamoe.mirai.utils.BotConfiguration;

import java.util.Objects;

/**
 * @author dyu 2021/4/27 20:19
 */
public class Test {
    public static void main(String[] args) {
        Bot bot = Bot.getInstanceOrNull(694973189L);
        if (Objects.isNull(bot) || !bot.isOnline()) {
            bot = BotFactory.INSTANCE.newBot(694973189L, "lanfengye139", configuration -> {
                configuration.fileBasedDeviceInfo();
                configuration.setProtocol(BotConfiguration.MiraiProtocol.ANDROID_PHONE);
            });
            bot.login();
        }
        System.out.println(bot.getFriend(1607077314L).getNick());
        bot.getAsFriend().add(694973188L);
    }
}
