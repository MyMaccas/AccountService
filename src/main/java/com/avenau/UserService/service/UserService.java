package com.avenau.UserService.service;

import com.avenau.UserService.models.User;
import com.avenau.UserService.repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@AllArgsConstructor
public class UserService {

    private UserRepo userRepo;

    public User save(User customer) {
        User savedCustomer = userRepo.save(customer);
        return savedCustomer;
    }
    public void remove(User customer) {
        userRepo.delete(customer);
    }

    public void removeOrder(int orderId){

    }
    public User find(int id) {
        Optional<User> foundCustomer = userRepo.findById(id);

        if (!foundCustomer.isPresent()) {
            return null;
        }

        return (User) foundCustomer.get();
    }

    public User find(String name) {
        Optional<User> foundCustomer = userRepo.findByUsername(name);

        if (!foundCustomer.isPresent()) {
            return null;
        }

        return foundCustomer.get();
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public boolean validateLogin(String username, String password) {
        // TODO Auto-generated method stub
        Optional<User> customer = userRepo.findByUsername(username);
        if (customer == null) {
            System.out.println("first");
            return false;
        }


        if (!password.equals(customer.get().getPassword())) {
            System.out.println("second");
            return false;
        }
        System.out.println("third");

        return true;
    }

}
