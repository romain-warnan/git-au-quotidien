package fr.insee.bar.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/image")
public class ImageController {

	@GetMapping
	public String image() {
		return "image";
	}

	@GetMapping("/{file:.+}")
	public ResponseEntity<byte[]> imageFooter(@PathVariable("file") String file) {
		Path path = Paths.get("Z:", "images", file);
		return ResponseEntity
			.ok()
			.cacheControl(CacheControl.maxAge(30, TimeUnit.DAYS))
			.contentType(MediaType.IMAGE_PNG)
			.body(imageAsByteArray(path));
	}

	private static byte[] imageAsByteArray(Path path) {
		try (InputStream in = FileUtils.openInputStream(path.toFile())) {
			return IOUtils.toByteArray(in);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
