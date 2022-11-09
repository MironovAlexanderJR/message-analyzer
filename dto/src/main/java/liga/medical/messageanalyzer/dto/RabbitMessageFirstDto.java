package liga.medical.messageanalyzer.dto;

import lombok.Data;

@Data
public class RabbitMessageFirstDto {

    long id;

    String type;

    String description;
}
