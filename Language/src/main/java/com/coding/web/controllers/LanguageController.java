package com.coding.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coding.web.services.LanguageService;

import jakarta.validation.Valid;

import com.coding.web.models.Language;



@Controller
public class LanguageController {
	private final LanguageService languageService;
    
   public LanguageController(LanguageService languageService) {
       this.languageService = languageService;
    }
    @GetMapping("/")
	public String raiz() {
		return "redirect:/languages";
	}
    
    @RequestMapping("/languages")
    public String index(Model model, @ModelAttribute("language") Language language) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "index.jsp";
    }


	@PostMapping("/new")
	public String crearLanguage(@Valid @ModelAttribute("language") Language language, BindingResult resultado) {
		if (resultado.hasErrors()) {
	        
			return "index.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/";
		}
		
	}
	//detalle
	@GetMapping("/detail/{languageId}")
	public String mostrarLanguage(Model viewModel, @PathVariable("languageId") Long languageId) {
		viewModel.addAttribute("language", languageService.findLanguage(languageId));
		return "detail.jsp";
	}

	@GetMapping("/edit/{languageId}")
	public String formualrioEdicion(@ModelAttribute("language") Language language, 
			@PathVariable("languageId") Long languageId,
			Model viewModel) {
		Language language_ = languageService.findLanguage(languageId);
		viewModel.addAttribute("language_", language_);
		return "edit.jsp";
	}
//
	@RequestMapping(value="/edit/{languageId}", method=RequestMethod.PUT)
	public String editarLanguage(@ModelAttribute("language_") Language language, 
			@PathVariable("languageId") Long languageId, Model viewModel,
			BindingResult resultado) {
		if (resultado.hasErrors()) {
			return "edit.jsp";
		} else {
			languageService.updateLanguage(language);
			return "redirect:/";
		}
	}
//	
	/*
	 * @RequestMapping(value="/delete/{languageId}", method=RequestMethod.DELETE)
	 * public String eliminarLanguage(@PathVariable("languageId") Long languageId) {
	 * languageService.deleteLanguage(languageId); return "redirect:/"; }
	 */
	
	//eliminar
	@GetMapping("/delete/{languageId}")
	public String deleteLanguage(@PathVariable("languageId") Long languageId) {
		languageService.deleteLanguage(languageId); 
		return "redirect:/"; 
		
	}

}
