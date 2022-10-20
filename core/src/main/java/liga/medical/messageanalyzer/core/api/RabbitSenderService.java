package liga.medical.messageanalyzer.core.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.messageanalyzer.core.model.RabbitMessageDto;

public interface RabbitSenderService {

    void sendMessage(RabbitMessageDto messageDto, String queue) throws JsonProcessingException;
}
