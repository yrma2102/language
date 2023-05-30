package com.coding.web.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.web.models.Language;
@Repository
public interface ILanguageRepo extends CrudRepository<Language, Long>{

    List<Language> findAll();

    List<Language> findByNameContaining(String search);

    Long countByNameContaining(String search);

    Long deleteByNameStartingWith(String search);
}
