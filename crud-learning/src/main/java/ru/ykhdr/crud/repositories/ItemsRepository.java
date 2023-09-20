package ru.ykhdr.crud.repositories;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ykhdr.crud.models.Item;
import ru.ykhdr.crud.models.Person;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item,Integer> {

    List<Item> findByOwner(Person owner);

    List<Item> findByName(String name);

    @NotNull Page<Item> findAll(@NotNull Pageable pageable);
}