package com.exfi.telegrambot.command;

public enum CommandName {

    START("/start"),
    STOP("/stop"),
    STAT("/stat"),
    HELP("/help"),
    NO("/no");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

}
