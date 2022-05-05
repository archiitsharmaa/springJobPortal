package com.springJobPortal.jobs;

import java.util.Arrays;
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


@Controller
public class JobController {
	
	@Autowired
	private PostedJobsService postedJobsService;
	
	@Autowired
	private PostedJobsRepository postedJobsRepository;
	
	@Autowired
	private AppliedJobsService appliedJobsService;
	
	@Autowired
	private AppliedJobsRepository appliedJobsRepository;
	
	
	@GetMapping("/postJob")
	public String showEmployerDashboard(Map<String, Object> model, @RequestParam String username, @RequestParam String email){
		
		
		model.put("username",username);
		model.put("email",email);
		
		PostedJobs postedJobs = new PostedJobs();
		model.put("postedJobs", postedJobs);
		
		return "postJob";

	}
	
	@RequestMapping(value = "/process-jobposting", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("postedJobs") PostedJobs postedJobs,
			RedirectAttributes redirectAttributes){
		
		redirectAttributes.addAttribute("username",postedJobs.getEmployerUsername());
		redirectAttributes.addAttribute("email",postedJobs.getEmployerEmail());
		
		postedJobsService.save(postedJobs);
		
	
		return "redirect:/postJob";
	}
	
	
	@GetMapping("/joblist")
	public ModelAndView showjoblist(@RequestParam String username, @RequestParam String email) {
		
		List<PostedJobs> listJobs = postedJobsService.listAll();
		ModelAndView mav = new ModelAndView("joblist");
		mav.addObject("listJobs", listJobs);
		mav.addObject("username", username);
		mav.addObject("email", email);
		return mav;

	}
		
	@GetMapping("/applyJob")
	public String applyJob(Map<String, Object> model, @RequestParam String username, 
			@RequestParam String email, @RequestParam Long id, @RequestParam String jobName){
		
		model.put("username",username);
		model.put("email",email);
		model.put("id",id);
		model.put("jobName",jobName);
		
		
		
		AppliedJobs appliedJobs = new AppliedJobs();
		model.put("appliedJobs", appliedJobs);
		
		return "applyJob";

	}
	
	
	@RequestMapping(value = "/process-jobapplication", method = RequestMethod.POST)
	public String applyJob(@ModelAttribute("appliedJobs") AppliedJobs appliedJobs,
			RedirectAttributes redirectAttributes){
		
		appliedJobsService.save(appliedJobs);
		
		redirectAttributes.addAttribute("username",appliedJobs.getCandidateUsername());
		redirectAttributes.addAttribute("email",appliedJobs.getCandidateEmail());
		
		return "redirect:/joblist";
	}
	
	
	@RequestMapping(value = "/candidateList")
	public String jobViews(Map<String, Object> model, @RequestParam String name, @RequestParam String username,
			@RequestParam String email, @RequestParam int id){
		
		model.put("jobName", name);
		
		model.put("username", username);
		model.put("email", email);
		
		List<AppliedJobs> authors = appliedJobsRepository.displayCandidate(id);
		System.out.println(authors);
		
		
		model.put("values",authors);
	
		
		
		return "candidateList";
	}
	
	
	@RequestMapping(value = "/postedJobs")
	public String postedJobs(Map<String, Object> model, @RequestParam String username,
			@RequestParam String email){
		
		model.put("username", username);
		model.put("email", email);
		
		
		List<PostedJobs> postedJobs = postedJobsRepository.getpostedjobs(username);
		System.out.println(postedJobs);
		
		
		model.put("postedJobs",postedJobs);
	
		
		
		return "postedJobs";
	}
	
	@RequestMapping(value = "/deleteJob")
	public String deleteJob(Map<String, Object> model, @RequestParam String username,
			@RequestParam String email, @RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		postedJobsService.delete(id);
		
		redirectAttributes.addAttribute("username",username);
		redirectAttributes.addAttribute("email",email);
		
		return "postedJobs";
	}
	
	
	
	

	
	

}
