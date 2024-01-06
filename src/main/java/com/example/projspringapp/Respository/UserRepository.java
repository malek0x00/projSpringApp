package com.example.projspringapp.Respository;

import com.example.projspringapp.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Page<User> findAll(Pageable p);
    public User save(User user);
    public User findUserById(Long id);
    public User findUserByEmailIsAndPasswordIs(String email, String password);



}
