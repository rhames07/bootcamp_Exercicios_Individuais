package br.com.meli.linktracker.controller;

import br.com.meli.linktracker.dto.LinkDto;
import br.com.meli.linktracker.dto.LinkMetricsDto;
import br.com.meli.linktracker.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping("/link")
    public ResponseEntity<LinkDto> addLink(@RequestBody LinkDto linkDto, UriComponentsBuilder builder){
        Long id = service.addLink(linkDto);
        URI uri = builder.path("/link/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/link/{linkId}")
    public ResponseEntity<Void> redirectTo(@PathVariable Long linkId, @RequestParam String senha) {
        String destination = service.redirectTo(linkId, senha);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("https://" + destination)).build();
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkMetricsDto> getMetrics(@PathVariable Long linkId){
        LinkMetricsDto linkMetricsDto = service.getMetrics(linkId);
        return new ResponseEntity<>(linkMetricsDto, HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<LinkMetricsDto> invalidLink(@PathVariable Long linkId){
        LinkMetricsDto linkMetricsDto = service.invalidLink(linkId);
        return new ResponseEntity<>(linkMetricsDto, HttpStatus.OK);
    }
}
