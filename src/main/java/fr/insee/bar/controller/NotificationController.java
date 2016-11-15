package fr.insee.bar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import fr.insee.bar.service.NotificationService;

@Controller
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@GetMapping("/notification")
	@ResponseBody
	public DeferredResult<String> notification(DeferredResult<String> result) {
		notificationService.start(result);
		return result;
	}
}
