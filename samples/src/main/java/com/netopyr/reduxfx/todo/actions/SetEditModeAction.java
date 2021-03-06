package com.netopyr.reduxfx.todo.actions;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * A {@code SetEditModeAction} is passed to the {@link com.netopyr.reduxfx.todo.updater.Updater} when the
 * {@code edit}-flag of a {@link com.netopyr.reduxfx.todo.state.TodoEntry} should be changed. The {@code edit}-flag
 * signals, if the item is in editing- or readonly-mode.
 */
public final class SetEditModeAction implements Action {

    private final int id;
    private final boolean value;

    SetEditModeAction(int id, boolean value) {
        this.id = id;
        this.value = value;
    }

    /**
     * This is the getter for the {@code id} of the {@link com.netopyr.reduxfx.todo.state.TodoEntry} which
     * {@code edit}-flag needs to be changed.
     *
     * @return the {@code id}
     */
    public int getId() {
        return id;
    }

    /**
     * This is the getter of the new value for the {@code edit}-flag.
     *
     * @return the new value
     */
    public boolean isValue() {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("value", value)
                .toString();
    }
}
