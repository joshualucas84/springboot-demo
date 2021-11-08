package com.example.demo.controller;

import com.example.demo.model.DemoResult;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@Validated
public class DemoRestController {

  @Autowired
  private DemoService demoService;

  public DemoRestController(DemoService sieveService) {
    this.demoService = demoService;
  }

  @GetMapping(path = "primefind/{n}", produces = "application/JSON")
  public ResponseEntity<DemoResult> getData(
          @Valid
          @PathVariable("n")
          @NotNull
          @Min(value = 0L , message="must be larger than 0" ) int n) {

    return new ResponseEntity<>(demoService.getSieveResult(n), HttpStatus.OK);
  }
    @ExceptionHandler
    public String constraintViolationHandler(ConstraintViolationException ex) {
        return ex.getConstraintViolations().iterator().next()
                .getMessage();
    }
}
