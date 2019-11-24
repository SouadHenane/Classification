package com.esisba2019.finalproject2019.service.repository;

import org.springframework.data.repository.CrudRepository;

import com.esisba2019.finalproject2019.model.ConfirmationToken;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {
	ConfirmationToken findByConfirmationToken(String confirmationToken);
}
