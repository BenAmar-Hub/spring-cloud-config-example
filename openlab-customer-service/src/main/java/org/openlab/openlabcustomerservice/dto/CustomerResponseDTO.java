package org.openlab.openlabcustomerservice.dto;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Repository

@Data @NoArgsConstructor @AllArgsConstructor
public class CustomerResponseDTO {
	private String id;
	private String name;	
	private String email;

}
