package org.openlab.openlabcustomerservice.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor (access=AccessLevel.PUBLIC)
public class CustomerRequestDTO {
	
	private String id;
	private String name;	
	private String email;

}
