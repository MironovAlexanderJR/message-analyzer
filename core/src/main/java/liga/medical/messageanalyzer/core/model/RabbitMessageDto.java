package liga.medical.messageanalyzer.core.model;

import lombok.Data;

@Data
public class RabbitMessageDto {

    private MessageType type;

    private String content;
}
