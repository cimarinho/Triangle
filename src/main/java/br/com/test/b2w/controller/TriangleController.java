package br.com.test.b2w.controller;

import br.com.test.b2w.model.Triangle;
import br.com.test.b2w.model.TriangleValidator;
import br.com.test.b2w.service.TriangleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import static br.com.test.b2w.controller.Endpoints.ROOT;

@RestController
@Slf4j
@RequestMapping(ROOT)
public class TriangleController {

    @Autowired
    TriangleValidator triangleValidator;

    @Autowired
    TriangleService triangleService;

    @RequestMapping(value = "/triangle", method = RequestMethod.POST)
    public @ResponseBody long total(@Valid @RequestBody Triangle triangle) {
        triangleValidator.validate(triangle);
        return triangleService.total(triangle);
    }
}
