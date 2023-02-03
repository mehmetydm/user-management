package com.nichelush.user.query.api.handlers;

import com.nichelush.user.core.events.UserRegisteredEvent;
import com.nichelush.user.core.events.UserRemoveEvent;
import com.nichelush.user.core.events.UserUpdateEvent;
import com.nichelush.user.query.api.repositories.UserRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("user-group")
public class UserEventHandlerImpl implements UserEventHandler{

    private final UserRepository userRepository;

    @Autowired
    public UserEventHandlerImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @EventHandler
    @Override
    public void on(UserRegisteredEvent event) {
        userRepository.save(event.getUser());
    }
    @EventHandler
    @Override
    public void on(UserUpdateEvent event) {
        userRepository.save(event.getUser());
    }
    @EventHandler
    @Override
    public void on(UserRemoveEvent event) {
        userRepository.deleteById(event.getId());
    }
}
