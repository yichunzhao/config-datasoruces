package com.ynz.demo.configdatasoruces.dao.user;

import com.ynz.demo.configdatasoruces.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
