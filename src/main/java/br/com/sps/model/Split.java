package br.com.sps.model;

import lombok.*;

import java.util.Date;

@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Split {

    private Long idSplit;
    private Long idAcquirer;
    private Float acquirerRate;
    private Float acquirerCommission;
    private Long idMaster;
    private Float masterRate;
    private Float masterCommission;
    private Long idSubordinate;
    private Float subordinateRate;
    private Float subordinateCommission;
    private Float TotalAmount;
    private Date createdAt;
    private Date updatedAt;
}
