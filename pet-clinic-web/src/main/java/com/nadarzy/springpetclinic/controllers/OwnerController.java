package com.nadarzy.springpetclinic.controllers;

import com.nadarzy.springpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/owners")
@Controller
public class OwnerController {

  private final OwnerService ownerService;

  public OwnerController(OwnerService ownerService) {
    this.ownerService = ownerService;
  }

  @RequestMapping({"/", "", "/index", "/index.html"})
  public String listOwners(Model model) {
    model.addAttribute("owners", ownerService.findAll());

    return "owners/index";
  }

  @GetMapping("/{ownerId}")
  public ModelAndView findOwners(@PathVariable Long ownerId) {
    ModelAndView view = new ModelAndView("owners/ownerDetails");
    view.addObject(this.ownerService.findById(ownerId));
    return view;
  }
}
