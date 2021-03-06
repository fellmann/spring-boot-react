package de.cronn.demo.react.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.cronn.demo.react.model.DemoResponse;
import de.cronn.demo.react.model.LogMessage;
import de.cronn.demo.react.service.StatusService;

/**
 * Demo Json Api
 *
 * @author Hanno Fellmann, cronn GmbH
 */
@Controller
public class JsonController {
	@Autowired
	StatusService statusService;

	@RequestMapping("/api/logs")
	@ResponseBody
	public List<LogMessage> listNewestLogs(final HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		return statusService.listNewestLogs();
	}

	@RequestMapping("/api/demo")
	@ResponseBody
	public DemoResponse getDemoData(final HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		return new DemoResponse();
	}
}
