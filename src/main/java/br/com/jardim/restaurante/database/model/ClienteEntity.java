package br.com.jardim.restaurante.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "/cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer telefone;
    private String endereco;

    @OneToMany(mappedBy = "cliente")
    private List<PedidoEntity> pedidos;
}
