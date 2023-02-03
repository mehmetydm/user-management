package com.nichelush.user.query.api.repositories;

import com.nichelush.user.core.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
