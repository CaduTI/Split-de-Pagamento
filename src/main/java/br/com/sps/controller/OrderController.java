package br.com.sps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sps.data.vo.OrderVO;
import br.com.sps.services.impl.OrderServiceImpl;
import br.com.sps.util.Media;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/order/v1")
@Tag(name = "Subordinate", description = "Order endpoint")
public class OrderController {
	
	@Autowired
	OrderServiceImpl service;
	
	@GetMapping(value = "/{id}",
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	public OrderVO getSplit(@PathVariable("id") Long id) {
		return service.getOrder(id);
	}
	
	@PostMapping(consumes = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML},
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	public OrderVO createSplit(@RequestBody OrderVO vo) {
		return service.createOrder(vo);
	}
	
	@PutMapping(consumes = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML},
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	public OrderVO updateSplit(@RequestBody OrderVO vo) {
		return service.updateOrder(vo);
	}
	
	@DeleteMapping(value = "/{id}",
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	public ResponseEntity<?> deleteSplit(@PathVariable("id") Long id){
		service.deleteOrder(id);
		return ResponseEntity.noContent().build();
	}
}
