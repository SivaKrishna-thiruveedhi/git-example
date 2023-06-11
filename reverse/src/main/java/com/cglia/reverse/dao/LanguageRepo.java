package com.cglia.reverse.dao;



import com.cglia.reverse.model.Language;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepo extends JpaRepository<Language, Integer> {


	List<Language> findAllById(Object forEach);


}
