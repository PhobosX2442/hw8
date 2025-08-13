package dto;

import lombok.*;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {
    private int id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;
    private String api_key;
}
