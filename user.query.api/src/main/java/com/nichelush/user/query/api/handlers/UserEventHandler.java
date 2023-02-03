package com.nichelush.user.query.api.handlers;

import com.nichelush.user.core.events.UserRegisteredEvent;
import com.nichelush.user.core.events.UserRemoveEvent;
import com.nichelush.user.core.events.UserUpdateEvent;

public interface UserEventHandler {
    void on(UserRegisteredEvent event);
    void on(UserUpdateEvent event);
    void on(UserRemoveEvent event);
}
