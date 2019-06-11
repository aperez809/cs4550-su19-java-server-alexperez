package com.example.myapp.repositories;

import com.example.myapp.models.User;
import org.springframework.data.repository.*;

public class UserRepository extends CrudRepository<User, Integer>{

}
