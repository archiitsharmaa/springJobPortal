package com.springJobPortal.jobs;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//declares the class config as the controller to map urls 
@Controller
public class JobController {

	// accesses the service layer in the jpa for the postedjobs entity
	@Autowired
	private PostedJobsService postedJobsService;

	// accesses the repository layer in the jpa for the postedjobs entity
	@Autowired
	private PostedJobsRepository postedJobsRepository;

	// accesses the service layer in the jpa for the appliedjob entity
	@Autowired
	private AppliedJobsService appliedJobsService;

	// accesses the repository layer in the jpa for the appliedjob entity
	@Autowired
	private AppliedJobsRepository appliedJobsRepository;

	// mapping to post job accessed by only employer
	@GetMapping("/postJob")
	public String showEmployerDashboard(Map<String, Object> model, @RequestParam String username,
			@RequestParam String email) {

		// seeting values from url parameters
		model.put("username", username);
		model.put("email", email);

		// saves the object from page
		PostedJobs postedJobs = new PostedJobs();
		model.put("postedJobs", postedJobs);

		return "postJob";

	}

	// saves the posted jobs into the database
	@RequestMapping(value = "/process-jobposting", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("postedJobs") PostedJobs postedJobs,
			RedirectAttributes redirectAttributes) {

		// saves the attributes to the url params
		redirectAttributes.addAttribute("username", postedJobs.getEmployerUsername());
		redirectAttributes.addAttribute("email", postedJobs.getEmployerEmail());

		// savs the password
		postedJobsService.save(postedJobs);

		return "redirect:/postJob";
	}

	// maps to display the joblist
	@GetMapping("/joblist")
	public ModelAndView showjoblist(@RequestParam String username, @RequestParam String email) {

		// gets the list of all jobs
		List<PostedJobs> listJobs = postedJobsService.listAll();
		ModelAndView mav = new ModelAndView("joblist");
		// add attributes from the config urls
		mav.addObject("listJobs", listJobs);
		mav.addObject("username", username);
		mav.addObject("email", email);
		return mav;

	}

	// maps to apply job accessed by the job seeker
	@GetMapping("/applyJob")
	public String applyJob(Map<String, Object> model, @RequestParam String username, @RequestParam String email,
			@RequestParam Long id, @RequestParam String jobName) {

		// adds attributes from the url params
		model.put("username", username);
		model.put("email", email);
		model.put("id", id);
		model.put("jobName", jobName);

		// sets the obejct from the form
		AppliedJobs appliedJobs = new AppliedJobs();
		model.put("appliedJobs", appliedJobs);

		return "applyJob";

	}

	// maps to post job application
	@RequestMapping(value = "/process-jobapplication", method = RequestMethod.POST)
	public String applyJob(@ModelAttribute("appliedJobs") AppliedJobs appliedJobs,
			RedirectAttributes redirectAttributes) {

		// saves the applied jobs
		appliedJobsService.save(appliedJobs);

		// adds param to urls
		redirectAttributes.addAttribute("username", appliedJobs.getCandidateUsername());
		redirectAttributes.addAttribute("email", appliedJobs.getCandidateEmail());

		return "redirect:/joblist";
	}

	// displays the candidate list for a particular job
	@RequestMapping(value = "/candidateList")
	public String jobViews(Map<String, Object> model, @RequestParam String name, @RequestParam String username,
			@RequestParam String email, @RequestParam int id) {

		// puts the attribute from the url
		model.put("jobName", name);
		model.put("username", username);
		model.put("email", email);

		// gets the detail from the job id
		List<AppliedJobs> authors = appliedJobsRepository.displayCandidate(id);

		// putting value
		model.put("values", authors);

		return "candidateList";
	}

	// maps the application for all the posted jobs
	@RequestMapping(value = "/postedJobs")
	public String postedJobs(Map<String, Object> model, @RequestParam String username, @RequestParam String email) {

		// puts value from the url params
		model.put("username", username);
		model.put("email", email);

		// diaplys all the table from the getposted job
		List<PostedJobs> postedJobs = postedJobsRepository.getpostedjobs(username);
		System.out.println(postedJobs);

		// puts the value
		model.put("postedJobs", postedJobs);

		return "postedJobs";
	}

	// maps the deletion of job
	@RequestMapping(value = "/deleteJob")
	public String deleteJob(Map<String, Object> model, @RequestParam String username, @RequestParam String email,
			@RequestParam Long id, RedirectAttributes redirectAttributes) {

		// delets the job using id
		postedJobsService.delete(id);

		// add params to the url
		redirectAttributes.addAttribute("username", username);
		redirectAttributes.addAttribute("email", email);

		return "postedJobs";
	}

}
