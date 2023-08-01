package com.example.login.service.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "COD_POS")
@Getter
@Setter
public class CodPosEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COD_POS")
	Long idCodPos;
	@Column(name = "CP")
	Long cp;
	@ManyToOne
	@JoinColumn(name = "ID_MUNICIPIO")
	MunicipioEntity municipioEntity;
}
