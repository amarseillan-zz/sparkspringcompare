package ar.edu.itba.it.amarseillan.ab.start;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;
import ar.edu.itba.it.amarseillan.ab.domain.dao.PostRepository;

public class App {

	public static void main(String[] args) {
		Spark.setPort(8080);

		Spark.get("/index", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("posts", PostRepository.getInstance().getAll());

			// The hello.ftl file is located in directory:
			// src/test/resources/spark/template/freemarker
				return new ModelAndView(attributes, "index.ftl");
			}, new FreeMarkerEngine());
	}
}
