package ca.bank.of.canada.weather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	private final ModelAndView HOME = new ModelAndView("home");

	@RequestMapping(value = "/weather", method = RequestMethod.GET)
	public ModelAndView displayHomePage() {
		return HOME;
	}

}
