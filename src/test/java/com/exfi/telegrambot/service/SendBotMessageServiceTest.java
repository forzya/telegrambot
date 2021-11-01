package com.exfi.telegrambot.service;

import com.exfi.telegrambot.bot.ExfiTelegramBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.context.TestPropertySource;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {

    private ExfiTelegramBot exfiTelegramBot;
    private SendBotMessageService sendBotMessageService;

    @BeforeEach
    public void init() {
        exfiTelegramBot = Mockito.mock(ExfiTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(exfiTelegramBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.enableHtml(true);

        //when
        sendBotMessageService.sendMessage(chatId, message);

        //then
        Mockito.verify(exfiTelegramBot).execute(sendMessage);
    }

}
