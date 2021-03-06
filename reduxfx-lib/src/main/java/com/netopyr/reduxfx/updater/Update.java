package com.netopyr.reduxfx.updater;

import javaslang.collection.Array;
import javaslang.collection.Seq;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;

public final class Update<STATE> {

    public static <T> Update<T> of(T state) {
        return new Update<>(state);
    }

    public static <T> Update<T> of(T state, Command... commands) {
        return new Update<>(state, Array.of(commands));
    }

    @SafeVarargs
    public static <T> Update<T> of(T state, Seq<Command>... commands) {
        return new Update<>(state, commands);
    }

    private final STATE state;
    private final Seq<Command> commands;

    @SafeVarargs
    private Update(STATE state, Seq<Command>... commands) {
        this.state = state;
        this.commands = Arrays.stream(commands).reduce(Array.empty(), Seq::appendAll);
    }

    public STATE getState() {
        return state;
    }

    public Seq<Command> getCommands() {
        return commands;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("state", state)
                .append("commands", commands)
                .toString();
    }
}
