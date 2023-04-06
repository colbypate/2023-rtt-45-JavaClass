package springexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FileUploadController {
    @GetMapping("/fileUpload")
    public ModelAndView fileUpload() throws IOException {
        ModelAndView response = new ModelAndView("fileUpload");

        return response;
    }

    @PostMapping("/fileUpload")
    public ModelAndView fileUpload(@RequestParam MultipartFile fileUpload) throws IOException {
        ModelAndView response = new ModelAndView("fileUpload");

        File target = new File("./src/main/webapp/pub/images/" + fileUpload.getOriginalFilename());
         log.debug(target.getAbsolutePath());
        FileUtils.copyInputStreamToFile(fileUpload.getInputStream(), target);

        response.addObject("fileUrl", "/pub/images/" + fileUpload.getOriginalFilename());

        return response;
    }

}
