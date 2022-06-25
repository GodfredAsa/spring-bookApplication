package io.degreat.bookApplication.Repository;

import io.degreat.bookApplication.Enumeration.Role;
import io.degreat.bookApplication.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    //    update Role Method
    @Modifying
    @Query( "update User set role = :role where username = :username")
     void updateUserRole(@Param("username") String username, @Param("role") Role role);
}
