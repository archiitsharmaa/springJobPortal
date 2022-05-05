package com.springJobPortal.jobs;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.apache.log4j.Logger;

//declares the class config as the controller to map urls 
@Controller
public class JobController {

	private static Logger log = Logger.getLogger(JobController.class.getName());

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
		
		try {

		// seeting values from url parameters
		model.put("username", username);
		model.put("email", email);

		// saves the object from page
		PostedJobs postedJobs = new PostedJobs();
		model.put("postedJobs", postedJobs);

		return "postJob";
		}
		catch (Exception e) {
			log.error("Error with loading post job page");
		}
		
		return null;

	}

	// saves the posted jobs into the database
	@RequestMapping(value = "/process-jobposting", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("postedJobs") PostedJobs postedJobs,
			RedirectAttributes redirectAttributes) {
		
		try {

		// saves the attributes to the url params
		redirectAttributes.addAttribute("username", postedJobs.getEmployerUsername());
		redirectAttributes.addAttribute("email", postedJobs.getEmployerEmail());

		// savs the password
		postedJobsService.save(postedJobs);
		
		log.info("Job posted with jobid "+postedJobs.getId());

		return "redirect:/postJob";
		}
		catch (Exception e) {
			log.error("Error with saving the job posting");
		}
		
		return null;
	}

	// maps to display the joblist
	@GetMapping("/joblist")
	public ModelAndView showjoblist(@RequestParam String username, @RequestParam String email) {

		try {
		// gets the list of all jobs
		List<PostedJobs> listJobs = postedJobsRepository.marketplace(username);

		log.error("logged here");

		ModelAndView mav = new ModelAndView("joblist");
		// add attributes from the config urls
		mav.addObject("listJobs", listJobs);
		mav.addObject("username", username);
		mav.addObject("email", email);
		return mav;
		}
		
		catch (Exception e) {
			log.error("Error with loading job list");
		}
		
		return null;

	}

	// maps to apply job accessed by the job seeker
	@GetMapping("/applyJob")
	public String applyJob(Map<String, Object> model, @RequestParam String username, @RequestParam String email,
			@RequestParam Long id, @RequestParam String jobName) {

		try {
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
		
		catch (Exception e) {
			log.error("Error with loading apply job");
		}
		
		return null;

	}

	// maps to post job application
	@RequestMapping(value = "/process-jobapplication", method = RequestMethod.POST)
	public String applyJob(@ModelAttribute("appliedJobs") AppliedJobs appliedJobs,
			RedirectAttributes redirectAttributes) {

		try {
		// saves the applied jobs
		appliedJobsService.save(appliedJobs);

		// adds param to urls
		redirectAttributes.addAttribute("username", appliedJobs.getCandidateUsername());
		redirectAttributes.addAttribute("email", appliedJobs.getCandidateEmail());

		return "redirect:/joblist";
		}
		catch (Exception e) {
			log.error("Error with processing job application");
		}
		
		return null;
	}

	// displays the candidate list for a particular job
	@RequestMapping(value = "/candidateList")
	public String jobViews(Map<String, Object> model, @RequestParam String name, @RequestParam String username,
			@RequestParam String email, @RequestParam int id) {

		try {
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
		catch (Exception e) {
			log.error("Error with loading candidate list upload");
		}
		
		return null;
	}

	// maps the application for all the posted jobs
	@RequestMapping(value = "/postedJobs")
	public String postedJobs(Map<String, Object> model, @RequestParam String username, @RequestParam String email) {

		try {
		// puts value from the url params
		model.put("username", username);
		model.put("email", email);

		// diaplys all the table from the getposted job
		List<PostedJobs> postedJobs = postedJobsRepository.getpostedjobs(username);

		// puts the value
		model.put("postedJobs", postedJobs);

		return "postedJobs";
		}
		
		catch (Exception e) {
			log.error("Error with loading jobb posting page");
		}
		
		return null;
	}

	// maps the deletion of job
	@RequestMapping(value = "/deleteJob")
	public String deleteJob(Map<String, Object> model, @RequestParam String username, @RequestParam String email,
			@RequestParam Long id, RedirectAttributes redirectAttributes) {

		try {
		// delets the job using id
		postedJobsService.delete(id);

		// add params to the url
		redirectAttributes.addAttribute("username", username);
		redirectAttributes.addAttribute("email", email);

		return "redirect:/postedJobs";
		}
		
		catch (Exception e) {
			log.error("Error with deleting job");
		}
		
		return null;
	}

	// maps the application for all the jobs applied for
	@RequestMapping(value = "/myjobapplication")
	public String myjobapplication(Map<String, Object> model, @RequestParam String username,
			@RequestParam String email) {

		try {
		// puts value from the url params
		model.put("username", username);
		model.put("email", email);

		// displays all the jobs for the fetched username
		List<PostedJobs> postedJobs = postedJobsRepository.getjobapplication(username);

		// puts the value
		model.put("postedJobs", postedJobs);

		return "candidateApplication";
		}
		
		catch (Exception e) {
			log.error("Error with loading my jobs");
		}
		
		return null;
	}

	// controller to withdraw application
	@GetMapping("/withdrawApplication")
	public String withdrawApplication(@RequestParam String username, @RequestParam String email, @RequestParam Long id,
			RedirectAttributes redirectAttributes) {

		try {

			appliedJobsService.deleteApplication(username, id);

			// add params to the url
			redirectAttributes.addAttribute("username", username);
			redirectAttributes.addAttribute("email", email);

			return "redirect:/myjobapplication";
		} catch (Exception e) {
			log.error("Error in withdrawing application");
		}
		return null;
	}

	//updates the job
	@GetMapping("/updateJobPosting")
	public String updateJobPosting(@RequestParam Long jobid, @RequestParam String jobName,
			@RequestParam String companyName, @RequestParam String description, @RequestParam String username,
			@RequestParam String email, Model model) {

		try {
		PostedJobs updateJob = new PostedJobs();
		
		//setting up updated values
		updateJob.setId(jobid);
		updateJob.setJobName(jobName);
		updateJob.setCompanyName(companyName);
		updateJob.setDescription(description);

		model.addAttribute(updateJob);
		
		model.addAttribute(email);
		model.addAttribute(username);

		return "updateJobPosting";
		}
		catch (Exception e) {
			log.error("Error with loading update job");
		}
		
		return null;
		
	}
	
	
	//processing job url
	@RequestMapping(value = "/processjobUpdating", method = RequestMethod.POST)
	public String updateTheJob(@ModelAttribute("postedJobs") PostedJobs postedJobs) {
		
		
		try {

			Long jobid = postedJobs.getId();
			String jobName = postedJobs.getJobName();
			String companyName = postedJobs.getCompanyName();
			String description = postedJobs.getDescription();
			
			//updates in the database
			postedJobsService.updateJob(jobid, jobName, companyName, description);
			
			return "redirect:/welcome"; 
		} catch (Exception e) {
			log.error("Error with processing job update");
		}
		return null;
	}
	
}

