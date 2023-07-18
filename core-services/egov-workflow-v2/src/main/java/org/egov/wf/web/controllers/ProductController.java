package org.egov.wf.web.controllers;


import org.egov.wf.request.CatalogRequest;
import org.egov.wf.request.PurchaseRequest;
import org.egov.wf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/egov-wf")
public class ProductController {

    @Autowired
    ProductService service;
    @PostMapping("/catalog/save")
    public ResponseEntity<?> saveCatalog(@RequestBody CatalogRequest request,HttpServletRequest req) {
        return new ResponseEntity<>(service.saveCatalog(request, req), HttpStatus.OK);
    }

    @GetMapping("/catalog/list")
    public ResponseEntity<?> listCatalog(HttpServletRequest request,@RequestParam(required = false) Map<String, String> queryParams) {
        return new ResponseEntity<>(service.listCatalog(request, queryParams),HttpStatus.OK);
    }

    @PostMapping("/catalog/update")
    public ResponseEntity<?> updateCatalog(@RequestParam("id") Long id, HttpServletRequest req,
                                    @RequestBody CatalogRequest request) {
        return new ResponseEntity<>(service.updateCatalog(request, req,id), HttpStatus.OK);
    }

    @PostMapping("/purchase/save")
    public ResponseEntity<?> savePurchase(@RequestBody PurchaseRequest request, HttpServletRequest req) {
        return new ResponseEntity<>(service.savePurchase(request, req), HttpStatus.OK);
    }

    @GetMapping("/purchase/list")
    public ResponseEntity<?> listPurchase(HttpServletRequest request,@RequestParam(required = false) Map<String, String> queryParams) {
        return new ResponseEntity<>(service.listPurchase(request, queryParams),HttpStatus.OK);
    }

    @PostMapping("/purchase/update")
    public ResponseEntity<?> updatePurchase(@RequestParam("id") Long id, HttpServletRequest req,
                                    @RequestBody PurchaseRequest request) {
        return new ResponseEntity<>(service.updatePurchase(request, req,id), HttpStatus.OK);
    }


}
