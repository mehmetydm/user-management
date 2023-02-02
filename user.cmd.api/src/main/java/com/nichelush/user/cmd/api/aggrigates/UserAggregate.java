package com.nichelush.user.cmd.api.aggrigates;

import com.nichelush.user.cmd.api.commands.RegisterUserCommand;
import com.nichelush.user.cmd.api.commands.RemoveUserCommand;
import com.nichelush.user.cmd.api.commands.UpdateUserCommand;
import com.nichelush.user.cmd.api.security.PasswordEncoder;
import com.nichelush.user.cmd.api.security.PasswordEncoderImpl;
import com.nichelush.user.core.events.UserRegisteredEvent;
import com.nichelush.user.core.events.UserRemoveEvent;
import com.nichelush.user.core.events.UserUpdateEvent;
import com.nichelush.user.core.models.User;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class UserAggregate {
    @AggregateIdentifier
    private String id;
    private User user;

    private final PasswordEncoder passwordEncoder;
    public UserAggregate() {
        passwordEncoder = new PasswordEncoderImpl();
    }
    @CommandHandler
    public UserAggregate(RegisterUserCommand command){
        var newUser = command.getUser();
        newUser.setId(command.getId());

        var password = newUser.getAccount().getPassword();
        passwordEncoder = new PasswordEncoderImpl();
        var hashedPassword = passwordEncoder.hashPassword(password);
        newUser.getAccount().setPassword(hashedPassword);

        var event = UserRegisteredEvent.builder()
                .id(id)
                .user(user)
                .build();
        AggregateLifecycle.apply(event);
    }
    @CommandHandler
    public void handle(UpdateUserCommand command){
        var updateUser = command.getUser();
        updateUser.setId(command.getId());

        var password = updateUser.getAccount().getPassword();
        var hashedPassword = passwordEncoder.hashPassword(password);
        updateUser.getAccount().setPassword(hashedPassword);

        var event = UserUpdateEvent.builder()
                .id(UUID.randomUUID().toString())
                .user(updateUser)
                .build();
        AggregateLifecycle.apply(event);
    }
    @CommandHandler
    public void handle(RemoveUserCommand command){
        var event = new UserRemoveEvent();
        event.setId(command.getId());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UserRegisteredEvent event){
        this.id = event.getId();
        this.user = event.getUser();
    }
    @EventSourcingHandler
    public void on(UserUpdateEvent event){
        this.user = event.getUser();
    }
    @EventSourcingHandler
    public void on(UserRemoveEvent event){
        AggregateLifecycle.markDeleted();
    }
}