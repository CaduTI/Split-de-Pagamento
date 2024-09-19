package br.com.sps.controller;

import br.com.sps.model.Master;
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

import br.com.sps.services.impl.MasterServiceImpl;
import br.com.sps.util.Media;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/master/v1")
@Tag(name = "Master", description = "Master endpoint.")
public class MasterController {
	
	@Autowired
	MasterServiceImpl service;
	
	@GetMapping(value = "/{id}",
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	@Operation(summary = "Get Master", description = "retorna um Master de acordo com o Id passado.",
	tags = {"Master"},
	responses = {
			@ApiResponse(description = "Sucess", responseCode = "200",
					content = {@Content(
							mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Master.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public Master getMaster(@PathVariable("id") Long id) {
		return service.getMaster(id);
	}
	
	@PostMapping(consumes = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML},
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	@Operation(summary = "Post Master", description = "Cria um Master com as informações enviadas no request.",
	tags = {"Master"},
	responses = {
			@ApiResponse(description = "Sucess", responseCode = "200",
					content = {@Content(
							mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Master.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public Master createMaster(@RequestBody Master vo) {
		return service.createMaster(vo);
	}
	
	@PutMapping(consumes = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML},
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	@Operation(summary = "Update Master", description = "Atualiza um Master de acordo com o Id passado.",
	tags = {"Master"},
	responses = {
			@ApiResponse(description = "Updated", responseCode = "200",
					content = {@Content(
							mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Master.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public Master updateMaster(@RequestBody Master vo) {
		return service.updateMaster(vo);
	}
	
	
	@DeleteMapping(value = "/{id}",
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	@Operation(summary = "Delete Carrinho", description = "Deleta um Master de acordo com o Id passado.",
	tags = {"Master"},
	responses = {
			@ApiResponse(description = "No Content", responseCode = "204"),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public ResponseEntity<?> deleteMaster(@PathVariable("id") Long id){
		service.deleteMaster(id);
		return ResponseEntity.noContent().build();
	}
}
