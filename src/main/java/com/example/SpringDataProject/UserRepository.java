package com.example.SpringDataProject;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<Customer,Integer>
{

}