package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private static final long serialVersionUID = 2892248514883451461L;

	private Long id;

	private String name;

}
