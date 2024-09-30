package br.com.sps.controller;

import br.com.sps.model.Acquirer;
import org.springframework.web.bind.annotation.RestController;

import br.com.sps.services.impl.AcquirerServiceImpl;
import br.com.sps.util.Media;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("api/acquirer/v1")
public class AcquirerController {
	
	@Autowired
	AcquirerServiceImpl service;
	
	@GetMapping(value = "/{id}",
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	@Operation(summary = "Get Acquirer", description = "retorna um Acquirer de acordo com o Id passado.",
	tags = {"Acquirer"},
	responses = {
			@ApiResponse(description = "Sucess", responseCode = "200",
					content = {@Content(
							mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Acquirer.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public Acquirer getAcquirer(@PathVariable("id") Long id) {
		return service.getAcquirer(id);
	}


	@PostMapping(consumes = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML},
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	@Operation(summary = "Post Acquirer", description = "Cria um Acquirer com as informações enviadas no request.",
	tags = {"Acquirer"},
	responses = {
			@ApiResponse(description = "Sucess", responseCode = "200",
					content = {@Content(
							mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Acquirer.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public Acquirer createAcquirer(@RequestBody Acquirer vo) {
		return service.createAcquirer(vo);
	}
	
	
	@PutMapping(consumes = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML},
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	@Operation(summary = "Update Master", description = "Atualiza um Master de acordo com o Id passado.",
	tags = {"Master"},
	responses = {
			@ApiResponse(description = "Updated", responseCode = "200",
					content = {@Content(
							mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Acquirer.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public Acquirer updateAcquirer(@RequestBody Acquirer vo) {
		return service.updateAcquirer(vo);
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
	public ResponseEntity<?> deleteAcquirer(@PathVariable("id") Long id) {
		service.deleteAcquirer(id);
		return ResponseEntity.noContent().build();
	}
}
