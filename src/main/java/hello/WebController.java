package hello;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebController implements WebMvcConfigurer {
	@GetMapping("/")
	// public String showForm(PersonForm personForm) {
	// 	return "form";
	// }

	public String showForm() {
		return "kb/kb"; // First kb is the folder, second reffers to the file kb.html
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "form"; // reffers to form.html
		}
		personForm.savePerson("data.txt", personForm);  // See PLAN.md
		return "results"; // reffers to results.html
	}
}
