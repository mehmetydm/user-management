package com.nichelush.user.core.events;

import com.nichelush.user.core.models.User;
import lombok.Builder;
import lombok.Data;

@Data
public class UserRemoveEvent {
    private String id;
}
