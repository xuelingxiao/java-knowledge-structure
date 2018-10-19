package com.xlx.rest.repository;

import com.xlx.rest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Collections;

@Repository
public class UserRepository {

    private final DataSource dataSource;

    @Autowired
    public UserRepository(DataSource dataSource){
        this.dataSource=dataSource;
    }

    public Boolean save(User user){
        System.out.println("Save user: id="+user.getId()+";username="+user.getUsername());
        return true;
    }

    public Collection<User> findAll(){
        return Collections.emptyList();
    }

}
