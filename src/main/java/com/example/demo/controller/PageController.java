package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping(value= {"/challenge","challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());	
		}else {
			model.addAttribute("name","KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", required = false, defaultValue = "0")Integer a,
			@RequestParam(value = "b", required = false, defaultValue = "0")Integer b, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		
		String hm = "h";
		String hasil = "";
		
		if (a==0) {
			hm = "hm";
		}
		for (int i=0; i<a; i++) {
			hm += "m";
		}
		if (b==0) {
			hasil = hm;
		}
		for (int i=0; i<b; i++) {
			hasil += hm + " ";
		}
		model.addAttribute("hasil", hasil);
		return "generator";
	}
}
