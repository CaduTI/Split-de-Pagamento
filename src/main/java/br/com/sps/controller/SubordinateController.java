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

import br.com.sps.data.vo.SubordinateVO;
import br.com.sps.services.impl.SubordinateServiceImpl;
import br.com.sps.util.Media;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/subordinate/v1")
@Tag(name = "Subordinate", description = "Subordinate endpoint")
public class SubordinateController {

	@Autowired
	private SubordinateServiceImpl service;
	
	
	@GetMapping(value = "/{id}",
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	@Operation(summary = "Get Subordinate", description = "retorna um Carrinho de acordo com o Id passado.",
	tags = {"Subordinate"},
	responses = {
			@ApiResponse(description = "Sucess", responseCode = "200",
					content = {@Content(
							mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SubordinateVO.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public SubordinateVO getSubordinate(@PathVariable("id") Long id) {
		return service.getSubordinate(id);
	}
	
	@PostMapping(consumes = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML},
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	@Operation(summary = "Post Carrinho", description = "Cria um Carrinho com as informações enviadas no request.",
	tags = {"Carrinho"},
	responses = {
			@ApiResponse(description = "Sucess", responseCode = "200",
					content = {@Content(
							mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SubordinateVO.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public SubordinateVO createSubordinate(@RequestBody SubordinateVO vo){
		return service.createSubordinate(vo);
	}
	
	@PutMapping(
			consumes = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML},
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	@Operation(summary = "Update Carrinho", description = "Atualiza um Carrinho de acordo com o Id passado.",
	tags = {"Carrinho"},
	responses = {
			@ApiResponse(description = "Updated", responseCode = "200",
					content = {@Content(
							mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SubordinateVO.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public SubordinateVO updateSubordinate(@RequestBody SubordinateVO vo){
		return service.updateSubordinate(vo);
		
	}
	
	@DeleteMapping(value = "/{id}",
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	@Operation(summary = "Delete Carrinho", description = "Deleta um Carrinho de acordo com o Id passado.",
	tags = {"Carrinho"},
	responses = {
			@ApiResponse(description = "No Content", responseCode = "204"),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public ResponseEntity<?> deleSubordinate(@PathVariable("id") Long id) {
		service.deleteSubordinate(id);
		return ResponseEntity.noContent().build();
	}
}
