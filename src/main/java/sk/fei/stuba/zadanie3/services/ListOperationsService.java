package sk.fei.stuba.zadanie3.services;

import org.springframework.stereotype.Service;

@Service
public interface ListOperationsService {

    void listAll();
    int  findLastID();
}
