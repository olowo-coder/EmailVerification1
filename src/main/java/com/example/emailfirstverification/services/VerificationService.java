package com.example.emailfirstverification.services;

import com.example.emailfirstverification.entity.Users;
import com.example.emailfirstverification.entity.VerificationToken;
import com.example.emailfirstverification.repository.VerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Calendar;

@Service
public class VerificationService {

    private final VerificationRepository verificationRepository;

    @Autowired
    public VerificationService(VerificationRepository verificationRepository) {
        this.verificationRepository = verificationRepository;
    }

    @Transactional
    public VerificationToken findByToken(String token){
        return verificationRepository.findByToken(token);
    }

    @Transactional
    public VerificationToken findByUser(Users user){
        return verificationRepository.findByUser(user);
    }

    @Transactional
    public void save(Users user, String token){
        VerificationToken verificationToken = new VerificationToken(user, token);
        //Set Expiry Date to 24hrs
        verificationToken.setExpiryDate(calculateExpiryDate(24*60));
        verificationRepository.save(verificationToken);
    }

    // Calculate Expiry Date
    private Timestamp calculateExpiryDate(int expiryTimeInMinutes){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Timestamp(cal.getTime().getTime());
    }
}
