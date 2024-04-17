package com.example.apollo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apollo.models.Brand;

@RestController
@RequestMapping(path = "/brands")
public class BrandController extends BaseController<Brand> {

}
