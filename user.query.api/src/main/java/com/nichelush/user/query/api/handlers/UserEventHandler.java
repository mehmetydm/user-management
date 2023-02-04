package com.nichelush.user.query.api.handlers;

import com.nichelush.user.core.events.UserRegisteredEvent;
import com.nichelush.user.core.events.UserRemovedEvent;
import com.nichelush.user.core.events.UserUpdatedEvent;

public interface UserEventHandler {
    void on(UserRegisteredEvent event);
    void on(UserUpdatedEvent event);
    void on(UserRemovedEvent event);
}
