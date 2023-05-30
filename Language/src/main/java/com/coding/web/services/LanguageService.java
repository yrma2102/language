package com.coding.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.web.models.Language;
import com.coding.web.repositories.ILanguageRepo;

@Service
public class LanguageService {

    private final ILanguageRepo languageRepo;
    
    public LanguageService(ILanguageRepo languageRepo) {
        this.languageRepo = languageRepo;
    }
 
    public List<Language> allLanguages() {
        return languageRepo.findAll();
    }
 
    public Language createLanguage(Language l) {
        return languageRepo.save(l);
    }

    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepo.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
    public Language updateLanguage(Long id,String name,String creator, Double version) {
        Optional<Language> optionalLanguage = languageRepo.findById(id);
        if(optionalLanguage.isPresent()) {
        	Language languageToUpdate = optionalLanguage.get();
        	languageToUpdate.setName(name);
        	languageToUpdate.setCreator(creator);
        	languageToUpdate.setCurrentVersion(version);

        	languageRepo.save(languageToUpdate);
            return languageToUpdate;
        } else {
            return null;
        }
    }

	public Language updateLanguage(Language l) {
		Language actualizarLanguage = findLanguage(l.getId());
		actualizarLanguage.setName(l.getName());
		actualizarLanguage.setCreator(l.getCreator());
		actualizarLanguage.setCurrentVersion(l.getCurrentVersion());

		languageRepo.save(actualizarLanguage);
		return actualizarLanguage;
	
	}
    
	public void deleteLanguage(Long id) {
		languageRepo.deleteById(id);
	}
}
