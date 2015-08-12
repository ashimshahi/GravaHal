package org.purushree.gravahal;

import java.util.Locale;

import org.purushree.gravahal.game.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("lastState")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@ModelAttribute("lastState")
	public Game getLastState() {
		return new Game();
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@RequestParam(value = "changedIndex", required=false) Integer changedIndex, @ModelAttribute("lastState") Game lastState, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		if (changedIndex != null) {
			lastState.updateGame(changedIndex.intValue());
		}
		
		model.addAttribute("lastState", lastState);
		
		return "home";
	}
	
}
