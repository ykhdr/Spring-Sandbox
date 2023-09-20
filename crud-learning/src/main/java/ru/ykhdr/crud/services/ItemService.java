package ru.ykhdr.crud.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ykhdr.crud.models.Item;
import ru.ykhdr.crud.models.Person;
import ru.ykhdr.crud.repositories.ItemsRepository;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ItemService {
    private final ItemsRepository itemsRepository;

    public List<Item> findByName(String name){
        return itemsRepository.findByName(name);
    }

    public List<Item> findByOwner(Person owner){
        return itemsRepository.findByOwner(owner);
    }


}
