package br.com.sps.controller;

import br.com.sps.dtos.response.TransactionResponse;
import br.com.sps.model.Subordinate;
import br.com.sps.model.Transactions;
import br.com.sps.dtos.request.TransactionRequest;
import br.com.sps.services.impl.TransactionServiceImpl;
import br.com.sps.util.Media;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/transaction/v1")
public class TransactionController {

    @Autowired
    TransactionServiceImpl service;


    @GetMapping(value = "/{id}",
            produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
    @Operation(summary = "Get Subordinate", description = "retorna um Carrinho de acordo com o Id passado.",
            tags = {"Subordinate"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TransactionResponse.class))
                            )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public Transactions getTransactions(@PathVariable("id") Long id) throws SQLException {
        return service.FindTransactionById(id);
    }

    @PostMapping(consumes = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML},
            produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
    @Operation(summary = "Post Carrinho", description = "Cria um Carrinho com as informações enviadas no request.",
            tags = {"Subordinate"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TransactionResponse.class))
                            )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public TransactionResponse createTransactions(@RequestBody TransactionRequest model){
        return service.createTransaction(model);
    }


    @PutMapping(consumes = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML},
            produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
    @Operation(summary = "Update Carrinho", description = "Atualiza um Carrinho de acordo com o Id passado.",
            tags = {"Carrinho"},
            responses = {
                    @ApiResponse(description = "Updated", responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TransactionResponse.class))
                            )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public TransactionResponse updateTransactions(@RequestBody TransactionRequest model){
        return service.createTransaction(model);
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
    public ResponseEntity<?> deleteTransactions(@PathVariable("id") Long id) throws SQLException {
        service.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
