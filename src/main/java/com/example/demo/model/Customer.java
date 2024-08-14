package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;

@Data//genera getters y setters de todos los atributos de la clase
@AllArgsConstructor//genera un constructor con todos los atributos de la clase
@NoArgsConstructor//Genera un constructor vació
@Builder//Utiliza el patron de diseño builder

//mapear la clase a la BD
@Entity
@Table(name="locals")

public class Customer {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String email;
}
