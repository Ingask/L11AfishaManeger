package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class FilmsAfishaItem {
    private int id;
    private String filmName;
    private String filmUrl;
    private String filmGenre;

}
