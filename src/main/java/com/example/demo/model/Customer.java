package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data//genera getters y setters de todos los atributos de la clase
@AllArgsConstructor//genera un constructor con todos los atributos de la clase
public class Customer {
    //atributos
    @NonNull
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
